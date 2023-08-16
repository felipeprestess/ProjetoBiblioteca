package com.demo.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.biblioteca.model.Livro;
import com.demo.biblioteca.services.LivroService;

@RestController
@RequestMapping("api/livros")
public class LivroController {
    
    @Autowired
    private LivroService service;

    @GetMapping
    public List<Livro> obterTodos() {
        return service.obterTodos();
    }

    @GetMapping("/{id}")
    public Livro obterPorId(@PathVariable Integer id) {
        return service.obterPorId(id);
    }

    @PostMapping
    public Livro adicionar(@RequestBody Livro livro) {
        return service.adicionar(livro);
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable Integer id) {
        service.remover(id);
        return "Livro id: " + id + "foi removido";
    }

    @PutMapping("/{id}")
    public Livro atualizar(@RequestBody Livro livro, @PathVariable Integer id) {
        return service.atualizar(id, livro);
    }
}
