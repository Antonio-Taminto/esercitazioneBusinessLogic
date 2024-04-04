package com.esercitazioneBusinessLogic.entites;

import com.esercitazioneBusinessLogic.entites.enums.StatusEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String titolo;
    private String autore;

    private LocalDate annoPublicazione;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_enum", nullable = false,length = 1)
    private StatusEnum statusEnum;

    public Libro(Long id, String titolo,String autore,LocalDate annoPublicazione, StatusEnum statusEnum) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
        this.annoPublicazione = annoPublicazione;
        this.statusEnum = statusEnum;
    }

    public Libro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public LocalDate getAnnoPublicazione() {
        return annoPublicazione;
    }

    public void setAnnoPublicazione(LocalDate annoPublicazione) {
        this.annoPublicazione = annoPublicazione;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
}
