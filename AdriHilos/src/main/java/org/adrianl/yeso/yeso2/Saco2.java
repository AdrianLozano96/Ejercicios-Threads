package org.adrianl.yeso.yeso2;


import java.time.LocalDate;

public class Saco2 {

    private int id;
    private static int idSaco;
    private int lote;
    private double peso;    //Entre 25 y 50
    private LocalDate fecha;
    private String categoria;

    public Saco2() {
        peso = (Math.random()*50-25+1)+25;
        fecha = LocalDate.now();
        asignarCategoria();
        id = idSaco;
        idSaco++;
    }

    public void asignarCategoria(){
        int produccion = (int)(Math.random()*100+1);
        if(produccion<=60){
            categoria = "saco normal";
        }
        if(produccion>60 && produccion <=85){
            categoria = "saco súper";
            peso+=20;
        }
        if(produccion>85){
            categoria = "saco extra";
            peso+=25;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Saco2: " +
                "id=" + id +
                ", lote=" + lote +
                ", peso=" + peso +
                ", fecha=" + fecha +
                ", categoria='" + categoria;
    }

    public int compareTo(Saco2 s){
        if(this.peso>s.peso){
            return 1;
        }
        if(this.peso<s.peso){
            return -1;
        }
        else{
            return 0;
        }
    }
}
