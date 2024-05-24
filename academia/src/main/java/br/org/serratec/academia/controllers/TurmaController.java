package br.org.serratec.academia.controllers;

import br.org.serratec.academia.entities.Turma;
import br.org.serratec.academia.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    TurmaService turmaService;

    @PostMapping
    public ResponseEntity<Turma> save(@RequestBody Turma turma) {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.save(turma));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> getById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Turma>> getAllId () {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.getAll());
    }

    @PutMapping
    public ResponseEntity<Turma> update (@RequestBody Turma Turma){
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.update(Turma));
    }

    @DeleteMapping
    public ResponseEntity<Object> delete (@RequestBody Turma Turma) {
        var Turma0 = turmaService.delete(Turma);
        if (Turma0 == null) return ResponseEntity.status(HttpStatus.OK).body("Turma NOT FOUND");
        return ResponseEntity.status(HttpStatus.OK).body("Turma NOT FOUND");
    }
}
