package com.exemple.seceond.driver.controller;

import com.exemple.seceond.core.usecase.PermissionServiceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/permissions")
public class PermissionsController {

    @Autowired
    private PermissionServiceUseCase permissionService;

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkPermission(@RequestParam String role,
                                                  @RequestParam String resource) {
        boolean hasAccess = permissionService.hasAccess(role, resource);
        return ResponseEntity.ok(hasAccess);
    }
}

