package view;

import model.Images;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Viewer extends Canvas implements Runnable{

    private Images images;
    private MyTask mt;
    private final BufferedImage chefImage;
    private final BufferedImage clientImage;
    private final BufferedImage fondo;
    private final BufferedImage food;
    private final int chefY = 220;
    private final int chefX = 300;
    private final int clientY = 380;
    private final int clientX = 250;
    private int chefSize;
    private int foodSize;
    private int clientSize;

    public Viewer(Images images, int width, int height, MyTask mt){
        this.images = images;
        this.mt = mt;
        this.fondo = images.getFondo();
        this.chefImage = images.getChef();
        this.clientImage = images.getClient();
        this.food = images.getFood();
        setSize(width, height);
        setVisible(true);
        repaint();
    }

    public void updateState(int chefSize, int clientSize, int foodSize){
        this.chefSize = chefSize;
        this.clientSize = clientSize;
        this.foodSize = foodSize;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fondo,0,0,null);

        for (int i = 0; i < mt.getChefsTotals(); i++) {
            g.drawImage(chefImage,chefX+(100*i), chefY,null);
        }
        for (int i = 0; i < mt.getClientsTotals(); i++) {
            g.drawImage(clientImage,clientX+(100*i), clientY,null);
        }
        for (int i = 0; i < mt.getT().getContador(); i++) {
            g.drawImage(food,chefX+(100*i),chefY-(100),null);
        }
    }

    private void setActors() {
        chefSize = mt.getChefsTotals();
        clientSize = mt.getClientsTotals();
        foodSize = mt.getT().getContador();
    }

    @Override
    public void run() {
        while (true) {
            if (this.getGraphics() != null) {
                paint(this.getGraphics());
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
