package view;

import model.Table;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class RestaurantCP extends JPanel {

    private static final String FONTNAME = "Courier New";
    private final Table t;
    private final MyTask mt;
    private Font font = new Font(FONTNAME, Font.PLAIN, 12);
    private Border blackLine = BorderFactory.createLineBorder(Color.black);

    public RestaurantCP(MyTask mt){
        super(new BorderLayout());
        this.mt = mt;
        t = mt.getT();
        setBorder(blackLine);
        setBackground(Color.red);
        JButton btnClient = new JButton("Nou client");
        btnClient.setFont(font);
        btnClient.setSize(50,50);
        btnClient.addActionListener(e -> addClient());
        btnClient.setVisible(true);

        JButton btnChef = new JButton("Nou chef");
        btnChef.setFont(font);
        btnChef.setSize(50,50);
        btnChef.addActionListener(e -> addChef());
        btnChef.setVisible(true);

        JButton btnTableState = new JButton("Comprova l'estat de la taula");
        btnTableState.setFont(font);
        btnTableState.setSize(50,50);
        btnTableState.addActionListener(e -> System.out.println(t.getContador()));
        btnTableState.setVisible(true);

        this.add(btnClient,BorderLayout.NORTH);
        this.add(btnChef,BorderLayout.CENTER);
        this.add(btnTableState,BorderLayout.SOUTH);
    }

    private void addClient(){
        mt.newClient();
    }

    private void addChef(){
        mt.newChef();
    }
}
