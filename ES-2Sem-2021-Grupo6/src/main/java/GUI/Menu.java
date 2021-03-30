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
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;

public class Menu extends JFrame {
	private JTextField textField;
	public Menu() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Utilizador\\git\\ES-2Sem-2021-Grupo6\\ES-2Sem-2021-Grupo6\\iscte_logo.png"));
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setSize(900,500);
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setForeground(Color.LIGHT_GRAY);
		setTitle("Projeto ES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Projeto ES");
		lblNewLabel.setBounds(561, 156, 199, 69);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Utilizador\\git\\ES-2Sem-2021-Grupo6\\ES-2Sem-2021-Grupo6\\iscte_logo.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Selecione um projeto Java");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					System.out.println(selectedFile.getName());
				}
			}
		});
		btnNewButton.setBounds(487, 256, 168, 43);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(665, 262, 199, 30);
		textField.setToolTipText("");
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Utilizador\\Desktop\\istaLogo.png"));
		lblNewLabel_1.setBounds(0, 0, 450, 471);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Extrair métricas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(710, 319, 107, 23);
		getContentPane().add(btnNewButton_1);
		
	}

	public static void main(String[] args) {
		new Menu().setVisible(true);
	}
}