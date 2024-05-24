package br.org.serratec.academia.controllers;

import br.org.serratec.academia.entities.Instrutor;
import br.org.serratec.academia.services.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    InstrutorService instrutorService;

    @PostMapping
    public ResponseEntity<Instrutor> save(@RequestBody Instrutor instrutor) {
        return ResponseEntity.status(HttpStatus.OK).body(instrutorService.save(instrutor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> getById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(instrutorService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Instrutor>> getAllId () {
        return ResponseEntity.status(HttpStatus.OK).body(instrutorService.getAll());
    }

    @PutMapping
    public ResponseEntity<Instrutor> update (@RequestBody Instrutor instrutor){
        return ResponseEntity.status(HttpStatus.OK).body(instrutorService.update(instrutor));
    }

    @DeleteMapping
    public ResponseEntity<Object> delete (@RequestBody Instrutor instrutor){
        var instrutor0 = instrutorService.delete(instrutor);
        if(instrutor0 == null) return ResponseEntity.status(HttpStatus.OK).body("INSTRUTOR NOT FOUND");
        return ResponseEntity.status(HttpStatus.OK).body("INSTRUTOR SUCCESSFULLY DELETED");
    }

}