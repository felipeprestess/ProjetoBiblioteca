package com.demo.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.biblioteca.model.Livro;
import com.demo.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    /**
     * Retorna todos os livros cadastrados
     * @return Lista de livros
     */
    public List<Livro> obterTodos() {
        return repository.obterTodos();
    }

    /**
     * Retorna um livro baseado no id
     * @param id do livro cadastrado
     * @return um livro
     */
    public Livro obterPorId(Integer id) {
        return repository.obterPorId(id).get();
    }

    /**
     * Remove um livro baseado no id
     * @param id do livro a ser removido
     */
    public void remover(Integer id) {
        repository.remover(id);
    }

    /**
     * Adiciona um novo livro
     * @param livro a ser adicionado
     * @return livro cadastrado
     */
    public Livro adicionar(Livro livro) {
        return repository.adicionar(livro);
    }

    /**
     * Método para atualizar um livro
     * @param livro a ser atualizado
     * @return o livro atualizado
     */
    public Livro atualizar(Integer id, Livro livro) {

        livro.setId(id);
        return repository.atualizar(livro);
    }
}
