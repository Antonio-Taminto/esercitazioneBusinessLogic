package com.esercitazioneBusinessLogic.repositories;

import com.esercitazioneBusinessLogic.entites.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
    @Query("SELECT l FROM Libro l WHERE statusEnum  = 'D'")
    List<Libro> findAllDisponibili();
    @Query("SELECT l FROM Libro l WHERE statusEnum  = 'D' AND titolo  = ?1 AND autore = ?2")
    List<Libro> findCopieDisponibiliLibro(String titolo,String autore);
}
