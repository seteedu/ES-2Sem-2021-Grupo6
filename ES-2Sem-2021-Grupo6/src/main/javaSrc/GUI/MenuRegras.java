package GUI;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class MenuRegras extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JScrollPane pane;
	private JTextField textField_2;
	
	public MenuRegras(MainMenu mainmenu) {
		setResizable(false);
		setSize(900,500);
		getContentPane().setLayout(null);
		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setBounds(10, 11, 874, 449);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.setBounds(635, 219, 46, 23);
		panel_1.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(176, 276, 444, 32);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(452, 362, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBounds(291, 362, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(155, 23, 526, 185);
		panel_1.add(panel);
		panel.setLayout(null);
		
		addComponents(panel);
		
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				addComponents(panel);
				panel.revalidate();
				panel.repaint();
			}
		});
	}
	
	//-------------------------------------------------------------
	
	private void addComponents(JPanel panel){
		textField = new JTextField();
		textField.setBounds(21, 30, 180, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Regra");
		lblNewLabel.setBounds(21, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Métrica:");
		lblNewLabel_2.setBounds(21, 111, 46, 14);
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(21, 127, 180, 20);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(263, 127, 65, 20);
		panel.add(comboBox_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(409, 127, 56, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Limite:");
		lblNewLabel_3.setBounds(409, 111, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Code Smell");
		lblNewLabel_1.setBounds(409, 11, 65, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(409, 30, 56, 20);
		panel.add(comboBox);
	}
}
