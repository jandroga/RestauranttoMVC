package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Images {
    private BufferedImage fondo;
    private BufferedImage chefImage;
    private BufferedImage clientImage;
    private BufferedImage food;
    private String rutaFondo = "src/res/mcdonalds.jpg";
    private String rutaChef = "src/res/chef.png";
    private String rutaClient= "src/res/client.png";
    private String rutaFood = "src/res/food.png";

    public Images(){
        try {
            fondo = ImageIO.read(new File(rutaFondo));
            chefImage = ImageIO.read(new File(rutaChef));
            clientImage = ImageIO.read(new File(rutaClient));
            food = ImageIO.read(new File(rutaFood));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getFondo(){
        return fondo;
    }
    public BufferedImage getChef(){
        return chefImage;
    }
    public BufferedImage getClient(){
        return clientImage;
    }
    public BufferedImage getFood(){
        return food;
    }
}
