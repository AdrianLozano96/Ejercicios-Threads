package org.adrianl.yeso.yeso3;

import java.time.LocalDate;

public class Saco {

    private int lote;
    private int id;
    private double peso; //Entre 25 y 50
    private LocalDate fecha;
    private String categoria;
    private double tiempo;

    private static int idPersonal = 1;

    public Saco() {
        fecha = LocalDate.now();
        this.peso = (Math.random()*(50-25+1)+25);    //Peso entre 25 y 50 (los dos inclusive)
        tipoCategoria();
        tiempo = this.peso; //Se tarda en fabricar un tiempo igual al peso.
        id = idPersonal;
        idPersonal++;
    }


    public void tipoCategoria(){
        int intervalo = (int)((Math.random()*100)+1);
        if(intervalo>40){  //60%
            categoria = "sacos normales";
        }
        if(intervalo>15 && intervalo <=40){ //25%
            categoria = "sacos super";
            peso = peso + (peso*0.20);  //Peso = peso más un incremento del 20% del peso actual
        }
        if(intervalo<=15){  //15%
            categoria = "sacos extra";
            peso = peso + (peso*0.25);
        }
    }

    public int getLote() {return lote;}
    public void setLote(int lote) {this.lote = lote;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public double getPeso() {return peso;}
    public void setPeso(double peso) {this.peso = peso;}

    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}

    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}

    public double getTiempo() {return tiempo;}
    public void setTiempo(double tiempo) {this.tiempo = tiempo;}

    @Override
    public String toString() {
        return "Saco2: " +
                "lote=" + lote +
                ", id=" + id +
                ", peso=" + peso +
                ", fecha=" + fecha +
                ", categoria='" + categoria +
                ", tiempo=" + tiempo;
    }
}
