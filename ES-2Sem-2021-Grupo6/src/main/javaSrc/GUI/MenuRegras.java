package GUI;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.Font;

public class MenuRegras extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JScrollPane pane;
	private JTextField textField_2;
	private JComboBox comboBox_Metrica;
	JComboBox comboBox_Sinal;
	private String[] codeSmell = {"isGodClass","isLongMethod"};
	private String[] metricasClasse = {"LOC_Class","WMC_Class","NOM_Class"};
	private String[] metricasMetodos = {"LOC_Method","CYCLO_Method"};
	JComboBox comboBox = new JComboBox(codeSmell);
	
	 private Object makeObj(final String item)  {
	     return new Object() { public String toString() { return item; } };
	   }
	
	
	public MenuRegras(MainMenu mainmenu) {
		setResizable(false);
		setSize(900,500);
		getContentPane().setLayout(null);
		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setBounds(10, 23, 874, 449);
		panel_1.setLayout(null);
		
		textField = new JTextField("TESTE");
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
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(452, 362, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBounds(291, 362, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Code Smell");
		lblNewLabel_1.setBounds(617, 39, 65, 14);
		panel_1.add(lblNewLabel_1);
		
		comboBox.setBounds(595, 62, 87, 20);
		panel_1.add(comboBox);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(156, 129, 526, 94);
		panel_1.add(panel);
		panel.setLayout(null);
		
		addComponents(panel);
		
		ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) comboBox.getSelectedItem();//get the selected item

                switch (s) {//check for a match
                    case "isGodClass":
                    	comboBox_Metrica.removeAllItems();
                    	comboBox_Metrica.addItem(makeObj("LOC_Class"));
                    	comboBox_Metrica.addItem(makeObj("WMC_Class"));
                        comboBox_Metrica.addItem(makeObj("NOM_Class"));
                        break;
                        
                    case "isLongMethod":
                    	comboBox_Metrica.removeAllItems();
                        comboBox_Metrica.addItem(makeObj("LOC_Method"));
                        comboBox_Metrica.addItem(makeObj("CYCLO_Method"));
                        break;
                }
            }
        };

        comboBox.addActionListener(cbActionListener);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.setBounds(617, 233, 46, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel ifLabel = new JLabel("SE (");
		ifLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ifLabel.setBounds(144, 267, 45, 43);
		panel_1.add(ifLabel);
		
		JLabel lblNewLabel_4 = new JLabel(")");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(634, 273, 45, 31);
		panel_1.add(lblNewLabel_4);
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comboBox.disable();
				writeToString();
				panel.removeAll();
				addComponents(panel);
				panel.revalidate();
				panel.repaint();
			}
		});
	}
	
	//-------------------------------------------------------------
	
	private void addComponents(JPanel panel){
		
		JLabel lblNewLabel_2 = new JLabel("Métrica:");
		lblNewLabel_2.setBounds(31, 26, 46, 14);
		panel.add(lblNewLabel_2);
		
		if(comboBox.getSelectedItem().equals("isLongMethod")) {
			comboBox_Metrica = new JComboBox(metricasMetodos);
		} else if (comboBox.getSelectedItem().equals("isGodClass") ){
			comboBox_Metrica = new JComboBox(metricasClasse);
		}
		comboBox_Metrica.setBounds(10, 50, 180, 20);
		panel.add(comboBox_Metrica);
		
		String[] s = {"<",">"};
		comboBox_Sinal = new JComboBox(s);
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
		String newS =  textField_2.getText() + comboBox_Metrica.getSelectedItem() + comboBox_Sinal.getSelectedItem() + textField_1.getText() ;
		textField_2.setText(newS);
		
	}
}
