package Components;

import Components.Math.MathLineInterpreter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ButtonsPanel extends JPanel implements ActionListener {
    private final String[] nameButton = {"C_line", "C_all", "√", "%", "MRC", "M-", "M+", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "Un/Lock", "0", ".", "="};
    private final JLabel inLabel;
    private final String[] lines;
    private final Boolean[] blines;

    private Boolean lockKB;

    ButtonsPanel(JLabel inLabel, Boolean lockKB, String[] lines, Boolean[] blines) {
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
            lockKB = !lockKB;
        }
        for (String a : nameButton) {
            if (cmd.equals(a)) {
                System.out.println("Cynamonek");
                inLabel.setText(correctInput(inLabel.getText(), a));
            }
        }


    }

    String correctInput(String inputLine, String newCharacter) {
        boolean point = false;
        try {
            for (int i = 0; i < inputLine.length(); i++) {
                boolean b = !point;
                System.out.println(inputLine.charAt(i));
                if (inputLine.charAt(i) == '.' && b) {
                    point = true;
                }
            }
            if ((inputLine.length() >= 30 || (point && Objects.equals(newCharacter, ".")) || (!point && inputLine.length() == 0 && Objects.equals(newCharacter, "."))) && !blines[1]) {
                return inputLine;
            } else if (newCharacter.equals("C_line")) {
                System.out.println("c_line");
                return "";
            } else if (newCharacter.equals("*") || newCharacter.equals("/") || newCharacter.equals("-") || newCharacter.equals("+") || newCharacter.equals("√") || newCharacter.equals("%")) {
                if (!blines[1]) {
                    if (!blines[0]) {
                        blines[0] = true;
                        lines[0] = inputLine;
                        return lines[1] = newCharacter;
                    } else {
                        lines[1] = lines[1] + newCharacter;
                        return String.valueOf(lines[1].charAt(lines[1].length() - 1));
                    }
                }
                return inputLine;
            } else if (newCharacter.equals("=")) {
                lines[2]=inputLine;
                MathLineInterpreter tMath= new MathLineInterpreter();

                return tMath.result(inputLine);
            } else {
                if (blines[0] && !blines[1]) {
                    blines[1] = true;
                    inputLine = "";
                    return inputLine + newCharacter;
                }else{
                    System.out.println("Kevin homo");
                    return inputLine+newCharacter ;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Kevin homo1");
            return inputLine;
        }
    }
}


