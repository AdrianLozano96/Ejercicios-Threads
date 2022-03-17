package org.adrianl.mercado.cajeras;


public class Cliente {
    private int numCliente;
    private Carro carro;

    public Cliente(int numCliente){
        this.numCliente = numCliente;
        this.carro = new Carro();
    }

    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "numCliente=" + numCliente +
                ", carro=" + carro;
    }
}
