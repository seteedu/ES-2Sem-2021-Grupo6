package GUI;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JButton;

public class MenuRegras extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public MenuRegras() {
		setResizable(false);
		setSize(900,500);
		getContentPane().setLayout(null);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setBounds(41, 67, 180, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Regra");
		lblNewLabel.setBounds(41, 48, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(457, 67, 28, 20);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Code Smell");
		lblNewLabel_1.setBounds(429, 48, 56, 14);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(41, 164, 180, 20);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(320, 164, 28, 20);
		getContentPane().add(comboBox_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(429, 164, 56, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("AND");
		btnNewButton.setBounds(187, 258, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnOr = new JButton("OR");
		btnOr.setBounds(353, 258, 89, 23);
		getContentPane().add(btnOr);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(41, 353, 180, 20);
		getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(320, 353, 28, 20);
		getContentPane().add(comboBox_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(429, 353, 56, 20);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_2 = new JLabel("Métrica:");
		lblNewLabel_2.setBounds(41, 148, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("Métrica:");
		label.setBounds(41, 338, 46, 14);
		getContentPane().add(label);
		
		JLabel lblNewLabel_3 = new JLabel("Limite:");
		lblNewLabel_3.setBounds(429, 148, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblLimite = new JLabel("Limite:");
		lblLimite.setBounds(429, 338, 46, 14);
		getContentPane().add(lblLimite);
	}
}
