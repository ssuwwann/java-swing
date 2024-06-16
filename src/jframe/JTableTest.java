package jframe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

  public JTableTest(String title) {
    setLayout(new BorderLayout(10, 10));

    JPanel topPanel = new JPanel(new GridLayout(6, 4, 10, 5));

    for (int i = 0; i < 6; i++) {
      topPanel.add(new JLabel(labels[i]));
      fields[i] = new JTextField(30); // 3이나 30이나 .. 무슨차이일까
      topPanel.add(fields[i]);
    }

    topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    this.add("North", topPanel); // 가장 위쪽 판넬 생성

    String[] header = {"Name", "Age", "Sex", "Korean", "English", "Math"};
    DefaultTableModel model = new DefaultTableModel(header, 0);//header추가, 행은 0개 지정

    table = new JTable(model);
    table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    scrolledTable = new JScrollPane(table); // 스크롤 적용을 위한 JScrollPane 사용
    scrolledTable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    add("Center", scrolledTable);

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
