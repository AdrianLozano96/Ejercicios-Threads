package org.adrianl.jamon.jamon1;

import java.util.ArrayList;
import java.util.List;

public class Personas extends Thread{

    private Tienda tienda;
    private int cantidad;
    private List<Jamon> jamones = new ArrayList<>();

    public Personas(String nombre, Tienda tienda, int cantidad) {
        super(nombre);
        this.tienda = tienda;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        for(int i=0; i<cantidad; i++){
            jamones.add(tienda.entregar());
        }
        System.out.println(this.getName()+" ha recogido sus "+cantidad+" jamon3");
        jamones.forEach(System.out::println);
    }
}
