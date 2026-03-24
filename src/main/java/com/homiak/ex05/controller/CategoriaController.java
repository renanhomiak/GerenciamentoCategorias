package com.homiak.ex05.controller;

import com.homiak.ex05.models.CategoriaModel;
import com.homiak.ex05.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<CategoriaModel> criar(@RequestBody CategoriaModel l){
        return ResponseEntity.status(201).body(service.salvar(l));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> buscar(@PathVariable Long id){
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}