package org.adrianl.yeso.yeso2;

public class App2 {
    public static void main(String[] args) {
        //System.out.println("Hola");
        int cantidad = 300; //Cantidad a producir
        int lote = 10;
        Fabrica2 fabrica = new Fabrica2();
        Fabricador2 fabricador1 = new Fabricador2("fabricador1",fabrica, cantidad);
        Fabricador2 fabricador2 = new Fabricador2("fabricador2",fabrica, cantidad);
        Empaquetador2 empaquetador = new Empaquetador2("empaquetador1", fabrica,(2*cantidad)/lote, lote);

        fabricador1.start();
        fabricador2.start();
        empaquetador.start();

        try {
            fabricador1.join();
            fabricador2.join();
            empaquetador.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fin del programa :)");
        System.exit(0);
    }
}
