package jframe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame implements MouseListener, KeyListener {
	private final String[] labels = { "Name", "Age", "Sex", "Korean", "English", "Math" };
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

		String[] header = { "Name", "Age", "Sex", "Korean", "English", "Math" };
		DefaultTableModel model = new DefaultTableModel(header, 0);// header추가, 행은 0개 지정

		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrolledTable = new JScrollPane(table); // 스크롤 적용을 위한 JScrollPane 사용
		scrolledTable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add("Center", scrolledTable);

		JPanel rightPanel = new JPanel(new GridLayout(5, 1, 10, 10));
		addBtn = new JButton("레코드 추가");
		delBtn = new JButton("레코드 삭제");

		rightPanel.add(addBtn);
		rightPanel.add(delBtn);
		rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add("East", rightPanel);

		// 이벤트 추가
		addBtn.addMouseListener(this); // 추가 처리
		delBtn.addMouseListener(this); // 삭제 처리
		for (int i = 0; i < 6; i++) {
			fields[i].addKeyListener(this); // 엔터 처리
		}

		table.addMouseListener(this);

		// 보여지는 부분
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(620, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// 추가버튼이나 텍스트 필드에서 엔터가 눌리는 순간 addRecord 호출,
	public void addRecord() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String[] record = new String[6];

		for (int i = 0; i < 6; i++) {
			if (isInvaildInput(fields[i].getText())) {
				System.out.println("Invalid Input");
				return;
			}
			record[i] = fields[i].getText();
		}
		model.addRow(record);

		// 행 추가하고 필드 초기화
		for (int i = 0; i < 6; i++) {
			fields[i].setText("");
		}

		// 이후 첫 번째 필드에 포커스
		fields[0].requestFocus();
	}

	// 행 제거
	public void removeRecord(int index) {
		// 선택된 행이 없다면 가장 위의 행을 제거하고, 삭제할게 없다면 -1 값을 가진다.
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (index < 0) { // 이 조건이 왜 필요할까? => 마지막에 -1값을 가질 테니까,
			if (table.getRowCount() == 0) { // 비어있는 테이블이면,
				return;
			}
			index = 0;
		}
		model.removeRow(index);
	}

	private boolean isInvaildInput(String input) {
		return input == null || input.length() == 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	// 키보드를 눌렀을 때, Pressed가 아니고 왜 여기에?
	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_ENTER) {
			addRecord();
		}
	}

	// 추가 버튼이 클릭되었을 때,
	@Override
	public void mouseClicked(MouseEvent e) {
		Object src = e.getSource();
		if (src == addBtn) {
			addRecord();
		}

		if (src == delBtn) {
			int selected = table.getSelectedRow();
			System.out.println("선택된 행 인덱스: " + selected);
			removeRecord(selected);
		}

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
