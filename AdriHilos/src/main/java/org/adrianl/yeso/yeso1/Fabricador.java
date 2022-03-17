package org.adrianl.yeso.yeso1;

public class Fabricador extends Thread{

    private int cantidad;   //Cantidad a producir 300
    private Manifiesto manifiesto;

    public Fabricador(String nombre, int cantidad, Manifiesto manifiesto) {
        super(nombre);
        this.cantidad = cantidad;
        this.manifiesto = manifiesto;
    }

    @Override
    public void run() {
        for(int i=0; i<cantidad; i++){
            Saco s = new Saco();
            s.setFabricador(this.getName());
            manifiesto.producir(s);
            System.out.println(this.getName()+" ha producido su "+i+" saco de "+cantidad);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName()+" ha terminado de producir sus "+cantidad+" sacos");
    }


}
