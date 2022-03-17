package org.adrianl.jamon.jamon2;

public class Jamon2 {
    // Cada jamon1 tendrá un id y un peso entre 6 y 9 kilogramos y el identificador de la granja.

    private int id;
    private static int idJamon;
    private int lote;
    private double peso;
    private String idGranja;

    public Jamon2(){
        peso = (Math.random()*9-6+1)+6;
        id = idJamon;
        idJamon++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getIdGranja() {
        return idGranja;
    }

    public void setIdGranja(String idGranja) {
        this.idGranja = idGranja;
    }

    public int getLote() {return lote;}

    public void setLote(int lote) {this.lote = lote;}

    @Override
    public String toString() {
        return "Jamon2: " +
                "id=" + id +
                "lote=" + lote +
                ", peso=" + peso +
                ", idGranja=" + idGranja;
    }
}
