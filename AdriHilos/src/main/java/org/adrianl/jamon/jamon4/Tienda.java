package org.adrianl.jamon.jamon4;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    StringBuilder sb = new StringBuilder();
    private List<String> misJamones = new ArrayList<>();
    private int lector;
    private int escritor;
    private int count =1;

    public synchronized void escribir(List<String> jamones){
        while(lector>0 || escritor>0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        escritor++;
        misJamones.addAll(jamones);
        escritor--;
        notifyAll();
    }

    public synchronized String leer(){
        while(escritor>0 || misJamones.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lector++;
        sb.append("------------------- Se esta leyecdo el lote Nº "+count+"\n");
        misJamones.forEach(j->sb.append(j.toString()+"\n"));
        count++;
        misJamones.clear();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lector--;
        notifyAll();
        return String.valueOf(sb);
    }


}
