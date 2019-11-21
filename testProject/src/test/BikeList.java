package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;

public class BikeList extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTable table;
	private JTextField tfSearch;
	//추가
	private BikeDAO dao;
	private Vector<String> col;
	private DefaultTableModel model;
	private BikeDTO dto;
	private JTextField tfClicked;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BikeList frame = new BikeList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BikeList() {	
		dao = new BikeDAO();
		col = new Vector<String>();
		col.add("차량번호");
		col.add("제조사");
		col.add("모델명");
		col.add("연식");
		col.add("주행거리");
		col.add("가격");
		list();
		
		setTitle("윤성이의 중고바이크");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 55, 448, 235);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = table.getSelectedRow();
				tfClicked.setText(table.getValueAt(idx, 0)+"");
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("모델명으로 검색");
		lblNewLabel.setBounds(58, 23, 111, 15);
		contentPane.add(lblNewLabel);
		
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});
		tfSearch.setBounds(159, 20, 225, 21);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBackground(new Color(248, 248, 255));
		btnDelete.setFont(new Font("굴림", Font.BOLD, 14));
		btnDelete.setForeground(new Color(255, 0, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p_number = tfClicked.getText();
				int result = 0;
				int response = JOptionPane.showConfirmDialog(BikeList.this, "삭제하시겠습니까?");
				if(response == JOptionPane.YES_OPTION) {
					result = dao.deleteBike(p_number);
				}
				if(result == 1) {
					JOptionPane.showMessageDialog(BikeList.this, "삭제되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnDelete.setBounds(361, 300, 99, 25);
		contentPane.add(btnDelete);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setFont(new Font("굴림", Font.PLAIN, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BikeSave frm = new BikeSave(BikeList.this);
//				BikeSave frm = new BikeSave();
				frm.setVisible(true);
				frm.setLocation(200,200);
			}
		});
		btnAdd.setBounds(12, 300, 99, 25);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("편집");
		btnEdit.setFont(new Font("굴림", Font.PLAIN, 14));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow();
				System.out.println(idx);
				if(idx == -1) {
					JOptionPane.showMessageDialog(BikeList.this, "편집할 자료를 선택하세요.");
					return;
				}else {
					String p_number =(String) table.getValueAt(idx, 0);
					BikeEdit frm = new BikeEdit(BikeList.this, p_number);
					frm.setVisible(true);
					frm.setLocation(300,300);
				}
			}
		});
		btnEdit.setBounds(123, 300, 99, 25);
		contentPane.add(btnEdit);
		
		tfClicked = new JTextField();
		tfClicked.setFont(new Font("굴림", Font.PLAIN, 14));
		tfClicked.setBounds(290, 300, 67, 25);
		contentPane.add(tfClicked);
		tfClicked.setColumns(10);
		tfClicked.setEditable(false);
		
		refreshTable();
	}
	
	public void refreshTable() {
		DefaultTableModel model = new DefaultTableModel(dao.listBike(), col);
		table.setModel(model);
	}
	
	public void search() {
		String product = tfSearch.getText();
		model = new DefaultTableModel(dao.searchBike(product), col) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
	}
	
	public void clear() {
		tfClicked.setText("");
		tfClicked.requestFocus();
	}
	
	public void list() {
		model=new DefaultTableModel(dao.listBike(), col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}
}
