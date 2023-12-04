package UparuMountainGUI.controller;

import java.awt.event.*;
import javax.swing.*;

public class NumberInputListener extends KeyAdapter{
    private int listSize;
    private JTextField textField;
    private JLabel label;

    public NumberInputListener(int listSize, JTextField textField, JLabel label) {
        this.listSize = listSize;
        this.textField = textField;
        this.label = label;
    }

    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= (char) (listSize + '0') || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            textField.setEditable(true);
            label.setText("");
        } else {
            textField.setEditable(false);
            label.setText("* Enter only numeric digits(1 ~ " + listSize + ")");
        }
    }
}
