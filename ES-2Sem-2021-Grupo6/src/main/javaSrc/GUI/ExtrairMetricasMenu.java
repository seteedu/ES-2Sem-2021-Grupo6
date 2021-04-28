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

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Main.FileHandler;

import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;

public class ExtrairMetricasMenu extends JFrame {
	private JTextField textField;
	private String dc = "";
	//private MainMenu mainmenu;

	public ExtrairMetricasMenu(MainMenu mainmenu) {

		//this.mainmenu=mainmenu;

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Utilizador\\git\\ES-2Sem-2021-Grupo6\\ES-2Sem-2021-Grupo6\\iscte_logo.png"));
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setSize(900,500);
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setForeground(Color.LIGHT_GRAY);
		setTitle("Projeto ES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Selecione um projeto Java");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int returnValue = fileChooser.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					dc=selectedFile.getAbsolutePath();
					textField.setText(dc);
				}
			}
		});
		btnNewButton.setBounds(10, 243, 189, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));

		getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(209, 243, 675, 22);
		textField.setToolTipText("");
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ExtrairMetricasMenu.class.getResource("/GUI/istaLogo.png")));
		lblNewLabel_1.setBounds(209, -3, 450, 267);
		getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Extrair métricas");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//if(metricas extraidas com sucesso ??)
					JOptionPane.showMessageDialog(ExtrairMetricasMenu.this,"Métricas extraidas com sucesso");
			}
		});
		
		//		btnNewButton_1.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent arg0) {
		//				if(!dc.equals("")) {
		//					try {
		//						FileHandler fh = new FileHandler(dc);
		//						MetricMenu metric = new MetricMenu(fh);
		//						metric.setVisible(true);
		//						dispose();
		//
		//					} catch (EncryptedDocumentException e) {
		//						// TODO Auto-generated catch block
		//						e.printStackTrace();
		//					}
		//					
		//					
		//				}else {
		//					JOptionPane.showMessageDialog(Menu.this,"É necessário selecionar um diretório");
		//				}
		//			}
		//		});
		btnNewButton_1.setBounds(11, 277, 188, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainmenu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(402, 376, 89, 23);
		getContentPane().add(btnNewButton_2);

	}
}