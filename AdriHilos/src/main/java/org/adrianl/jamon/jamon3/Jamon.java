package org.adrianl.jamon.jamon3;

public class Jamon {
    // Cada jamon1 tendrá un id y un peso entre 6 y 9 kilogramos y el identificador de la granja.
    private int id;
    private int lote;
    private double peso;
    private String idGranja;

    public Jamon() {
        peso = (Math.random()*(9-6+1)+6);
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getLote() {return lote;}
    public void setLote(int lote) {this.lote = lote;}

    public double getPeso() {return peso;}
    public void setPeso(double peso) {this.peso = peso;}

    public String getIdGranja() {return idGranja;}
    public void setIdGranja(String idGranja) {this.idGranja = idGranja;}

    @Override
    public String toString() {
        return "Jamon:" +
                "id=" + id +
                "lote=" + lote +
                ", peso=" + peso +
                ", idGranja='" + idGranja;
    }
}
