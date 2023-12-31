package UparuMountainGUI.view;
    
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestPanel {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Layout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new FlowLayout());

    for (int i = 1; i <= 5; i++) {
      contentPane.add(new JButton("Button  " + i));
    }

    frame.pack();
    frame.setVisible(true);
  }
}