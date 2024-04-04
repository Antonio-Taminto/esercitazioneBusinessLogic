package com.esercitazioneBusinessLogic.entites.enums;

public enum StatusEnum {
    P("in prestito"),
    D("disponibile");
    private String description;

    StatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
