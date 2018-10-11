/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.time.LocalDate;

/**
 *
 * @author rapwe
 */
public class Produto {

    public Produto(String nome, double preco, String codigo, double quantidade, LocalDate validade) {
        this.setNome(nome);
        this.setCodigo(codigo);
        this.setPreco(preco);
        this.setQuantidade(quantidade);
        this.setValidade(validade);
    }

    public Produto(int id, String nome, double preco, String codigo, double quantidade, LocalDate validade) {
        this(nome, preco, codigo, quantidade, validade);
        this.setId(id);
    }

    private int id;
    private String nome;
    private double preco;
    private String codigo;
    private double quantidade;
    private LocalDate validade;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

}
