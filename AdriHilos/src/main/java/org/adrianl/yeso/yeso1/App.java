package org.adrianl.yeso.yeso1;

public class App {
    public static void main(String[] args) {

        int cantidad = 30;
        int lote = 10;

        Manifiesto manifiesto = new Manifiesto();
        Fabricador fabricador1 = new Fabricador("Fabricador 1",cantidad, manifiesto);
        Fabricador fabricador2 = new Fabricador("Fabricador 2",cantidad, manifiesto);
        Fabricador fabricador3 = new Fabricador("Fabricador 3",cantidad, manifiesto);
        Empaquetador empaquetador1 = new Empaquetador("Empaquetador 1", 3*(cantidad/lote), lote, manifiesto);

        fabricador1.start();
        fabricador2.start();
        fabricador3.start();
        empaquetador1.start();

        try {
            fabricador1.join();
            fabricador2.join();
            fabricador3.join();
            empaquetador1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fin del programa");
        System.exit(0);

    }
}
