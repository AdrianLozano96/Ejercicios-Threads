package org.adrianl.jamon.jamon1;

public class App {
    public static void main(String[] args) {

        int max = 10;
        int cantidad = 30;
        int lote = 3;

        Secadero secadero = new Secadero(max);
        Tienda tienda = new Tienda();

        Granjas granja1 = new Granjas("Granja 1", secadero, cantidad);
        Granjas granja2 = new Granjas("Granja 2", secadero, cantidad);

        Mensajero mensajero = new Mensajero("Mensajero", secadero, tienda, (2*cantidad)/lote, lote);

        Personas persona1 = new Personas("Persona1", tienda, 10);
        Personas persona2 = new Personas("Persona2", tienda, 5);
        Personas persona3 = new Personas("Persona3", tienda, 15);
        Personas persona4 = new Personas("Persona3", tienda, 10);
        Personas persona5 = new Personas("Persona3", tienda, 10);
        Personas persona6 = new Personas("Persona3", tienda, 10);

        granja1.start();
        granja2.start();
        granja1.setPriority(5);
        granja2.setPriority(10);

        mensajero.start();
        persona1.start();
        persona2.start();
        persona3.start();
        persona4.start();
        persona5.start();
        persona6.start();

        try {
            granja1.join();
            granja2.join();
            mensajero.join();
            persona1.join();
            persona2.join();
            persona3.join();
            persona4.join();
            persona5.join();
            persona6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A descansar un poco");
        System.exit(0);
    }
}
