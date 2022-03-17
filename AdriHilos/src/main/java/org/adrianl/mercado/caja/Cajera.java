package org.adrianl.mercado.caja;

public class Cajera {

    private String nombre;

    public Cajera() {
    }

    public Cajera(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void procesarCompra(Cliente cliente, long timeStamp) {

        System.out.println("La cajera " + this.nombre + " comienza procesando la compra del cliente " + cliente.getNombre()
                + " en el tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            // Se procesa el producto en segundos
            this.tiempoEspera(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " ->Tiempo: "
                    + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        }

        System.out.println("La cajera " + this.nombre + " ha terminado de procesar la compra del cliente " + cliente.getNombre()
                + " en el tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

    }

    private void tiempoEspera(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}