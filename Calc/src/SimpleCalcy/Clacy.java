package SimpleCalcy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class Clacy {

	private JFrame frmSidcalcyV;
	private JTextField txtOne;
	private JTextField txtTwo;
	private JTextField txtAns;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clacy window = new Clacy();
					window.frmSidcalcyV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Clacy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSidcalcyV = new JFrame();
		frmSidcalcyV.setIconImage(Toolkit.getDefaultToolkit().getImage(Clacy.class.getResource("/SimpleCalcy/icon/icon3.png")));
		frmSidcalcyV.setTitle("Siddharth Calcy v1.0");
		frmSidcalcyV.setBounds(100, 100, 710, 465);
		frmSidcalcyV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSidcalcyV.getContentPane().setLayout(null);
		
		txtOne = new JTextField();
		txtOne.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isLetter(c)&&!e.isAltDown()) {
					e.consume();
				}
			}
		});
		txtOne.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtOne.setBounds(213, 64, 242, 36);
		frmSidcalcyV.getContentPane().add(txtOne);
		txtOne.setColumns(10);
		
		JLabel lblOne = new JLabel("1st number");
		lblOne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOne.setBounds(31, 64, 123, 36);
		frmSidcalcyV.getContentPane().add(lblOne);
		
		JLabel lblTwo = new JLabel("2nd number");
		lblTwo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTwo.setBounds(31, 149, 123, 36);
		frmSidcalcyV.getContentPane().add(lblTwo);
		
		txtTwo = new JTextField();
		txtTwo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isLetter(c)&&!e.isAltDown()) {
					e.consume();
				}
			}
		});
		txtTwo.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTwo.setColumns(10);
		txtTwo.setBounds(213, 149, 242, 36);
		frmSidcalcyV.getContentPane().add(txtTwo);
		
		JButton AddBtn = new JButton("+");
		AddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					double num1, num2, ans;
					num1 = Double.parseDouble(txtOne.getText());
					num2 = Double.parseDouble(txtTwo.getText());
					ans = num1 + num2;
					txtAns.setText(Double.toString(ans));
			}
		});
		AddBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AddBtn.setBounds(59, 258, 109, 45);
		frmSidcalcyV.getContentPane().add(AddBtn);
		
		JButton SubBtn = new JButton("-");
		SubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					double num1, num2, ans;
					num1 = Double.parseDouble(txtOne.getText());
					num2 = Double.parseDouble(txtTwo.getText());
					ans = num1 - num2;
				txtAns.setText(Double.toString(ans));
			}
		});
		SubBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		SubBtn.setBounds(227, 258, 109, 45);
		frmSidcalcyV.getContentPane().add(SubBtn);
		
		JButton DivBtn = new JButton("/");
		DivBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					double num1, num2, ans;
					num1 = Double.parseDouble(txtOne.getText());
					num2 = Double.parseDouble(txtTwo.getText());
					if(num2==0) {
						JOptionPane.showMessageDialog(null, "Divide by zero operation!");
					}
					else {
						ans = num1 / num2;
						txtAns.setText(Double.toString(ans));
					}
			}
		});
		DivBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DivBtn.setBounds(396, 258, 109, 45);
		frmSidcalcyV.getContentPane().add(DivBtn);
		
		JButton MulBtn = new JButton("*");
		MulBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						double num1, num2, ans;
						num1 = Double.parseDouble(txtOne.getText());
						num2 = Double.parseDouble(txtTwo.getText());
						ans = num1 * num2;
						txtAns.setText(Double.toString(ans));
			}
		});
		MulBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MulBtn.setBounds(555, 258, 109, 45);
		frmSidcalcyV.getContentPane().add(MulBtn);
		
		JLabel lblAns = new JLabel("Answer");
		lblAns.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAns.setBounds(31, 358, 123, 36);
		frmSidcalcyV.getContentPane().add(lblAns);
		
		txtAns = new JTextField();
		txtAns.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtAns.setColumns(10);
		txtAns.setBounds(213, 358, 242, 36);
		frmSidcalcyV.getContentPane().add(txtAns);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOne.setText(" ");
				txtTwo.setText(" ");
				txtAns.setText(" ");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(507, 349, 109, 45);
		frmSidcalcyV.getContentPane().add(btnReset);
	}
}
