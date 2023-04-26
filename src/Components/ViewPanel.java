package Components;

import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel {


    private JTextField insertField, result;
    private String inLine="";

    public String getInLine() {
        return inLine;
    }

    public void setInLine(String inLine) {
        this.inLine =this.inLine+""+inLine;
        this.insertField.setText(this.inLine);
    }


    public void setOutLine(String outLine) {
         this.result.setText(outLine);
    }


    ViewPanel() {
        this.setBackground(Color.GRAY);
        this.setLayout(null);
        setBounds(0, 0, 400, 100);
        this.addComponents();
        this.setVisible(true);
    }

    private void addComponents() {
        this.insertField = new JTextField();
        this.insertField.setBounds(20, 10, 360, 35);
        this.add(insertField);
        this.result = new JTextField("");
        this.result.setBounds(20, 55, 360, 35);
        this.result.setEnabled(false);
        this.add(result);
    }

}
