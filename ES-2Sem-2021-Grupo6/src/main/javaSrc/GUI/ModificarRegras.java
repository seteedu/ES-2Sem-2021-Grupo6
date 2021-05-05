package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import CodeSmell.Rule;
import CodeSmell.RuleSet;
import CodeSmell.Threshold;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

/**
 * Where user can modify his rules
 * 
 */
@SuppressWarnings("serial")
public class ModificarRegras extends JFrame {
	private Rule rule;
	private JTextField textFieldLimite;
	private JTextField textFieldnomeregra;
	private int selectedItemIndex;

	/**Rules modifier menu constructor
	 * 
	 * @param mainmenu	main window to get back
	 * @param rs	hashMap to give the rules to be changed
	 */
	@SuppressWarnings("rawtypes")
	public ModificarRegras(MainMenu mainmenu, RuleSet rs) {
		setResizable(false);
		setSize(900, 500);
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

		JLabel lblRegras = new JLabel("Regras:");
		lblRegras.setBounds(259, 27, 45, 13);
		getContentPane().add(lblRegras);

		JLabel lblLimites = new JLabel("Limites:");
		lblLimites.setBounds(537, 27, 45, 13);
		getContentPane().add(lblLimites);

		JLabel lblMtetrica = new JLabel("Métrica:");
		lblMtetrica.setBounds(119, 322, 46, 14);
		getContentPane().add(lblMtetrica);

		JComboBox comboBoxMetrica = new JComboBox();
		comboBoxMetrica.setBounds(119, 355, 127, 21);
		getContentPane().add(comboBoxMetrica);

		JComboBox comboBoxSinal = new JComboBox();
		comboBoxSinal.setBounds(362, 355, 75, 21);
		getContentPane().add(comboBoxSinal);

		textFieldLimite = new JTextField();
		textFieldLimite.setColumns(10);
		textFieldLimite.setBounds(553, 356, 56, 20);
		getContentPane().add(textFieldLimite);

		JLabel lblNewLabel_Limite = new JLabel("Limite:");
		lblNewLabel_Limite.setBounds(553, 322, 46, 14);
		getContentPane().add(lblNewLabel_Limite);

		JComboBox comboBoxlogica = new JComboBox();
		comboBoxlogica.setBounds(725, 354, 56, 22);
		getContentPane().add(comboBoxlogica);

		JLabel lblNewLabel = new JLabel("E/OU:");
		lblNewLabel.setBounds(725, 322, 46, 14);
		getContentPane().add(lblNewLabel);

		textFieldnomeregra = new JTextField();
		textFieldnomeregra.setEditable(false);
		textFieldnomeregra.setBounds(426, 292, 111, 20);
		getContentPane().add(textFieldnomeregra);
		textFieldnomeregra.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome da regra:");
		lblNewLabel_1.setBounds(334, 295, 87, 14);
		getContentPane().add(lblNewLabel_1);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.setBounds(553, 416, 117, 23);
		getContentPane().add(btnConfirmar);

		/**
		 * Button to get back to the main window
		 */
		JButton btnNewButton_Voltar = new JButton("Voltar");
		btnNewButton_Voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainmenu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_Voltar.setBounds(334, 417, 89, 23);
		getContentPane().add(btnNewButton_Voltar);

		JLabel lblNewLabel_Warning = new JLabel("Por favor inisira um valor válido!");
		lblNewLabel_Warning.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Warning.setForeground(Color.RED);
		lblNewLabel_Warning.setBounds(478, 387, 261, 13);
		getContentPane().add(lblNewLabel_Warning);
		lblNewLabel_Warning.setVisible(false);

		JLabel lbl_confirmar = new JLabel("Regra alterada com sucesso!");
		lbl_confirmar.setForeground(Color.GREEN);
		lbl_confirmar.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_confirmar.setBounds(680, 420, 159, 14);
		getContentPane().add(lbl_confirmar);
		lbl_confirmar.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(230, 51, 107, 193);
		getContentPane().add(scrollPane);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(537, 50, 231, 193);
		getContentPane().add(scrollPane2);

		// ACTION LISTERNERS

		JList<String> listRegras = new JList<>(rs.showRules());
		
		JList<String> listLimites = new JList<>();
		listLimites.setBounds(537, 50, 231, 193);
		scrollPane2.setViewportView(listLimites);

		DefaultListModel<String> l2 = new DefaultListModel<>();
		
		/**
		 * User selected a rule and it fills the next list with that rule's thresholds
		 */
		listRegras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_confirmar.setVisible(false);
				textFieldnomeregra.setText((String) listRegras.getSelectedValue());
				listLimites.clearSelection();
				btnConfirmar.setEnabled(false);
				l2.clear();
				String selectedItem = (String) listRegras.getSelectedValue();
				rule = rs.getHashMap().get(selectedItem);
				for (Threshold t : rule.getThresholds()) {
					l2.addElement(t.toString());
				}
				listLimites.setModel(l2);

			}
		});

		/**
		 * User selected the threshold to modify and it fills the rest of the empty spaces with the thresholds' specifications
		 */
		listLimites.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedItemIndex = listLimites.getSelectedIndex();
				Threshold oldThresHold = rule.getThresholds().get(selectedItemIndex);

				if (oldThresHold.getLogic() == null) {
					comboBoxlogica.removeAllItems();
					comboBoxlogica.setEnabled(false);
				} else {
					comboBoxlogica.removeAllItems();
					comboBoxlogica.setEnabled(true);
					comboBoxlogica.setSelectedItem(oldThresHold.getLogic());
					comboBoxlogica.addItem("E");
					comboBoxlogica.addItem("OU");
				}

				if (rule.getCodeSmell().equals("is_God_Class")) {
					comboBoxMetrica.removeAllItems();
					comboBoxMetrica.addItem("LOC_Class");
					comboBoxMetrica.addItem("WMC_Class");
					comboBoxMetrica.addItem("NOM_Class");
					comboBoxMetrica.setSelectedItem(oldThresHold.getName());
				} else if (rule.getCodeSmell().equals("is_Long_Method")) {
					comboBoxMetrica.removeAllItems();
					comboBoxMetrica.addItem("LOC_Method");
					comboBoxMetrica.addItem("CYCLO_Method");
					comboBoxMetrica.setSelectedItem(oldThresHold.getName());
				}
				comboBoxSinal.removeAllItems();
				comboBoxSinal.addItem("<");
				comboBoxSinal.addItem(">");
				comboBoxSinal.setSelectedItem(oldThresHold.getMath());
				textFieldLimite.setText(String.valueOf(oldThresHold.getValue()));
				btnConfirmar.setEnabled(true);

			}
		});

		/**
		 * Button to confirm the changes
		 * it creates a new rule to replace the one was changed
		 */
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					try {
						lblNewLabel_Warning.setVisible(false);
						Threshold newt = null;
						if (comboBoxlogica.getSelectedItem() == null) {
							newt = createThreshold(comboBoxMetrica.getSelectedItem().toString(),
									comboBoxSinal.getSelectedItem().toString(),
									Integer.parseInt(textFieldLimite.getText()), "");
						} else {
							newt = createThreshold(comboBoxMetrica.getSelectedItem().toString(),
									comboBoxSinal.getSelectedItem().toString(),
									Integer.parseInt(textFieldLimite.getText()),
									comboBoxlogica.getSelectedItem().toString());
						}
						rule.getThresholds().set(selectedItemIndex, newt);
						listLimites.clearSelection();
						listRegras.clearSelection();
						comboBoxlogica.removeAllItems();
						comboBoxMetrica.removeAllItems();
						comboBoxSinal.removeAllItems();
						textFieldLimite.setText("");
						btnConfirmar.setEnabled(false);
						listLimites.setModel(new DefaultListModel<String>());
						listRegras.setModel(rs.showRules());
						lbl_confirmar.setVisible(true);
					} catch (Exception e1) {
						lblNewLabel_Warning.setText("Por favor insira um valor válido!");
						lblNewLabel_Warning.setVisible(true);
					}
				}

		});

		listRegras.setBounds(224, 50, 111, 193);
		scrollPane.setViewportView(listRegras);
		

	}

	/**Creates new thresholds to create the new rule 
	 * 
	 * @param name	identifies the metrics 
	 * @param math	"<" or ">" to instantiate a new Threshold
	 * @param value	value to be compared
	 * @param logic	"E" or "OU" logic operators
	 * @return a new Threshold created to add to the new rule
	 */
	private Threshold createThreshold(String name, String math, int value, String logic) {
		if (logic.equals("")) {
			return new Threshold(name, math, value);
		} else {
			return new Threshold(name, math, value, logic);
		}
	}
	
}
