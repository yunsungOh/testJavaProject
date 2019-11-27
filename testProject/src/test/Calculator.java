package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;

public class Calculator extends JFrame {
 
	private JPanel contentPane;
	private String func = "";
	private int firstNumber;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setTitle("윤성이의 처량한 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResult =  new JLabel("0");
		lblResult.setForeground(new Color(0, 0, 0));
		lblResult.setBackground(new Color(0, 0, 255));
		lblResult.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResult.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		lblResult.setBounds(12, 26, 268, 40);
		contentPane.add(lblResult);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curr = lblResult.getText();
				firstNumber = Integer.parseInt(curr);
				lblResult.setText("0");
				func = "*";
			}
		});
		btnMul.setFont(new Font("굴림", Font.BOLD, 16));
		btnMul.setBounds(152, 76, 58, 40);
		contentPane.add(btnMul);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curr = lblResult.getText();
				firstNumber = Integer.parseInt(curr);
				lblResult.setText("0");
				func = "/";
			}
		});
		btnDiv.setFont(new Font("굴림", Font.BOLD, 16));
		btnDiv.setBounds(222, 76, 58, 40);
		contentPane.add(btnDiv);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("굴림", Font.BOLD, 16));
		btn7.setBounds(12, 126, 58, 40);
		contentPane.add(btn7);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curr = lblResult.getText();
				firstNumber = Integer.parseInt(curr);
				lblResult.setText("0");
				func = "+";
			}
		});
		btnPlus.setFont(new Font("굴림", Font.BOLD, 16));
		btnPlus.setBounds(222, 126, 58, 40);
		contentPane.add(btnPlus);
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("굴림", Font.BOLD, 16));
		btn9.setBounds(152, 126, 58, 40);
		contentPane.add(btn9);
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("굴림", Font.BOLD, 16));
		btn8.setBounds(82, 126, 58, 40);
		contentPane.add(btn8);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("굴림", Font.BOLD, 16));
		btn4.setBounds(12, 176, 58, 40);
		contentPane.add(btn4);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curr = lblResult.getText();
				firstNumber = Integer.parseInt(curr);
				lblResult.setText("0");
				func = "-";
			}
		});
		btnMinus.setFont(new Font("굴림", Font.BOLD, 16));
		btnMinus.setBounds(222, 176, 58, 40);
		contentPane.add(btnMinus);
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("굴림", Font.BOLD, 16));
		btn6.setBounds(152, 176, 58, 40);
		contentPane.add(btn6);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("굴림", Font.BOLD, 16));
		btn5.setBounds(82, 176, 58, 40);
		contentPane.add(btn5);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("굴림", Font.BOLD, 16));
		btn1.setBounds(12, 226, 58, 40);
		contentPane.add(btn1);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("굴림", Font.BOLD, 16));
		btn3.setBounds(152, 226, 58, 40);
		contentPane.add(btn3);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("굴림", Font.BOLD, 16));
		btn2.setBounds(82, 226, 58, 40);
		contentPane.add(btn2);
		
		JButton btn00 = new JButton("00");
		btn00.setFont(new Font("굴림", Font.BOLD, 16));
		btn00.setBounds(152, 276, 58, 40);
		contentPane.add(btn00);
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("굴림", Font.BOLD, 16));
		btn0.setBounds(12, 276, 128, 40);
		contentPane.add(btn0);
		
		JButton btnEnter = new JButton("=");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(func) {
				    case "+":{
				    	int currValue = Integer.parseInt(lblResult.getText());
				    	lblResult.setText((firstNumber+currValue) + "");
				    	break;
				    }
				    case "-":{
				    	int currValue = Integer.parseInt(lblResult.getText());
				    	lblResult.setText((firstNumber-currValue) + "");
				    	break;
				    }
				    case "*":{
				    	int currValue = Integer.parseInt(lblResult.getText());
				    	lblResult.setText((firstNumber*currValue) + "");
				    	break;
				    }
				    case "/":{
				    	int currValue = Integer.parseInt(lblResult.getText());
				    	lblResult.setText((firstNumber/currValue) + "");
				    	break;
				    }
				}
			}
		});
		btnEnter.setFont(new Font("굴림", Font.BOLD, 16));
		btnEnter.setBounds(222, 226, 58, 90);
		contentPane.add(btnEnter);
		
		btn00.addActionListener(new NumberActionListener(lblResult, "00"));
		btn0.addActionListener(new NumberActionListener(lblResult, "0"));
		btn1.addActionListener(new NumberActionListener(lblResult, "1"));
		btn2.addActionListener(new NumberActionListener(lblResult, "2"));
		btn3.addActionListener(new NumberActionListener(lblResult, "3"));
		btn4.addActionListener(new NumberActionListener(lblResult, "4"));
		btn5.addActionListener(new NumberActionListener(lblResult, "5"));
		btn6.addActionListener(new NumberActionListener(lblResult, "6"));
		btn7.addActionListener(new NumberActionListener(lblResult, "7"));
		btn8.addActionListener(new NumberActionListener(lblResult, "8"));
		btn9.addActionListener(new NumberActionListener(lblResult, "9"));
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResult.setText("0");
			}
		});
		btnClear.setForeground(SystemColor.activeCaptionText);
		btnClear.setBackground(SystemColor.desktop);
		btnClear.setFont(new Font("굴림", Font.BOLD, 16));
		btnClear.setBounds(82, 76, 58, 40);
		contentPane.add(btnClear);
		
		JButton btnErase = new JButton("←");
		btnErase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = lblResult.getText();
				if(result.length() == 1) {
					lblResult.setText("0");
				}else {
					lblResult.setText(result.substring(0, result.length()-1));
				}
			}
		});
		btnErase.setForeground(Color.WHITE);
		btnErase.setBackground(new Color(220, 20, 60));
		btnErase.setFont(new Font("굴림", Font.BOLD, 16));
		btnErase.setBounds(12, 76, 58, 40);
		contentPane.add(btnErase);
		
	}
}


class NumberActionListener implements ActionListener {
	private JLabel label;
	private String text;
	
	public NumberActionListener(JLabel l, String s) {
		label = l;
		text = s;
	}
	
	public void actionPerformed(ActionEvent e) {
		String curr = label.getText();
		if(curr.equals("0")) {
			label.setText(text);
		}else {
			label.setText(label.getText() + text);
		}
	}

}