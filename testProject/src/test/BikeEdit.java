package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BikeEdit extends JFrame {

	private JPanel contentPane;
	private JTextField tfPnumber;
	private JTextField tfCompany;
	private JTextField tfProduct;
	private JTextField tfYear;
	private JTextField tfMileage;
	private JTextField tfPrice;
	//추가
	private BikeList list;
	private BikeDAO dao;
	private BikeDTO dto;
	private String p_number;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BikeEdit frame = new BikeEdit();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
	public BikeEdit(BikeList list, String p_number) {
		this.p_number = p_number;
		this.list = list;
		System.out.println(list);
		System.out.println(dto);
		
		setTitle("편집");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("차량번호");
		lblNewLabel.setBounds(12, 45, 57, 15);
		contentPane.add(lblNewLabel);
		tfPnumber = new JTextField();
		tfPnumber.setForeground(Color.GRAY);
		tfPnumber.setBackground(Color.WHITE);
		tfPnumber.setEditable(false);
		tfPnumber.setBounds(81, 42, 116, 21);
		contentPane.add(tfPnumber);
		tfPnumber.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("제조사");
		lblNewLabel_1.setBounds(12, 70, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		tfCompany = new JTextField();
		tfCompany.setBounds(81, 67, 116, 21);
		contentPane.add(tfCompany);
		tfCompany.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("모델명");
		lblNewLabel_2.setBounds(12, 95, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		tfProduct = new JTextField();
		tfProduct.setBounds(81, 92, 116, 21);
		contentPane.add(tfProduct);
		tfProduct.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("연식");
		lblNewLabel_3.setBounds(12, 120, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		tfYear = new JTextField();
		tfYear.setBounds(81, 117, 116, 21);
		contentPane.add(tfYear);
		tfYear.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("주행거리");
		lblNewLabel_4.setBounds(12, 145, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		tfMileage = new JTextField();
		tfMileage.setBounds(81, 142, 116, 21);
		contentPane.add(tfMileage);
		tfMileage.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("가격");
		lblNewLabel_5.setBounds(12, 170, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(81, 167, 116, 21);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		dao = new BikeDAO();
		dto = dao.viewBike(p_number);
		tfPnumber.setText(dto.getP_number()+"");
		tfCompany.setText(dto.getCompany()+"");
		tfProduct.setText(dto.getProduct()+"");
		tfYear.setText(dto.getYear()+"");
		tfMileage.setText(dto.getMileage()+"");
		tfPrice.setText(dto.getPrice()+"");
		
		JButton btnNewButton = new JButton("저장");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p_number = tfPnumber.getText();
				String company = tfCompany.getText();
				String product = tfProduct.getText();
				int year = Integer.parseInt(tfYear.getText());
				int mileage = Integer.parseInt(tfMileage.getText());
				int price = Integer.parseInt(tfPrice.getText());
				BikeDTO dto = new BikeDTO(p_number, company, product, year, mileage, price);
				int result = dao.updateBike(dto);
				if(result == 1) {
					JOptionPane.showMessageDialog(BikeEdit.this, "저장되었습니다.");
					list.refreshTable();
					dispose();
				}
			}
		});
		btnNewButton.setBounds(98, 211, 99, 25);
		contentPane.add(btnNewButton);
	}

}
