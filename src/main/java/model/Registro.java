package model;

import java.util.Date;

public class Registro {
    protected String titulo;
    protected String descricao;
    protected String data;
    private TipoRegistro tipo;
    private int id;

    // Necessário dois construtores para o Registro?
    public Registro(String titulo, String descricao, String data) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
    }

    public Registro(int id, String titulo, String data, String descricao, TipoRegistro tipo) {
        this(titulo, descricao, data);
        this.id = id;
        this.tipo = tipo;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TipoRegistro getTipo() {
        return tipo;
    }

    public void setTipo(TipoRegistro tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Melhorar a formatacao do registro
    @Override
    public String toString() {
        return "------------- \n" +
                "ID " + id +
                " - " + tipo
                + ", " + titulo +
                "  Data: " + data + '\n' +
                "Descrição: \n" + " " + descricao + '\n';
    }
}
