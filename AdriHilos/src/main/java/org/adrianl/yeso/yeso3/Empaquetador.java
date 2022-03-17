package org.adrianl.yeso.yeso3;

import java.util.ArrayList;

//CONSUMIDOR
public class Empaquetador extends Thread {

    private ArrayList<Saco>sacos = new ArrayList<>();
    private Fabrica fabrica;
    private int cantidad;
    private double pesoTotal;

    public Empaquetador(String nombre, Fabrica fabrica, int cantidad){
        super(nombre);
        this.fabrica = fabrica;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {

        for(int i=0; i<cantidad; i++){

            for(int j=0;j<10; j++){
                Saco saco = fabrica.empaquetar();   //Saca los sacos de la fabrica.
                saco.setLote(i+1);  //Asignar el número de lote a cada saco de 10 en 10.
                // Esperando entre cada lote un tiempo que es la suma del peso de los sacos partido de 10.
                pesoTotal+=saco.getPeso();
                sacos.add(saco);    // Almacenarlos en una lista y mostarla
                System.out.println(this.getName()+"-> Saco2 "+(j+1)+" del lote "+(i+1)+" listo");
            }
            System.out.println(this.getName()+"-> Lote "+(i+1)+"º de 10 sacos ya empaquetados");
            sacos.forEach(System.out::println);
            sacos.clear();
            try {
                Thread.sleep((long) (pesoTotal));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pesoTotal = 0;
        }

    }

    //Opcional: almacenarlos en un map siendo la clave el peso y el valor el resto de información y que este ordenado.

}
