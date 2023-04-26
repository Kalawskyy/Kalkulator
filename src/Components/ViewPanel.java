package Components;

import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel {
    private JTextField insertField,result;

    ViewPanel(){
        this.setBackground(Color.GRAY);
        this.setLayout(null);
        setBounds(0,0,400,100);
        this.addComponents();
        this.setVisible(true);
    }
    private void addComponents(){
        this.insertField=new JTextField();
        this.insertField.setBounds(20,10,360,35);
        this.add(insertField);
        this.result= new JTextField("");
        this.result.setBounds(20,55,360,35);
        this.result.setEnabled(false);
        this.add(result);
    }

}
