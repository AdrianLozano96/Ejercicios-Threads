package org.adrianl.jamon.jamon3;

public class App {
    public static void main(String[] args) {
        Secadero secadero = new Secadero();
        int cantidad = 15;
        int lote = 3;
        Granjas g1 = new Granjas("Granja 1", secadero, cantidad);
        Granjas g2 = new Granjas("Granja 2", secadero, cantidad);
        Mensajero m = new Mensajero("Mensajero 1", secadero, (2*cantidad)/lote, lote);

        g2.setPriority(Thread.MAX_PRIORITY);

        g1.start();
        g2.start();
        m.start();

        try {
            g1.join();
            g2.join();
            m.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fin del programa");
        System.exit(0);
    }
}
