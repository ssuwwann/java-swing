package jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JTableTest extends JFrame implements MouseListener, KeyListener {
  private final String[] labels = {"Name", "Age", "Sex", "Korean", "English", "Math"};
  private JTextField[] fields = new JTextField[6];

  private JScrollPane scrolledTable;
  private JTable table;

  private JButton addBtn;
  private JButton delBtn;

  public JTableTest(String table){
    setLayout(new BorderLayout(10,10));

    JPanel topPanel = new JPanel(new GridLayout(6, 4, 10, 5));

    for (int i = 0; i < 6; i++) {
      topPanel.add(new JLabel(labels[i]));
      fields[i] = new JTextField(30);
      topPanel.add(fields[i]);
    }

    topPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    this.add("North",topPanel);

    // 보여지는 부분
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(620, 400);
    setLocationRelativeTo(null);
    setVisible(true);

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}
