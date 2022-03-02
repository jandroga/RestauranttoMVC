package model;


public class Chef extends Thread{

    private final String id;
    private final int speed;
    private Table t;

    public Chef(String name, int speed, Table t) {
        this.id = "Chef " + name;
        this.speed = speed;
        this.t = t;
    }

    @Override
    public void run() {
        while (true){
            try {
                sleep(speed);
                t.placeMeal(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
