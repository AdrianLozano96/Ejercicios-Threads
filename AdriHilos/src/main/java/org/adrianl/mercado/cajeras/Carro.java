package org.adrianl.mercado.cajeras;


import java.util.Arrays;
import java.util.Random;

public class Carro {
    private Producto[] productos;

    public Carro(){
        //this.productos = new Producto[(int)((Math.random()*30)+1)];
        this.productos = new Producto[new Random().nextInt(30)+1];
        for(int i=0; i<productos.length; i++){
            productos[i] = new Producto(i+1);
        }
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Carro: " +
                "productos=" + Arrays.toString(productos);
    }
}
