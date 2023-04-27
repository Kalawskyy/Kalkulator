package Components;
import Components.Math.MathLineInterpreter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel implements ActionListener {
    private String nameButton[] = {"C", "CA", "√", "%", "MRC", "M-", "M+", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "="};
    private String line="";
    private ViewPanel viewPanel;

    ButtonsPanel(ViewPanel vpanel) {
        this.setBackground(Color.darkGray);
        this.setBounds(0, 100, 400, 500);
        this.setLayout(new GridLayout(6, 4, 15, 15));
        this.addComponents();
        this.viewPanel=vpanel;
        this.setVisible(true);
    }

    private void addComponents() {
        for (String x : nameButton) {
            this.add(buttonCrate(x));
        }
    }

    private JButton buttonCrate(String name) {
        JButton t = new JButton(name);
        t.addActionListener(this);
        t.setActionCommand(name);
        t.setBackground(Color.lightGray);
        return t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals(nameButton[0])) {
            this.setLine("");
        }
        if (cmd.equals(nameButton[1])) {

        }
        if (cmd.equals(nameButton[2])) {
            viewPanel.setInLine(nameButton[2]);
        }
        if (cmd.equals(nameButton[3])) {
            viewPanel.setInLine(nameButton[3]);
        }
        if (cmd.equals(nameButton[4])) {

        }
        if (cmd.equals(nameButton[5])) {

        }
        if (cmd.equals(nameButton[6])) {

        }
        if (cmd.equals(nameButton[7])) {
            viewPanel.setInLine(nameButton[7]);
        }
        if (cmd.equals(nameButton[8])) {
            viewPanel.setInLine(nameButton[8]);
        }
        if (cmd.equals(nameButton[9])) {
            viewPanel.setInLine(nameButton[9]);
        }
        if (cmd.equals(nameButton[10])) {
            viewPanel.setInLine(nameButton[10]);
        }
        if (cmd.equals(nameButton[11])) {
            viewPanel.setInLine(nameButton[11]);
        }
        if (cmd.equals(nameButton[12])) {
            viewPanel.setInLine(nameButton[12]);
        }
        if (cmd.equals(nameButton[13])) {
            viewPanel.setInLine(nameButton[13]);
        }
        if (cmd.equals(nameButton[14])) {
            viewPanel.setInLine(nameButton[14]);
        }
        if (cmd.equals(nameButton[15])) {
            viewPanel.setInLine(nameButton[15]);
        }
        if (cmd.equals(nameButton[16])) {
            viewPanel.setInLine(nameButton[16]);
        }
        if (cmd.equals(nameButton[17])) {
            viewPanel.setInLine(nameButton[17]);
        }
        if (cmd.equals(nameButton[18])) {
            viewPanel.setInLine(nameButton[18]);
        }
        if (cmd.equals(nameButton[19])) {
            viewPanel.setInLine(nameButton[19]);
        }
        if (cmd.equals(nameButton[20])) {
            viewPanel.setInLine(nameButton[20]);
        }
        if (cmd.equals(nameButton[21])) {
            viewPanel.setInLine(nameButton[21]);
        }
        if (cmd.equals(nameButton[22])) {
            MathLineInterpreter mline=new MathLineInterpreter();
           viewPanel.setOutLine(mline.result(viewPanel.getInLine()));
        }


    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
