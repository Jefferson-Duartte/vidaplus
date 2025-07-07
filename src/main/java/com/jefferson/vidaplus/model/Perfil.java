package com.jefferson.vidaplus.model;

public enum Perfil {
    ADMIN("admin"),
    PACIENTE("paciente"),
    PROFISSIONAL("profissional");

    private String perfil;

    Perfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPerfil(){
        return perfil;
    }

}
