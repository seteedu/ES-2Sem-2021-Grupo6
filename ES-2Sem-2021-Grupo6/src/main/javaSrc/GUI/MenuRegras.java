package GUI;

import javax.swing.JFrame;
import javax.swing.JTextField;

import CodeSmell.Rule;
import CodeSmell.RuleSet;
import CodeSmell.Threshold;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MenuRegras extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox<Object> comboBox_Metrica;
	private JComboBox<?> comboBox_logica;
	private JComboBox<?> comboBox_Sinal;
	private String[] codeSmell = { "is_God_Class", "is_Long_Method" };
	private String[] metricasClasse = { "LOC_Class", "WMC_Class", "NOM_Class" };
	private String[] metricasMetodos = { "LOC_Method", "CYCLO_Method" };
	private JComboBox<?> comboBox = new JComboBox<Object>(codeSmell);
	private ArrayList<Threshold> arraylist = new ArrayList<>();

	private Object makeObj(final String item) {
		return new Object() {
			public String toString() {
				return item;
			}
		};
	}

	public MenuRegras(MainMenu mainmenu, RuleSet rs) {
		setResizable(false);
		setSize(900, 500);
		getContentPane().setLayout(null);

		setLocationRelativeTo(null);
		WindowListener exitListener = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				rs.writeFile(MainMenu.FILE_PATH);
				System.exit(0);
			}
		};
		this.addWindowListener(exitListener);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setBounds(10, 23, 874, 449);
		panel_1.setLayout(null);

		textField = new JTextField("");
		textField.setBounds(156, 63, 180, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Regra");
		lblNewLabel.setBounds(156, 39, 46, 14);
		panel_1.add(lblNewLabel);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(180, 280, 444, 23);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblARegraNo = new JLabel("A regra não pode terminar numa proposição logica");
		lblARegraNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblARegraNo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblARegraNo.setVisible(false);
		lblARegraNo.setForeground(Color.RED);
		lblARegraNo.setBounds(186, 313, 502, 13);
		panel_1.add(lblARegraNo);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(544, 362, 117, 23);
		panel_1.add(btnConfirmar);

		JLabel lbl_sucesso = new JLabel("Regra criada com sucesso!");
		lbl_sucesso.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sucesso.setVisible(false);
		lbl_sucesso.setForeground(Color.GREEN);
		lbl_sucesso.setBounds(349, 313, 175, 13);
		panel_1.add(lbl_sucesso);

		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.setBounds(617, 233, 46, 23);
		panel_1.add(btnNewButton_1);

		ActionListener confirmActionListener = new ActionListener() {// add actionlistner to listen for change
			@Override
			public void actionPerformed(ActionEvent e) {

				if (rs.getHashMap().containsKey(textField.getText())) {
					lblARegraNo.setText("A regra com esse nome já existe!");
					lblARegraNo.setVisible(true);
				} else {
					String[] s = textField_2.getText().split(" ");
					if (s[s.length - 1].equals("E") || (s[s.length - 1].equals("OU")) || s[s.length - 1].equals("")) {
						// DAR ARRAY LIST DE THRESHOLDS
						lbl_sucesso.setVisible(false);
						lblARegraNo.setText("A regra não pode terminar numa proposição logica");
						lblARegraNo.setVisible(true);
					} else {
						if (textField.getText().equals("")) {
							lblARegraNo.setText("Por favor dê um título à regra!");
							lblARegraNo.setVisible(true);
						} else {
							lblARegraNo.setVisible(false);
							lbl_sucesso.setVisible(true);
							// RETORNAR ARRAY LIST PARA BACKEND
							Rule rule = new Rule(textField.getText(), comboBox.getSelectedItem().toString(), arraylist);
							rs.addRule(rule);
							arraylist = new ArrayList<>();
							textField.setText("");
							textField_2.setText("");
							comboBox.setEnabled(true);
							btnNewButton_1.setEnabled(true);
						}
					}

				}
			}
		};

		btnConfirmar.addActionListener(confirmActionListener);

		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainmenu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(234, 362, 89, 23);
		panel_1.add(btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("Code Smell");
		lblNewLabel_1.setBounds(617, 39, 65, 14);
		panel_1.add(lblNewLabel_1);

		comboBox.setBounds(595, 62, 117, 20);
		panel_1.add(comboBox);

		JPanel panel = new JPanel();
		panel.setBounds(156, 129, 610, 94);
		panel_1.add(panel);
		panel.setLayout(null);

		addComponents(panel);

		JLabel lblNewLabel_5 = new JLabel("E/OU:");
		lblNewLabel_5.setBounds(500, 27, 45, 13);
		panel.add(lblNewLabel_5);

		ActionListener cbActionListener = new ActionListener() {// add actionlistner to listen for change
			@Override
			public void actionPerformed(ActionEvent e) {

				String s = (String) comboBox.getSelectedItem();// get the selected item

				switch (s) {// check for a match
				case "is_God_Class":
					comboBox_Metrica.removeAllItems();
					comboBox_Metrica.addItem(makeObj("LOC_Class"));
					comboBox_Metrica.addItem(makeObj("WMC_Class"));
					comboBox_Metrica.addItem(makeObj("NOM_Class"));
					break;

				case "is_Long_Method":
					comboBox_Metrica.removeAllItems();
					comboBox_Metrica.addItem(makeObj("LOC_Method"));
					comboBox_Metrica.addItem(makeObj("CYCLO_Method"));
					break;
				}
			}
		};

		comboBox.addActionListener(cbActionListener);

		JLabel ifLabel = new JLabel("SE (");
		ifLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ifLabel.setBounds(144, 267, 45, 43);
		panel_1.add(ifLabel);

		JLabel lblNewLabel_4 = new JLabel(")");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(634, 273, 45, 31);
		panel_1.add(lblNewLabel_4);

		JButton btnLimpar = new JButton("Limpar Regra");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblARegraNo.setVisible(false);
				lbl_sucesso.setVisible(false);
				arraylist.clear();
				textField.setText("");
				textField_2.setText("");
				comboBox.setEnabled(true);
				btnNewButton_1.setEnabled(true);
			}
		});

		btnLimpar.setBounds(378, 363, 117, 21);
		panel_1.add(btnLimpar);

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comboBox.setEnabled(false);
				;
				try {
					if (!textField_2.getText().equals("")) {
						String[] s = textField_2.getText().split(" ");
						if (!((s[s.length - 1].equals("E")) || (s[s.length - 1].equals("OU")))) {
							btnNewButton_1.setEnabled(false);
							lblARegraNo.setText(
									"Não pode adicionar mais proposições! Por favor confirme ou limpe a regra.");
							lblARegraNo.setVisible(true);
						} else {
							lblARegraNo.setVisible(false);
							createThreshold(comboBox_Metrica.getSelectedItem().toString(),
									comboBox_Sinal.getSelectedItem().toString(),
									Integer.parseInt(textField_1.getText()),
									comboBox_logica.getSelectedItem().toString());
							writeToString();
							panel.removeAll();
							addComponents(panel);
							panel.revalidate();
							panel.repaint();
						}
					} else {
						lblARegraNo.setVisible(false);
						createThreshold(comboBox_Metrica.getSelectedItem().toString(),
								comboBox_Sinal.getSelectedItem().toString(), Integer.parseInt(textField_1.getText()),
								comboBox_logica.getSelectedItem().toString());
						writeToString();
						panel.removeAll();
						addComponents(panel);
						panel.revalidate();
						panel.repaint();
					}
				} catch (Exception e) {
					// FAZER CATCH DO ERRO
					lblARegraNo.setText("O limites têm de ser numeros!");
					lblARegraNo.setVisible(true);
				}

			}
		});
	}

	// -------------------------------------------------------------

	private void addComponents(JPanel panel) {

		JLabel lblNewLabel_2 = new JLabel("Métrica:");
		lblNewLabel_2.setBounds(31, 26, 46, 14);
		panel.add(lblNewLabel_2);

		if (comboBox.getSelectedItem().equals("isLongMethod")) {
			comboBox_Metrica = new JComboBox<Object>(metricasMetodos);
		} else if (comboBox.getSelectedItem().equals("is_God_Class")) {
			comboBox_Metrica = new JComboBox<Object>(metricasClasse);
		}

		String[] ss = { "", "E", "OU" };
		comboBox_logica = new JComboBox<Object>(ss);
		comboBox_logica.setBounds(500, 50, 86, 21);
		panel.add(comboBox_logica);

		comboBox_Metrica.setBounds(10, 50, 180, 20);
		panel.add(comboBox_Metrica);

		String[] s = { "<", ">" };
		comboBox_Sinal = new JComboBox<Object>(s);
		comboBox_Sinal.setBounds(245, 50, 65, 20);
		panel.add(comboBox_Sinal);

		textField_1 = new JTextField();
		textField_1.setBounds(381, 51, 56, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Limite:");
		lblNewLabel_3.setBounds(391, 26, 46, 14);
		panel.add(lblNewLabel_3);

	}

	private void writeToString() {
		String newS = textField_2.getText() + " " + comboBox_Metrica.getSelectedItem() + " "
				+ comboBox_Sinal.getSelectedItem() + " " + textField_1.getText() + " "
				+ comboBox_logica.getSelectedItem();
		textField_2.setText(newS);

	}

	private void createThreshold(String name, String math, int value, String logic) {
		if (logic.equals("")) {
			Threshold t = new Threshold(name, math, value);
			arraylist.add(t);
		} else {
			Threshold t = new Threshold(name, math, value, logic);
			arraylist.add(t);
		}
	}
}
