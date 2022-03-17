package org.adrianl.mercado.cajeras;


import java.util.ArrayDeque;

public class ColaClientes {
    private ArrayDeque<Cliente> colaClientes;
    //Cola clientes
    public ColaClientes(int numeroClientes){
        this.colaClientes = new ArrayDeque<>(numeroClientes);
        for (int i = 0; i < numeroClientes; i++) {
            colaClientes.add(new Cliente(i + 1));
        }
    }

    public ArrayDeque<Cliente> getColaClientes() {
        return colaClientes;
    }

    public void setColaClientes(ArrayDeque<Cliente> colaClientes) {
        this.colaClientes = colaClientes;
    }

    @Override
    public String toString() {
        return "ColaClientes: " +
                "colaClientes=" + colaClientes;
    }
}
