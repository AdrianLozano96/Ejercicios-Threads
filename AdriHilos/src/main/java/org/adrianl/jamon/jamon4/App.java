package org.adrianl.jamon.jamon4;

public class App {
    public static void main(String[] args) {

        int max = 10;
        int cantidad = 30;
        int lote = 3;
        //Granja 1 y 2 la segunda con mayor prioridad
        Secadero secadero = new Secadero(max);
        Tienda tienda = new Tienda();
        Granja granja1 = new Granja("Granja 1", cantidad, secadero);
        Granja granja2 = new Granja("Granja 2", cantidad, secadero);
        Mensajero mensajero = new Mensajero("Mensajero 1", 2*(cantidad/lote), lote, secadero, tienda);

        Persona persona1 = new Persona("Persona 1",10, tienda);
        Persona persona2 = new Persona("Persona 2",5, tienda);
        Persona persona3 = new Persona("Persona 3",15, tienda);

        granja1.start();
        granja2.start();
        mensajero.start();
        persona1.start();
        persona2.start();
        persona3.start();
        granja2.setPriority(Thread.MAX_PRIORITY);

        try {
            granja1.join();
            granja2.join();
            mensajero.join();
            persona1.join();
            persona2.join();
            persona3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fin del programa");
        System.exit(0);
    }
}
