package view;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {


    public ControlPanel(MyTask mt){
        super();
        RestaurantCP r = new RestaurantCP(mt);
        setBackground(Color.gray);
        this.add(r);
    }
}
