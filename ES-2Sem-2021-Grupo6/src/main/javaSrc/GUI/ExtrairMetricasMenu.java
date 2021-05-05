package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import org.apache.poi.EncryptedDocumentException;

import CodeSmell.RuleSet;
import Main.FileHandler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

/** Where the user will choose a java project to extract the metrics
 * and create an excel file with those metrics
 * 
 */
@SuppressWarnings("serial")
public class ExtrairMetricasMenu extends JFrame {
	private JTextField textField;
	private String dc = "";

	/**Constructor of the window to extract the metrics from java project
	 * 
	 * @param mainmenu	main window to get back 
	 * @param rs	hashMap with rules 
	 */
	public ExtrairMetricasMenu(MainMenu mainmenu,  RuleSet rs) {
		setResizable(false);
		setSize(900, 500);
		getContentPane().setLayout(null);

		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setForeground(Color.LIGHT_GRAY);
		setTitle("Projeto ES");

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
		
		/**Button for the user to select a java project to prepare to extract its metrics
		 * 
		 */
		JButton btnNewButton = new JButton("Selecione um projeto Java");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					dc = selectedFile.getAbsolutePath();
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

		/**Button to extract metrics and then shows a message if the action was well done
		 */
		JButton btnNewButton_1 = new JButton("Extrair métricas");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!dc.equals("")) {
					try {
						@SuppressWarnings("unused")
						FileHandler fh = new FileHandler(dc);
						JOptionPane.showMessageDialog(ExtrairMetricasMenu.this, "Métricas extraidas com sucesso");
					} catch (EncryptedDocumentException e) {
						JOptionPane.showMessageDialog(ExtrairMetricasMenu.this, "Falha ao extrair métricas");
						e.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(ExtrairMetricasMenu.this, "É necessário selecionar um diretório");
				}
			}
		});
		btnNewButton_1.setBounds(11, 277, 188, 23);

		getContentPane().add(btnNewButton_1);
		
		/**
		 * Go back to the main window
		 */
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