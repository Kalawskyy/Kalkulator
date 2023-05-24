package Components;

import Components.Math.MathLineInterpreter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ButtonsPanel extends JPanel implements ActionListener {
    private final String[] nameButton = {"C_line", "C_all", "√", "%", "MRC", "M-", "M+", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "Un/Lock", "0", ".", "="};
    private final JLabel inLabel, outLabel;
    private final String[] lines;
    private final Boolean[] blines;
    private String memory;
    private Boolean lockKB;
    ButtonsPanel(JLabel inLabel, JLabel outLabel, Boolean lockKB, String[] lines, Boolean[] blines) {
        this.setBackground(Color.darkGray);
        this.setBounds(0, 100, 400, 500);
        this.setLayout(new GridLayout(6, 4, 15, 15));
        this.addComponents();
        this.inLabel = inLabel;
        this.setVisible(true);
        this.lockKB = lockKB;
        this.lines = lines;
        this.blines = blines;
        this.outLabel = outLabel;
        this.memory="0";
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
                inLabel.setText(correctInput(inLabel.getText(), a));
            }
        }
    }
    String correctInput(String inputLine, String newCharacter) {
        boolean point = false;
        try {
            for (int i = 0; i < inputLine.length(); i++) {
                if (inputLine.charAt(i) == '.') {
                    point = true;
                    break;
                }
            }
            if ((inputLine.length() >= 30 || (point && Objects.equals(newCharacter, ".")) || (!point && inputLine.length() == 0 && Objects.equals(newCharacter, "."))) && !blines[1]) {
                return inputLine;
            } else if (newCharacter.equals("C_line")) {
                System.out.println("c_line");
                return "";
            }else if (newCharacter.equals("C_all")) {
                System.out.println("C_all");
                clearData();
                return "";
            }else if ((newCharacter.equals("MRC"))||(newCharacter.equals("M+"))||(newCharacter.equals("M-"))) {
                if (newCharacter.equals("MRC")){
                    String temp=memory;
                    this.memory="0";
                    return correctInput(temp,"");
                } else if (newCharacter.equals("M+")) {
                  Double temp=Double.parseDouble(memory)+Double.parseDouble(outLabel.getText());
                  this.memory= String.valueOf(temp);
                  return inputLine;
                }else {
                    Double temp=Double.parseDouble(memory)-Double.parseDouble(outLabel.getText());
                    this.memory= String.valueOf(temp);
                    return inputLine;
                }
            } else if (newCharacter.equals("*") || newCharacter.equals("/") || newCharacter.equals("-") || newCharacter.equals("+") || newCharacter.equals("√") || newCharacter.equals("%")) {
                if ((!blines[1])&&!inputLine.isBlank()){
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
                if (lines[0].isEmpty()){
                    lines[0]=inputLine;
                }
                lines[2] = inputLine;
                MathLineInterpreter tMath = new MathLineInterpreter();
                outLabel.setText(tMath.result(lines));
                clearData();
                return "";
            } else {
                if (blines[0] && !blines[1]) {
                    blines[1] = true;
                    inputLine = "";
                    return inputLine + newCharacter;
                } else {
                    return inputLine + newCharacter;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return inputLine;
        }
    }
    private void clearData(){
        for (int i = 0;i<3; i++){
            lines[i]="";
            blines[i]=false;
        }
    }
}


