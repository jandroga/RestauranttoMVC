/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Chef;
import model.Client;
import model.Images;
import model.Table;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Jandroga
 */
public class MyTask extends JFrame {

    public int width;
    public int height;
    private Table t = new Table(this);
    private Images images = new Images();
    private int clientsTotals;
    private int chefsTotals;
    private String id;
    private int speed;
    private Viewer v;

    public MyTask(){
        super("Ristorante");
        getDim();
        getContentPane().setLayout(new GridBagLayout());
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        v = new Viewer(images,width-100, height-200, this);
        Thread vThread = new Thread(v);
        vThread.start();
        ControlPanel cp = new ControlPanel(this);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = 1;
        c.gridx = 0;
        c.gridy = 0;
        this.add(v,c);
        c.fill = 0;
        c.gridx = 1;
        c.gridy = 0;
        this.add(cp, c);
        setVisible(true);
        pack();
    }

    public synchronized Table getT(){
        return t;
    }
    public synchronized int getClientsTotals(){
        return clientsTotals;
    }
    public synchronized int getChefsTotals(){
        return chefsTotals;
    }

    public void newClient(){
        speed = (int)Math.floor((Math.random()*(12-6+1)+6))*1000;
        this.id = Integer.toString(clientsTotals);
        System.out.println("Velocitat del nou client: " +speed+ ", id: "+id);
        Client client = new Client(id, speed, t);
        new Thread(client).start();
        addClient();
    }

    public void newChef(){
        speed = (int)Math.floor((Math.random()*(12-6+1)+6))*1000;
        this.id = Integer.toString(chefsTotals);
        System.out.println("Velocitat del nou chef: " +speed+ ", id: "+id);
        Chef chef = new Chef(id, speed, t);
        new Thread(chef).start();
        addChef();
    }
    public synchronized void addChef(){
        chefsTotals++;
    }
    public synchronized void addClient(){
        clientsTotals++;
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    public void getDim(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.width = (int)size.getWidth();
        this.height = (int)size.getHeight();
        System.out.println("Resolució carregada: " +size);
    }

    public static void main(String[] args) {
        new MyTask();
    }

    public synchronized void dropClient() {
        clientsTotals--;
    }

    public Viewer getV() {
        return v;
    }
}
