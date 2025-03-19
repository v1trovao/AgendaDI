package model;


import java.util.Date;

public class Tarefa extends Registro {
    private int id;
    private double hora;

    public Tarefa(String titulo, String descricao, String data, int id, double hora) {
        super(titulo, descricao, data);
        this.id = id;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", hora=" + hora +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHora() {
        return hora;
    }

    public void setHora(double hora) {
        this.hora = hora;
    }
}
