package org.adrianl.jamon.jamon4;

import java.util.ArrayList;
import java.util.List;

public class Persona extends Thread{

    private int cantidad;
    private Tienda tienda;
    private List<String> lotesJamon = new ArrayList<>();

    public Persona(String nombre, int cantidad, Tienda tienda) {
        super(nombre);
        this.cantidad = cantidad;
        this.tienda = tienda;
    }

    @Override
    public void run() {
        for(int i=0; i<cantidad; i++){
            lotesJamon.add(tienda.leer());
            System.out.println(this.getName()+" ha leido su lote "+(i+1)+" de "+cantidad+" lotes");
        }
        System.out.println(this.getName()+" ha terminado de leer todos sus lotes");
        lotesJamon.forEach(System.out::println);
    }
}
