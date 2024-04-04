package com.esercitazioneBusinessLogic.servicies;

import com.esercitazioneBusinessLogic.DTO.CreateLibroRequestDTO;
import com.esercitazioneBusinessLogic.entites.Libro;
import com.esercitazioneBusinessLogic.entites.enums.StatusEnum;
import com.esercitazioneBusinessLogic.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public Libro create(CreateLibroRequestDTO libroDTO){
        Libro libro = new Libro();
        libro.setTitolo(libroDTO.getTitolo());
        libro.setAutore(libroDTO.getAutore());
        libro.setAnnoPublicazione(libroDTO.getAnnoPubblicazione());
        libro.setStatusEnum(StatusEnum.D);
        return libroRepository.save(libro);
    }
    public Optional<Libro> createCopiaFromId(Long id){
        Optional<Libro> libroOptional = libroRepository.findById(id);
        if (libroOptional.isPresent()){
            Libro copiaLibro = new Libro();
            copiaLibro.setAutore(libroOptional.get().getAutore());
            copiaLibro.setTitolo(libroOptional.get().getTitolo());
            copiaLibro.setAnnoPublicazione(libroOptional.get().getAnnoPublicazione());
            copiaLibro.setStatusEnum(StatusEnum.D);
            Libro savedLibro = libroRepository.save(copiaLibro);
            return Optional.of(savedLibro);
        }else {
            return Optional.empty();
        }
    }

    public List<Libro> getAllLibro(){
        return libroRepository.findAll();
    }
    public List<Libro> getAllLibroDisponibili(){
        return libroRepository.findAllDisponibili();
    }
    public Optional<Libro> getLibroById(Long id){
        Optional<Libro> libroOptional = libroRepository.findById(id);
        if (libroOptional.isPresent()){
            return libroOptional;
        }else {
            return Optional.empty();
        }
    }
    public Optional<Libro> updateLibro(Long id,Libro libro){
        Optional<Libro> libroOptional = libroRepository.findById(id);
        if (libroOptional.isPresent()){
            libroOptional.get().setTitolo(libro.getTitolo());
            Libro libroSaved = libroRepository.save(libroOptional.get());
            return Optional.of(libroSaved);
        }else {
            return Optional.empty();
        }
    }
    public Optional<Libro> updateStatusLibro(Long id,StatusEnum statusEnum){
        Optional<Libro> libroOptional = libroRepository.findById(id);
        if (libroOptional.isPresent()){
            libroOptional.get().setStatusEnum(statusEnum);
            Libro libroSaved = libroRepository.save(libroOptional.get());
            return Optional.of(libroSaved);
        }else {
            return Optional.empty();
        }
    }
//    public Optional<Libro> updateStatusLibroPrestito(Long id){
//        Optional<Libro> libroOptional = libroRepository.findById(id);
//        if (libroOptional.isPresent()){
//            libroOptional.get().setStatusEnum(StatusEnum.P);
//            Libro libroSaved = libroRepository.save(libroOptional.get());
//            return Optional.of(libroSaved);
//        }else {
//            return Optional.empty();
//        }
//    }
//    public Optional<Libro> updateStatusLibroDisponibile(Long id){
//        Optional<Libro> libroOptional = libroRepository.findById(id);
//        if (libroOptional.isPresent()){
//            libroOptional.get().setStatusEnum(StatusEnum.D);
//            Libro libroSaved = libroRepository.save(libroOptional.get());
//            return Optional.of(libroSaved);
//        }else {
//            return Optional.empty();
//        }
//    }
    public Optional<Libro> deleteLibro(Long id){
        Optional<Libro> libroOptional = libroRepository.findById(id);
        if (libroOptional.isPresent()){
            libroRepository.deleteById(id);
            return libroOptional;
        }else {
            return Optional.empty();
        }
    }
    public Optional<List<Libro>> copieDisponibili(Long id){
        Optional<Libro> libroOptional = libroRepository.findById(id);
        if(libroOptional.isPresent()){
            String titolo = libroOptional.get().getTitolo();
            String autore = libroOptional.get().getAutore();
            List<Libro> libroList = libroRepository.findCopieDisponibiliLibro(titolo,autore);
            return Optional.of(libroList);
        }else {
        return Optional.empty();
        }
    }
}
