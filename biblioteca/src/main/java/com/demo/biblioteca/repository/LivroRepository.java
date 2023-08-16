package com.demo.biblioteca.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.stereotype.Repository;

import com.demo.biblioteca.model.Livro;
import com.demo.biblioteca.model.exception.ResourceNotFoundException;

@Repository
public class LivroRepository {
    private List<Livro> livros = new ArrayList<Livro>();
    private Integer ultimoLivro = 0;

    /**
     * Retorna uma lista de todos os livros cadastrados
     * @return Lista de livros
     */
    public List<Livro> obterTodos() {
        return livros;
    }

    /**
     * Método para retornar um livro baseado no Id
     * @param id do livro a ser pesquisado
     * @return Retorna um livro
     */
    public Optional<Livro> obterPorId(Integer id) {
        return livros.stream().filter(livro -> livro.getId() == id).findFirst();
    }

    /**
     * Adiciona um novo livro
     * @param livro a ser adicionado
     * @return livro cadastrado
     */
    public Livro adicionar(Livro livro) {
        ultimoLivro++;
        livro.setId(ultimoLivro);
        livros.add(livro);
        return livro;
    }

    private Livro add(Livro livro) {
        livros.add(livro);
        return livro;
    }

    /**
     * Remove um livro baseado no id
     * @param id do livro a ser removido
     */
    public void remover(Integer id) {

        Optional<Livro> livroEncontrado = obterPorId(id);

        if (livroEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Livro não encontrado");
        }

        livros.removeIf(livro -> livro.getId() == id);
    }

    /**
     * Método para atualizar um livro
     * @param livro a ser atualizado
     * @return o livro atualizado
     */
    public Livro atualizar(Livro livro) {
        
        Optional<Livro> foundedLivro = obterPorId(livro.getId());

        if (foundedLivro.isEmpty()) {
            throw new ResourceNotFoundException("Livro não encontrado");
        }

        remover(livro.getId()); //remover foudedLivro??

        add(livro);

        return livro;
    }
}
