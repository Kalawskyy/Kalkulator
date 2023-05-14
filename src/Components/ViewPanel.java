package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ViewPanel extends JPanel implements KeyListener {

    private String[] nameButton = {"C", "CA", "√", "%", "MRC", "M-", "M+", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "="};
    private JLabel insertField;
    private JLabel result;

    public String[] getLines() {
        return this.lines;
    }

    private String lines[] = {"", "", ""};

    public Boolean[] getBlines() {
        return this.blines;
    }

    private Boolean blines[] = {false, false, false};


    public JLabel getInLine() {
        return this.insertField;
    }

    public JLabel setOutLine() {
        return this.result;
    }


    ViewPanel() {
        this.setBackground(Color.gray);
        this.setLayout(null);
        setBounds(0, 0, 400, 100);
        this.addComponents();
        this.setVisible(true);
    }

    private void addComponents() {
        this.insertField = new JLabel(" ");
        this.insertField.setBounds(20, 10, 360, 35);
        this.insertField.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
        this.insertField.setOpaque(true);
        this.insertField.setBackground(Color.white);
        this.add(insertField);
        this.result = new JLabel(" ");
        this.result.setBounds(20, 55, 360, 35);
        this.result.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
        this.result.setOpaque(true);
        this.result.setBackground(Color.white);
        this.add(result);


    }

    ;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_9) {
            insertField.setText(insertField.getText() + "9");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    String correctInput(String inputLine, String newCharacter) {
        //TODO correctInput - Trzeba dokończyć
        String temp = inputLine;
        Boolean point = false;
        try {
            for (int i = 0; i < temp.length(); i++) {
                boolean b = point == false;
                if (temp.charAt(i) == '.' && b) {
                    point = true;
                }
                if (temp.charAt(i) == '.' && point == true) {
                    return inputLine;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return inputLine;
        }

        return inputLine;
    }
}
