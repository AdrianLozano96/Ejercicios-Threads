package org.adrianl.jamon.jamon2;

import java.util.ArrayList;
import java.util.List;

public class Personas2 extends Thread{

    private Tienda2 tienda;
    private int cantidad;
    private List<Jamon2> jamones = new ArrayList<>();

    public Personas2(String nombre, Tienda2 tienda, int cantidad) {
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
