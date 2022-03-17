package org.adrianl.jamon.jamon4;

public class Granja extends Thread{

    //Crea jamon en 1 segundo
    private int cantidad; //30 jamon4 por Grnja
    private Secadero secadero;

    public Granja(String nombre, int cantidad, Secadero secadero) {
        super(nombre);
        this.cantidad = cantidad;
        this.secadero = secadero;
    }

    @Override
    public void run() {
        for(int i=0; i<cantidad; i++){
            Jamon j = new Jamon();
            j.setIdjamon((i+1));
            j.setGranja(this.getName());
            secadero.producir(j);
            System.out.println(this.getName()+" ha producido el Jamon "+(i+1)+ " de sus "+cantidad+" jamon4");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName()+" ha terminado de producir sus "+cantidad+ "jamon4");
    }
}
