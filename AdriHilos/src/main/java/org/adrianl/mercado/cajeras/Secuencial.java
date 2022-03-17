package org.adrianl.mercado.cajeras;

public class Secuencial {

    public static void cajeraSecuencial(int numeroClientes){
        System.out.println("-----------------------INICIA PROGRAMA DE FORMA SECUENCIAL----------------------------");
        long init = System.currentTimeMillis();  // Instante inicial del procesamiento

        ColaClientes clientes = new ColaClientes(numeroClientes);

        for (int i = 0; i < numeroClientes; i++) {
            Runnable cajera = new Cajera(clientes.getColaClientes().pop(), init);
            cajera.run();       //Se ejecuta el método run y se quita el executor Al ser secuencial solo se necestia un hilo
        }

        long fin = System.currentTimeMillis();    // Instante final del procesamiento
        //Tiempo total
        System.out.println("Tiempo total de procesamiento: " + (fin - init) / 1000 + " Segundos");
        System.out.println("-----------------------FINALIZA PROGRAMA DE FORMA SECUENCIAL----------------------------");
    }
}
