package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import CodeSmell.Rule;
import CodeSmell.RuleSet;
import Main.CodeSmell_Detector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;

/**
 * 
 * Code smell detector window where user chooses which rules to use 
 *
 */
@SuppressWarnings("serial")
public class MenuCodeSmells extends JFrame {
	private JTextField textField;
	private String ficheiro;
	private MenuCodeSmells mcs;
	
	/**Code smell detector window constructor
	 * 
	 * @param mainmenu	main window to get back
	 * @param rs		hashMap with the rules for the user to select 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MenuCodeSmells(MainMenu mainmenu, RuleSet rs) {
		this.mcs = this;
		
		CodeSmell_Detector CSD = new CodeSmell_Detector();
		
		
		setResizable(false);
		setSize(900, 500);

		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
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
		
		
		JButton btnNewButton = new JButton("Escolher Excel");
		btnNewButton.setBounds(34, 36, 192, 48);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBounds(402, 422, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(34, 153, 192, 20);
		getContentPane().add(comboBox);
		ArrayList<String> arraylist = rs.showRulesFiltered("is_God_Class");
		for(String s: arraylist) {
			comboBox.addItem(s);
		}
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(34, 230, 192, 20);
		getContentPane().add(comboBox_1);
		ArrayList<String> arraylist2 = rs.showRulesFiltered("is_Long_Method");
		for(String s: arraylist2) {
			comboBox_1.addItem(s);
		}
		
		JLabel lblNewLabel = new JLabel("Regra is_Long_Method");
		lblNewLabel.setBounds(34, 205, 139, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Regra is_God_Class");
		lblNewLabel_1.setBounds(34, 128, 139, 14);
		getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(339, 50, 192, 341);
		getContentPane().add(scrollPane);
		
		JList<String> listClass = new JList<>();
		listClass.setBounds(339, 50, 192, 341);
		scrollPane.setViewportView(listClass);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(634, 50, 192, 341);
		getContentPane().add(scrollPane2);
		
		JList<String> listMethods = new JList<>();
		listMethods.setBounds(634, 50, 192, 341);
		scrollPane2.setViewportView(listMethods);
		
		JButton btnNewButton_1 = new JButton("Extrair CodeSmells");
		
		btnNewButton_1.setBounds(34, 287, 157, 42);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Classes:");
		lblNewLabel_2.setBounds(339, 25, 89, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Métodos:");
		lblNewLabel_3.setBounds(634, 25, 89, 14);
		getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(34, 95, 192, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnQualidade = new JButton("Qualidade");
		btnQualidade.setEnabled(false);
		btnQualidade.setBounds(665, 422, 139, 23);
		getContentPane().add(btnQualidade);
		
		JLabel lblAviso = new JLabel("Por favor selecione um formato válido");
		lblAviso.setForeground(Color.RED);
		lblAviso.setBounds(34, 351, 245, 13);
		getContentPane().add(lblAviso);
		lblAviso.setVisible(false);
		
		
		//ACTION LISTENERS
		/**
		 * Button for the user to select the excel file
		 */
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.showOpenDialog(null);
					File file = fileChooser.getSelectedFile();
					textField.setText(file.getAbsolutePath());	
					ficheiro = file.getAbsolutePath();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		/**
		 * Button to start the detection of code smells 
		 * User has to select an excel file before
		 */
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if( textField.getText().equals("")|| !textField.getText().endsWith(".xlsx")) {
						lblAviso.setVisible(true);
					}else {
						lblAviso.setVisible(false);
						Rule rule = rs.getHashMap().get(comboBox.getSelectedItem()); 
						Rule rule2 = rs.getHashMap().get(comboBox_1.getSelectedItem());
						CSD.detect(ficheiro, rule, rule2);
						listClass.setModel(CSD.showClassSmells());
						listMethods.setModel(CSD.showMethodSmells());
						btnQualidade.setEnabled(true);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		/**
		 * Button to open the graph window 
		 */
		btnQualidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuAvaliacao menuA = new MenuAvaliacao(rs, CSD, mcs);
				menuA.setVisible(true);
				dispose();
			}
		});
		
		/**
		 * Button to get back to the main window
		 */
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainmenu.setVisible(true);
				dispose();
			}
		});
	}
}
