package com.exemple.seceond.core.usecase;

import com.exemple.seceond.adapter.client.EmployeeDetailsClient;
import com.exemple.seceond.adapter.repository.PermissionAdapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceUseCase {


    private final PermissionAdapterRepository permissionAdapterRepository;

    @Autowired
    public PermissionServiceUseCase(PermissionAdapterRepository permissionAdapterRepository) {
        this.permissionAdapterRepository = permissionAdapterRepository;
    }

    public boolean hasAccess(String role, String resource) {
        //List<String> allowedResources = rolePermissions.getOrDefault(role, List.of());
        return permissionAdapterRepository.getAccess(role, resource);
    }
}
