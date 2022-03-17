package org.adrianl.yeso.yeso3;


public class App {
    public static void main(String[] args) {
        //System.out.println("Hola");
        int cantidad = 100;
        Fabrica fabrica = new Fabrica();
        Fabricador fabricador = new Fabricador("Fabricante1", fabrica, cantidad);
        Fabricador fabricador2 = new Fabricador("Fabricante2", fabrica, cantidad);
        Empaquetador empaquetador = new Empaquetador("Empaquetador1", fabrica, (2*cantidad)/10);
        Empaquetador empaquetador2 = new Empaquetador("Empaquetador2", fabrica, cantidad/10);
        fabricador.start();
        fabricador2.start();
        empaquetador.start();
        //empaquetador2.start();

        try {
            fabricador.join();
            fabricador2.join();
            empaquetador.join();
            //empaquetador2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fin del programa");
        System.exit(0);

    }
}
