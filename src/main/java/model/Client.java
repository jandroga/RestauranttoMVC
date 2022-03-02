package model;

public class Client extends Thread{

    private final String id;
    private int speed;
    private Table t;

    public Client(String name, int speed, Table t) {
        this.id = "Client " + name;
        this.speed = speed;
        this.t = t;
    }

    @Override
    public void run() {
        while (true){
            try {
                sleep(speed);
                t.takeMeal(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
