package com.butler.app.api;

import com.butler.app.service.EntrySearchResult;
import com.butler.app.service.SearchService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/entries")
    public List<EntrySearchResult> searchEntries(
        @RequestParam @NotBlank @Size(max = 200) String query,
        @RequestParam(defaultValue = "20") @Min(1) @Max(100) int size,
        Authentication authentication
    ) {
        return searchService.searchEntries(authentication, query, size);
    }

    @PostMapping("/entries/reindex")
    public ReindexResponse reindexEntries(Authentication authentication) {
        return new ReindexResponse(searchService.reindexEntries(authentication));
    }

    public record ReindexResponse(int indexed) {
    }
}
