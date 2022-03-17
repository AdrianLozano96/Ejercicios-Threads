package org.adrianl.mercado.cajeras;


import java.util.Random;


public class Producto {
    private int numProductos;
    private int tiempoProcesamiento;

    public Producto(int numProductos){
        this.numProductos = numProductos;
        //this.tiempoProcesamiento = (int) ((Math.random()*5)+1);
        this.tiempoProcesamiento = new Random().nextInt(5)+1;
    }

    public int getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }

    public int getTiempoProcesamiento() {
        return tiempoProcesamiento;
    }

    public void setTiempoProcesamiento(int tiempoProcesamiento) {
        this.tiempoProcesamiento = tiempoProcesamiento;
    }


    @Override
    public String toString() {
        return "Producto: " +
                "numProductos=" + numProductos +
                ", tiempoProcesamiento=" + tiempoProcesamiento;
    }
}