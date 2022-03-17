package org.adrianl.mercado.cajera;

/**
 *
 */
public class Main {
    //Main secuencial solo hay una cajera (un hilo (Main)) cajera1 va primero y cuando termina empieza cajera2
    public static void main(String[] args) {
        //Cliente: cada numero significa el tiempo que va a tardar {producto 1:(1seg), producto2(3seg),producto3(5seg),...
        //Cliente: el numero total corresponde al número de productos cliente1(6 productos), cliente2(5 productos),...
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1, 1});

        Cajera cajera1 = new Cajera("Cajera 1");
        Cajera cajera2 = new Cajera("Cajera 2");

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        cajera1.procesarCompra(cliente1, initialTime);
        cajera2.procesarCompra(cliente2, initialTime);
    }
}
