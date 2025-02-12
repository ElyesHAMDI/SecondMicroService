package com.exemple.seceond.adapter.server;

import com.exemple.seceond.adapter.repository.PermissionAdapterRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PermissionAdapterServer implements PermissionAdapterRepository {

    private final Map<String, List<String>> rolePermissions = Map.of(
            "ADMIN", List.of("details", "employees"),
            "USER", List.of("employees")
    );



    @Override
    public boolean getAccess(String role, String resource) {
        List<String> allowedResources = rolePermissions.getOrDefault(role, List.of());
        return allowedResources.contains(resource);
    }
}
