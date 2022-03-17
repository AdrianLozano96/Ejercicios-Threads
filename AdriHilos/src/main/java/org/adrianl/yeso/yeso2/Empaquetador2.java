package org.adrianl.yeso.yeso2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//CONSUMIDOR
public class Empaquetador2 extends Thread{

    private Fabrica2 fabrica;
    private int cantidad;   //Cantidad a consumir
    private int lote;   //Tamaño del lote
    private List<Saco2> sacos = new ArrayList<>();

    public Empaquetador2(String nombre, Fabrica2 fabrica, int cantidad, int lote) {
        super(nombre);
        this.fabrica = fabrica;
        this.cantidad = cantidad;
        this.lote = lote;
    }

    @Override
    public void run() {
        for(int i=0; i<cantidad; i++){
            for(int j=0; j<lote; j++){
                Saco2 saco = fabrica.empaquetar();
                saco.setLote(i);
                sacos.add(saco);
            }
            System.out.println("Se ha empaquetado el paquete "+i);
            try {
                Thread.sleep(cantidad/10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("Se han empaquetado todos los sacos");
        sacos.stream().sorted((s1,s2)->s1.compareTo(s2)).//forEach(System.out::println);
                //TreeMap ordena por clave(id)
                        collect(Collectors.toMap(Saco2::getId,s->s)).forEach((k,v)-> System.out.println("Clave: "+k+" Valor: "+v));
    }
}
