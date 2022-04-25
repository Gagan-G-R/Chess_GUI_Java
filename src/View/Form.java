package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Form extends JPanel {

    private JButton viewGButton;
    private JButton viewPButton;

    public Form() {

        viewGButton = new JButton("Games Archive");
        viewGButton.setPreferredSize(new Dimension(278, 40));
        viewPButton = new JButton("Leader Board");
        viewPButton.setPreferredSize(new Dimension(278, 40));
        
        try {
        BufferedImage img = ImageIO.read(new File("./Images/meta-chart.png"));
        JLabel pic = new JLabel(new ImageIcon(img.getScaledInstance(800, 500, Image.SCALE_DEFAULT)));
        add(pic);
        }catch(Exception e){System.out.println("Image error : "+e);}


        // uses Grid Bag Layout
        Insets buttonInset = new Insets(20,0,0,0);
        ImageIcon Chat =  new ImageIcon("./Images/meta-chart.png");
       
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = buttonInset;
        add(viewPButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = buttonInset;
        add(viewGButton, gridBagConstraints);
        
    }


    public void viewGames(ActionListener actionListener) {
        viewGButton.addActionListener(actionListener);
    }

    public void viewPlayers(ActionListener actionListener) {
        viewPButton.addActionListener(actionListener);
    }

}
