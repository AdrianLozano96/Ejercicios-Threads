package org.adrianl.jamon.jamon4;

public class Jamon {
    private int idjamon;
    private int lote;
    private double peso; //6-9
    private String granja;
    private String mensajero;

    public Jamon() {
        peso = (Math.random()*9-6+1)+6;
    }

    public int getIdjamon() {
        return idjamon;
    }

    public void setIdjamon(int idjamon) {
        this.idjamon = idjamon;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getGranja() {
        return granja;
    }

    public void setGranja(String granja) {
        this.granja = granja;
    }

    public String getMensajero() {
        return mensajero;
    }

    public void setMensajero(String mensajero) {
        this.mensajero = mensajero;
    }


    @Override
    public String toString() {
        return "Jamon: " +
                "idjamon=" + idjamon +
                ", lote=" + lote +
                ", peso=" + peso +
                ", granja='" + granja + '\'' +
                ", mensajero='" + mensajero;
    }
}
