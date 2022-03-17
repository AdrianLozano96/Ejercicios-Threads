package org.adrianl.yeso.yeso1;

import java.util.ArrayDeque;

public class Empaquetador extends Thread{

    private int cantidad; //Cantidad a consumir
    private int lote; //Cantidad de lotes
    private Manifiesto manifiesto;
    ArrayDeque<Saco> misSacos = new ArrayDeque<>();

    public Empaquetador(String nombre, int cantidad, int lote, Manifiesto manifiesto) {
        super(nombre);
        this.cantidad = cantidad;
        this.lote = lote;
        this.manifiesto = manifiesto;
    }

    @Override
    public void run() {
        for(int i=0; i<cantidad; i++){
            for(int j=0; j<lote; j++){
                Saco s = manifiesto.consumir();
                s.setEmpaquetador(this.getName());
                s.setLote((i+1));
                misSacos.add(s);
                System.out.println(this.getName()+" ha empaquetado "+s.toString());
            }
            System.out.println("---------- Paquete "+(i+1)+" Terminado ----------");
            misSacos.forEach(System.out::println);
            misSacos.clear();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName()+" ha terminado de empaquetar sus "+cantidad+ "sacos");
    }
}
