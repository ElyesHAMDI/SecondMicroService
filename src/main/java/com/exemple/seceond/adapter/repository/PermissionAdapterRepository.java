package com.exemple.seceond.adapter.repository;

public interface PermissionAdapterRepository {
    boolean getAccess(String role, String resource);
}
