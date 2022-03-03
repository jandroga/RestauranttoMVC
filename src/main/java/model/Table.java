package model;

import view.MyTask;

import java.util.ArrayList;

public class Table {

    private int contador = 0;
    private ArrayList<String> foodList = new ArrayList<String>();
    private MyTask mt;

    public Table(MyTask mt) {
        this.mt = mt;
    }

    public synchronized void placeMeal(String id) {
        if (!isTableFull()) {
            foodList.add("burguer");
//            contador++;
            System.out.println("Ha deixat menjar es " + id);
            notifyAll();
        } else {
            System.out.println("TA LLENO");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void takeMeal(String id) {
        if (foodList.size() > 0) {
            foodList.remove(foodList.size()-1);
            System.out.println("Ha agafat menjar es " + id);
            mt.dropClient();
            Thread.currentThread().stop();
        }else{
            System.out.println("TA BASÍO");
            System.out.println(Thread.currentThread().getName());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized int getContador(){
        return foodList.size();
    }
    private Boolean isTableFull() {
        if (foodList.size() >= 10) {
            return true;
        } else {
            return false;
        }
    }
}
