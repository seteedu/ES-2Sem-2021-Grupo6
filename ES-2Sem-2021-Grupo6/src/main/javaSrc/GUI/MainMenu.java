package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.apache.poi.EncryptedDocumentException;

import Main.Excell_Summary;
import Main.FileHandler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame {
	MainMenu mainmenu = this;
	
	public MainMenu() {
		
		setSize(900,500);
		setTitle("Projeto ES");
		setResizable(false);
		getContentPane().setLayout(null);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 439, 449);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/GUI/istaLogo.png")));
		lblNewLabel.setBounds(0, 0, 439, 186);
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(253, 11, 631, 449);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Extrair métricas");
		btnNewButton.setBounds(252, 106, 127, 50);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					try {
						
						ExtrairMetricasMenu menu = new ExtrairMetricasMenu(mainmenu);
						menu.setVisible(true);
						dispose();

					} catch (EncryptedDocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		
		JButton btnVerExcel = new JButton("Ver excel");
		btnVerExcel.setBounds(252, 167, 127, 50);
		panel.add(btnVerExcel);
		btnVerExcel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MetricMenu metric = new MetricMenu(new Excell_Summary(),mainmenu);
				metric.setVisible(true);
				dispose();
			}
        });
		
		JButton btnNewButton_2 = new JButton("Criar Regras");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuRegras regras = new MenuRegras(mainmenu);
				regras.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(252, 228, 127, 50);
		panel.add(btnNewButton_2);
		
		JButton btnModificarRegras = new JButton("Modificar Regras");
		btnModificarRegras.setBounds(252, 288, 127, 50);
		panel.add(btnModificarRegras);
		
		btnModificarRegras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModificarRegras regras = new ModificarRegras(mainmenu);
				regras.setVisible(true);
				dispose();
			}
		});
	}
	public static void main(String[] args) {
		new MainMenu().setVisible(true);
	}
}
