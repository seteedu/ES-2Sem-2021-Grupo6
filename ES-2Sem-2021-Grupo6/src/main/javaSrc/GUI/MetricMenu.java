package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

import Main.FileHandler;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class MetricMenu extends JFrame {
	
	
	
	public MetricMenu(FileHandler fh) {
		
		
		setResizable(false);
		setSize(900,500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número de packages");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(392, 261, 204, 29);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 372, 414);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("VER EXCEL");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(28, 297, 316, 106);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Número de classes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(392, 301, 136, 29);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Número de métodos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(392, 341, 136, 29);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Número total de linhas de código ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(392, 381, 204, 29);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(392, 11, 429, 195);
		getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(MetricMenu.class.getResource("/GUI/istaLogo.png")));
		
		JLabel numPackages = new JLabel(String.valueOf(fh.getPackageTotal()));
		numPackages.setHorizontalAlignment(SwingConstants.CENTER);
		numPackages.setToolTipText("");
		numPackages.setFont(new Font("Tahoma", Font.BOLD, 14));
		numPackages.setForeground(Color.BLACK);
		numPackages.setBackground(Color.WHITE);
		numPackages.setBounds(629, 268, 192, 14);
		getContentPane().add(numPackages);
		
		JLabel numClasses = new JLabel(String.valueOf(fh.getClassTotal()));
		numClasses.setHorizontalAlignment(SwingConstants.CENTER);
		numClasses.setFont(new Font("Tahoma", Font.BOLD, 14));
		numClasses.setBounds(629, 308, 192, 14);
		getContentPane().add(numClasses);
		
		JLabel nomSumTotalLabel = new JLabel(String.valueOf(fh.getNomSumTotal()));
		nomSumTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nomSumTotalLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nomSumTotalLabel.setBounds(629, 348, 192, 14);
		getContentPane().add(nomSumTotalLabel);
		
		JLabel locSumTotalLabel = new JLabel(String.valueOf(fh.getLocSumTotal()));
		locSumTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		locSumTotalLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		locSumTotalLabel.setBounds(629, 388, 192, 14);
		getContentPane().add(locSumTotalLabel);
	}

	
}
