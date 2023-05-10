package Components;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {
    private ViewPanel mPanel;
    private Boolean lockKeyBoard;

    public Frame() {
        this.setBounds(200, 200, 415, 628);
        this.setDefaultCloseOperation(3);
        this.setTitle("Kalkulator");
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        this.setFocusable(true);
        lockKeyBoard = false;
        addComponents();
    }

    private void addComponents() {
        mPanel = new ViewPanel();
        this.getContentPane().add(mPanel);
        ButtonsPanel bPanel = new ButtonsPanel(mPanel.getInLine(), lockKeyBoard, mPanel.getLines(), mPanel.getBlines());
        this.getContentPane().add(bPanel);
        this.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (lockKeyBoard == false) {
            mPanel.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
