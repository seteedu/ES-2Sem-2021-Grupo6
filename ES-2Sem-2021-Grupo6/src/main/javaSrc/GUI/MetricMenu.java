package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import CodeSmell.RuleSet;
import Main.Excell_Summary;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

/** Where it's shown the metrics summary
 * 
 */
@SuppressWarnings("serial")
public class MetricMenu extends JFrame {
	 static JFileChooser jChooser;

	 static DefaultTableModel model = null;
	 static int tableWidth = 0; // set the tableWidth
	 static int tableHeight = 0; // set the tableHeight
	 static JScrollPane scroll;
	
	 /**Metrics summary window constructor
	  * 	
	  * @param es	Excell_Summary which will give the summary
	  * @param mainmenu	Main window to get back
	  * @param rs	hashMap with the rules to write in the text file in case user closes window
	  */
	 public MetricMenu(Excell_Summary es, MainMenu mainmenu,  RuleSet rs) {
		
		setResizable(false);
		setSize(900,500);
		getContentPane().setLayout(null);
		
		setLocationRelativeTo(null);
		
		/** When user closes the window it ends the program and writes the rules
		 * from hashMap into the text file
		 */
		WindowListener exitListener = new WindowAdapter() {

		    @Override
		    public void windowClosing(WindowEvent e) {
		    	rs.writeFile(MainMenu.FILE_PATH);
		    	System.exit(0);
		    }
		};
		this.addWindowListener(exitListener);
		
		JLabel lblNewLabel = new JLabel("Número de packages");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(392, 261, 204, 29);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 372, 414);
		getContentPane().add(panel);
		panel.setLayout(null);
		
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
		
		JLabel numPackages = new JLabel(String.valueOf(es.getNumPackages()));
		numPackages.setHorizontalAlignment(SwingConstants.CENTER);
		numPackages.setToolTipText("");
		numPackages.setFont(new Font("Tahoma", Font.BOLD, 14));
		numPackages.setForeground(Color.BLACK);
		numPackages.setBackground(Color.WHITE);
		numPackages.setBounds(629, 268, 192, 14);
		getContentPane().add(numPackages);
		
		JLabel numClasses = new JLabel("0");
		numClasses.setHorizontalAlignment(SwingConstants.CENTER);
		numClasses.setFont(new Font("Tahoma", Font.BOLD, 14));
		numClasses.setBounds(629, 308, 192, 14);
		getContentPane().add(numClasses);
		
		JLabel nomSumTotalLabel = new JLabel("0");
		nomSumTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nomSumTotalLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nomSumTotalLabel.setBounds(629, 348, 192, 14);
		getContentPane().add(nomSumTotalLabel);
		
		JLabel locSumTotalLabel = new JLabel("0");
		locSumTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		locSumTotalLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		locSumTotalLabel.setBounds(629, 388, 192, 14);
		getContentPane().add(locSumTotalLabel);
		
		/**
		 * Button to show the metrics summary
		 */
		JButton btnNewButton = new JButton("VER EXCEL");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.showOpenDialog(null);
					File file = fileChooser.getSelectedFile();
					es.getMetrics(file);
					numPackages.setText(String.valueOf(es.getNumPackages()));
					numClasses.setText(String.valueOf(es.getNumClasses()));
					nomSumTotalLabel.setText(String.valueOf(es.getNumMethods()));
					locSumTotalLabel.setText(String.valueOf(es.getNumLines()));
				} catch (IOException e) {
					// ESCREVER NA GUI FICHEIRO NAO ENCONTRADO
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(28, 297, 316, 106);
		panel.add(btnNewButton);
		
		/**
		 * Button to get back to the main window
		 */
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainmenu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(595, 437, 89, 23);
		getContentPane().add(btnNewButton_1);
	}	
}
