package Components;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame(){
        this.setBounds(200,200,415,628);
        this.setDefaultCloseOperation(3);
        this.setTitle("Kalkulator");
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        addComponents();
    }
    private void addComponents(){
        ViewPanel mPanel=new ViewPanel();
        this.getContentPane().add(mPanel);
        ButtonsPanel bPanel=new ButtonsPanel(mPanel);
        this.getContentPane().add(bPanel);


    }
}
