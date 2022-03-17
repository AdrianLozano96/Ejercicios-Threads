package org.adrianl.basico.thread;

public class MiHilo extends Thread{
    private int count;
    private int num;
    private boolean parar=false;
    public MiHilo(String name, int num){
        super(name);
        this.num=num;
    }
    @Override
    public void run() {
            for (int i = 0; i < num; i++) {
                System.out.println("Soy el Hilo " + getName() + " con el producto " + i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("FIN DEL HILO " + getName());
    }
    public void pararHilo(){
        parar=true;
    }
}