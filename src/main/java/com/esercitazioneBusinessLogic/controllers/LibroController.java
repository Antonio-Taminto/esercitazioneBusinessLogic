package com.esercitazioneBusinessLogic.controllers;

import com.esercitazioneBusinessLogic.DTO.CreateLibroRequestDTO;
import com.esercitazioneBusinessLogic.entites.Libro;
import com.esercitazioneBusinessLogic.entites.enums.StatusEnum;
import com.esercitazioneBusinessLogic.servicies.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libreria")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping("/aggiungi/libro")
    public ResponseEntity<Libro> createLibro(@RequestBody CreateLibroRequestDTO libroDTO){
        return ResponseEntity.ok(libroService.create(libroDTO));
    }
    @PostMapping("/{id}/libro/copia")
    public ResponseEntity<Libro> createLibroCopia(@PathVariable Long id){
        Optional<Libro> libroOptional = libroService.createCopiaFromId(id);
        if (libroOptional.isPresent()) {
            return ResponseEntity.ok(libroOptional.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/libri")
    public ResponseEntity<List<Libro>> getLibri(){
        return ResponseEntity.ok(libroService.getAllLibro());
    }
    @GetMapping("/copie/disponibili")
    public ResponseEntity<List<Libro>> getLibriDisponibili(){
        return ResponseEntity.ok(libroService.getAllLibro());
    }
    @GetMapping("/libro/byid/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id){
        Optional<Libro> libroOptional = libroService.getLibroById(id);
        if (libroOptional.isPresent()) {
            return ResponseEntity.ok(libroOptional.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/libro/update/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id,@RequestBody Libro libro){
        Optional<Libro> libroOptional = libroService.updateLibro(id,libro);
        if (libroOptional.isPresent()) {
            return ResponseEntity.ok(libroOptional.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/libro/copie/{id}/prestato")
    public ResponseEntity<Libro> updateLibroStatusPrestito(@PathVariable Long id){
        Optional<Libro> libroOptional = libroService.updateStatusLibro(id, StatusEnum.P);
        if (libroOptional.isPresent()) {
            return ResponseEntity.ok(libroOptional.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/libro/copie/{id}/restituito")
    public ResponseEntity<Libro> updateLibroStatusDisponibile(@PathVariable Long id){
        Optional<Libro> libroOptional = libroService.updateStatusLibro(id,StatusEnum.D);
        if (libroOptional.isPresent()) {
            return ResponseEntity.ok(libroOptional.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/libro/delete/{id}")
    public ResponseEntity<Libro> deleteLibroById(@PathVariable Long id){
        Optional<Libro> libroOptional = libroService.deleteLibro(id);
        if (libroOptional.isPresent()) {
            return ResponseEntity.ok(libroOptional.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/copiedisponibili/{id}")
    public ResponseEntity<List<Libro>> getcopieDisponibili(@PathVariable Long id){
        Optional<List<Libro>> libroListOpt = libroService.copieDisponibili(id);
        if(libroListOpt.isPresent()){
            return ResponseEntity.ok(libroListOpt.get());
        }else {
            return ResponseEntity.badRequest().build();
        }

    }

}
