package com.dunnas.ChamadoServicoCondominio.Domain.Core;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER"),
    WORKER("WORKER");

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public String toString() {
        return this.roleName;
    }
}
