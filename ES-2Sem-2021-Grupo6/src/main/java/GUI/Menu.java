package GUI;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Menu extends JFrame {
	private JTextField textField;
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Utilizador\\git\\ES-2Sem-2021-Grupo6\\ES-2Sem-2021-Grupo6\\iscte_logo.png"));
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setSize(1000,800);
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setForeground(Color.LIGHT_GRAY);
		setTitle("Projeto ES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 30, 30, 30, 30, 0, 0, 30};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 0, 0, 0, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Projeto ES");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Utilizador\\git\\ES-2Sem-2021-Grupo6\\ES-2Sem-2021-Grupo6\\iscte_logo.png"));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 3;
		gbc_lblNewLabel.gridwidth = 7;
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JButton btnNewButton = new JButton("Selecione um projeto Java");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					System.out.println(selectedFile.getName());
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridwidth = 5;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		textField = new JTextField();
		textField.setToolTipText("DAVID DEGUSTADOR DE PIROCA");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridheight = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 3;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
	}

	public static void main(String[] args) {
		new Menu().setVisible(true);
	}
	
}