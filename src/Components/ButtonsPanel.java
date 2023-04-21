package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ButtonsPanel extends JPanel implements ActionListener{
   private String nameButton[]={"C","CA","√","%","MRC","M-","M+","/","7","8","9","*","4","5","6","+","1","2","3","+","0",".","="};
    ButtonsPanel(){
        this.setBackground(Color.DARK_GRAY);
        this.setBounds(0,100,400,500);
        this.setLayout(new GridLayout(6,4,15,15));
        addComponents();
        this.setVisible(true);
    }
    private void addComponents(){
        for (String x:nameButton) {
            this.add(buttonCrate(x));
        }
    }
    private JButton buttonCrate(String name){
        JButton t=new JButton(name);
        t.addActionListener(this);
        t.setActionCommand(name);
        return t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
