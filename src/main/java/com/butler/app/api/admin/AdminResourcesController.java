package com.butler.app.api.admin;

import com.butler.app.api.admin.AdminApiModels.UserResponse;
import com.butler.app.api.admin.AdminApiModels.UserUpdateRequest;
import com.butler.app.entities.Family;
import com.butler.app.entities.User;
import com.butler.app.repositories.FamilyRepository;
import com.butler.app.repositories.InvitationRepository;
import com.butler.app.repositories.SsoIdentityBlockRepository;
import com.butler.app.repositories.UserRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping({"/api/admin", "/admin"})
public class AdminResourcesController {

    private final UserRepository users;
    private final FamilyRepository families;
    private final InvitationRepository invitations;
    private final SsoIdentityBlockRepository identityBlocks;

    public AdminResourcesController(
        UserRepository users,
        FamilyRepository families,
        InvitationRepository invitations,
        SsoIdentityBlockRepository identityBlocks
    ) {
        this.users = users;
        this.families = families;
        this.invitations = invitations;
        this.identityBlocks = identityBlocks;
    }

    @GetMapping("/users")
    public List<UserResponse> users() {
        return users.findAll().stream().map(UserResponse::from).toList();
    }

    @RequestMapping(path = "/users/{id}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public UserResponse updateUser(@PathVariable UUID id, @RequestBody UserUpdateRequest request) {
        User user = findUser(id);
        if (request.email() != null) {
            user.setEmail(request.email());
        }
        if (request.firstName() != null) {
            user.setFirstName(request.firstName());
        }
        if (request.lastName() != null) {
            user.setLastName(request.lastName());
        }
        if (request.role() != null) {
            user.setRole(request.role());
        }
        if (request.active() != null) {
            user.setActive(request.active());
        }
        user.setUpdatedAt(LocalDateTime.now());
        return UserResponse.from(users.save(user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> destroyUser(@PathVariable UUID id) {
        users.delete(findUser(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{id}/deletion")
    public Map<String, Object> userDeletion(@PathVariable UUID id) {
        User user = findUser(id);
        return Map.of(
            "user", UserResponse.from(user),
            "confirmationRequired", true,
            "message", "Deleting this user is permanent."
        );
    }

    @DeleteMapping("/sso_identity_blocks/{id}")
    public ResponseEntity<Void> destroyIdentityBlock(@PathVariable UUID id) {
        if (!identityBlocks.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SSO identity block not found.");
        }
        identityBlocks.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/invitations/{id}")
    public ResponseEntity<Void> destroyInvitation(@PathVariable UUID id) {
        if (!invitations.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invitation not found.");
        }
        invitations.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/families/{id}")
    public ResponseEntity<Void> destroyFamily(@PathVariable UUID id) {
        families.delete(findFamily(id));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/families/{id}/invitations")
    public Map<String, Long> destroyFamilyInvitations(@PathVariable UUID id) {
        findFamily(id);
        long deleted = invitations.deleteAllByFamily_Id(id);
        return Map.of("deleted", deleted);
    }

    private User findUser(UUID id) {
        return users.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."));
    }

    private Family findFamily(UUID id) {
        return families.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Family not found."));
    }
}
