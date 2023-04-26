package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel implements ActionListener {
    private String nameButton[] = {"C", "CA", "√", "%", "MRC", "M-", "M+", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "="};
    private String line="";

    ButtonsPanel() {
        this.setBackground(Color.DARK_GRAY);
        this.setBounds(0, 100, 400, 500);
        this.setLayout(new GridLayout(6, 4, 15, 15));
        this.addComponents();
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

        }
        if (cmd.equals(nameButton[3])) {

        }
        if (cmd.equals(nameButton[4])) {

        }
        if (cmd.equals(nameButton[5])) {

        }
        if (cmd.equals(nameButton[6])) {

        }
        if (cmd.equals(nameButton[7])) {

        }
        if (cmd.equals(nameButton[8])) {

        }
        if (cmd.equals(nameButton[9])) {

        }
        if (cmd.equals(nameButton[10])) {

        }
        if (cmd.equals(nameButton[11])) {

        }
        if (cmd.equals(nameButton[12])) {

        }
        if (cmd.equals(nameButton[13])) {

        }
        if (cmd.equals(nameButton[14])) {

        }
        if (cmd.equals(nameButton[15])) {

        }
        if (cmd.equals(nameButton[16])) {

        }
        if (cmd.equals(nameButton[17])) {

        }
        if (cmd.equals(nameButton[18])) {

        }
        if (cmd.equals(nameButton[19])) {

        }
        if (cmd.equals(nameButton[20])) {

        }
        if (cmd.equals(nameButton[21])) {

        }
        if (cmd.equals(nameButton[22])) {

        }


    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
