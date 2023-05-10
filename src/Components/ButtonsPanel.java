package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel implements ActionListener {
    private String nameButton[] = {"C_line", "C_all", "√", "%", "MRC", "M-", "M+", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "Un/Lock", "0", ".", "="};
    private JLabel inLabel;
    private String lines[];
    private Boolean blines[];

    private Boolean lockKB;

    ButtonsPanel(JLabel inLabel, Boolean lockKB, String lines[], Boolean blines[]) {
        this.setBackground(Color.darkGray);
        this.setBounds(0, 100, 400, 500);
        this.setLayout(new GridLayout(6, 4, 15, 15));
        this.addComponents();
        this.inLabel = inLabel;
        this.setVisible(true);
        this.lockKB = lockKB;
        this.lines = lines;
        this.blines = blines;
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
        if (cmd.equals("Un/Lock")) {
            if (lockKB == true) {
                lockKB = false;
            } else {
                lockKB = true;
            }
        }
        for (String a : nameButton) {
            if (cmd.equals(a)) {
                System.out.println("Cynamonek");
                inLabel.setText(correctInput(inLabel.getText(), a));
            }
        }


    }

    String correctInput(String inputLine, String newCharacter) {
        String temp = inputLine;
        Boolean point = false;
        try {
            for (int i = 0; i < temp.length(); i++) {
                boolean b = point == false;
                System.out.println(temp.charAt(i));
                if (temp.charAt(i) == '.' && b) {
                    point = true;
                }


            }
            if (temp.length() >= 30 || (point == true && newCharacter == ".") || (point == false && temp.length() == 0 && newCharacter == ".")) {
                return inputLine;
            } else if (newCharacter.length() != 1) {
                return inputLine;
            } else {
                System.out.println("Kevin homo");
                return temp + newCharacter;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Kevin homo1");
            return inputLine;
        }


    }
}


