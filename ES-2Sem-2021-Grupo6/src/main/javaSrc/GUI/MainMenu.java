package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.poi.EncryptedDocumentException;

import CodeSmell.RuleSet;
import Main.Excell_Summary;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Main window of the program where shows the features 
 */

@SuppressWarnings("serial")
public class MainMenu extends JFrame {
	MainMenu mainmenu = this;
	public static String FILE_PATH = "./regras.txt";
	
	/** Constructor of the main window 
	 * 	When the program starts is created an HashMap for the rules based on a text file 
	 */
	public MainMenu() {
		
		RuleSet rs = new RuleSet();
		rs.initializeMap(FILE_PATH);
		
		setSize(900,500);
		setTitle("Projeto ES");
		setResizable(false);
		getContentPane().setLayout(null);
		
		setLocationRelativeTo(null);
		
		/** When user closes the window it ends the program and writes the rules
		 * from hashMap into the text file
		 */
		WindowListener exitListener = new WindowAdapter() {

		    @Override
		    public void windowClosing(WindowEvent e) {
		    	rs.writeFile(FILE_PATH);
		    	System.exit(0);
		    }
		};
		this.addWindowListener(exitListener);
		
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
		
		/**
		 * Button to open the extract metrics window
		 */
		JButton btnNewButton = new JButton("Extrair métricas");
		btnNewButton.setBounds(252, 11, 152, 50);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					try {
						
						ExtrairMetricasMenu menu = new ExtrairMetricasMenu(mainmenu, rs);
						menu.setVisible(true);
						dispose();

					} catch (EncryptedDocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		
		/**
		 * Button to open the metrics summary window
		 */
		JButton btnVerExcel = new JButton("Ver excel");
		btnVerExcel.setBounds(252, 72, 152, 50);
		panel.add(btnVerExcel);
		btnVerExcel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MetricMenu metric = new MetricMenu(new Excell_Summary(),mainmenu,rs);
				metric.setVisible(true);
				dispose();
			}
        });
		
		/**
		 * Button to open the window where the user can create new rules
		 */
		JButton btnNewButton_2 = new JButton("Criar Regras");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuRegras regras = new MenuRegras(mainmenu, rs);
				regras.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(252, 133, 152, 50);
		panel.add(btnNewButton_2);
		
		/**
		 * Button to open the window where the user can modify his rules
		 */
		JButton btnModificarRegras = new JButton("Modificar Regras");
		btnModificarRegras.setBounds(252, 193, 152, 50);
		panel.add(btnModificarRegras);
		btnModificarRegras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModificarRegras regras = new ModificarRegras(mainmenu, rs);
				regras.setVisible(true);
				dispose();
			}
		});
		
		/**
		 * Button to open the window where the user can see the code smells of his project
		 */
		JButton btnCodeSmells = new JButton("Code Smells");
		btnCodeSmells.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MenuCodeSmells menuCodeSmells = new MenuCodeSmells(mainmenu, rs);
				menuCodeSmells.setVisible(true);
				dispose();
			}
		});
		btnCodeSmells.setBounds(252, 254, 152, 50);
		panel.add(btnCodeSmells);
		
	}
	
	/**Program main 
	 * 
	 * @param args	doesn't need any arguments
	 */
	public static void main(String[] args) {
		new MainMenu().setVisible(true);
	}
}
