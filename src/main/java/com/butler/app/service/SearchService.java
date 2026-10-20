package com.butler.app.service;

import com.butler.app.entities.Entry;
import com.butler.app.repositories.EntryRepository;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SearchService {

    private final ElasticsearchService elasticsearchService;
    private final EntryRepository entryRepository;
    private final CurrentUserService currentUserService;

    public SearchService(
        ElasticsearchService elasticsearchService,
        EntryRepository entryRepository,
        CurrentUserService currentUserService
    ) {
        this.elasticsearchService = elasticsearchService;
        this.entryRepository = entryRepository;
        this.currentUserService = currentUserService;
    }

    public List<EntrySearchResult> searchEntries(Authentication authentication, String query, int size) {
        requireElasticsearch();
        UUID familyId = resolveFamilyId(authentication);
        try {
            return elasticsearchService.searchEntries(query, familyId, size).stream()
                .map(this::toResult)
                .toList();
        } catch (IOException exception) {
            throw searchUnavailable(exception);
        }
    }

    @Transactional(readOnly = true)
    public int reindexEntries(Authentication authentication) {
        requireElasticsearch();
        UUID familyId = resolveFamilyId(authentication);
        List<Entry> entries = entryRepository.findAllByAccount_Family_Id(familyId);
        try {
            elasticsearchService.deleteEntriesForFamily(familyId);
            for (Entry entry : entries) {
                elasticsearchService.indexEntry(toDocument(entry));
            }
        } catch (IOException exception) {
            throw searchUnavailable(exception);
        }
        return entries.size();
    }

    private UUID resolveFamilyId(Authentication authentication) {
        return currentUserService.requireCurrentUser(authentication).getFamily().getId();
    }

    private EntrySearchDocument toDocument(Entry entry) {
        return new EntrySearchDocument(
            entry.getId(),
            entry.getAccount().getFamily().getId(),
            entry.getAccount().getId(),
            entry.getAccount().getName(),
            entry.getName(),
            entry.getNotes(),
            entry.getAmount(),
            entry.getCurrency(),
            entry.getDate()
        );
    }

    private EntrySearchResult toResult(EntrySearchDocument document) {
        return new EntrySearchResult(
            document.id(),
            document.accountId(),
            document.accountName(),
            document.name(),
            document.notes(),
            document.amount(),
            document.currency(),
            document.date()
        );
    }

    private void requireElasticsearch() {
        if (!elasticsearchService.isEnabled()) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Elasticsearch search is disabled");
        }
    }

    private ResponseStatusException searchUnavailable(IOException exception) {
        return new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Elasticsearch search is unavailable", exception);
    }
}
