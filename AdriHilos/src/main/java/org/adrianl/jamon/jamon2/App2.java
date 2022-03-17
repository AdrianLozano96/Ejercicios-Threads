package org.adrianl.jamon.jamon2;

public class App2 {
    public static void main(String[] args) {

        int max = 10;
        int cantidad = 30;
        int lote = 3;

        Secadero2 secadero = new Secadero2(max);
        Tienda2 tienda = new Tienda2();

        Granjas2 granja1 = new Granjas2("Granja 1", secadero, cantidad);
        Granjas2 granja2 = new Granjas2("Granja 2", secadero, cantidad);

        Mensajero2 mensajero = new Mensajero2("Mensajero", secadero, tienda, (2*cantidad)/lote, lote);

        Personas2 persona1 = new Personas2("Persona1", tienda, 10);
        Personas2 persona2 = new Personas2("Persona2", tienda, 5);
        Personas2 persona3 = new Personas2("Persona3", tienda, 15);
        Personas2 persona4 = new Personas2("Persona3", tienda, 10);
        Personas2 persona5 = new Personas2("Persona3", tienda, 10);
        Personas2 persona6 = new Personas2("Persona3", tienda, 10);

        granja1.start();granja2.start();
        granja1.setPriority(5);granja2.setPriority(10);

        mensajero.start();
        persona1.start();persona2.start();persona3.start();persona4.start();persona5.start();persona6.start();

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
