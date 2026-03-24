package com.homiak.ex05.service;

import com.homiak.ex05.models.CategoriaModel;
import com.homiak.ex05.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CategoriaService {

    private final CategoriaRepository repo;

    public CategoriaService(CategoriaRepository repo) { this.repo = repo; }

    public CategoriaModel salvar(CategoriaModel l){ return repo.save(l); }
    public List<CategoriaModel> listar(){ return repo.findAll(); }
    public Optional<CategoriaModel> buscar(Long id){ return repo.findById(id); }
    public void deletar(Long id){ repo.deleteById(id); }
}