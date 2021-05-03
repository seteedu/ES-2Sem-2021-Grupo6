package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JList;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Map;

import javax.swing.border.BevelBorder;

import CodeSmell.Rule;
import CodeSmell.RuleSet;
import CodeSmell.Threshold;

import javax.swing.JLabel;
import javax.swing.ListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ModificarRegras extends JFrame {
	private Rule rule;
	private JTextField textFieldLimite;
	public ModificarRegras(MainMenu mainmenu) {
		// REGRAS PARA TESTAR
		RuleSet rs = new RuleSet();
		Threshold t1 = new Threshold("ola",  "<",2, "and");
		Threshold t2 = new Threshold("ola", "<", 2);
		Rule a1 = new Rule ("Regra1", "isGodClass");
		a1.add_threshold(t1);
		a1.add_threshold(t2);
		rs.addRule(a1);
		Rule a2 = new Rule ("Regra2", "isGodClass");
		a2.add_threshold(t1);
		a2.add_threshold(t2);
		rs.addRule(a2);
		// FIM DE TESTE
		
		setResizable(false);
		setSize(900,500);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JLabel lblRegras = new JLabel("Regras:");
		lblRegras.setBounds(259, 27, 45, 13);
		getContentPane().add(lblRegras);
		
		
		JLabel lblLimites = new JLabel("Limites:");
		lblLimites.setBounds(537, 27, 45, 13);
		getContentPane().add(lblLimites);
		
		JLabel lblMtetrica = new JLabel("Métrica:");
		lblMtetrica.setBounds(68, 290, 46, 14);
		getContentPane().add(lblMtetrica);
		
		JComboBox comboBoxMetrica = new JComboBox();
		comboBoxMetrica.setBounds(68, 324, 127, 21);
		getContentPane().add(comboBoxMetrica);

		JComboBox comboBoxSinal = new JComboBox();
		comboBoxSinal.setBounds(259, 324, 75, 21);
		getContentPane().add(comboBoxSinal);
		
		textFieldLimite = new JTextField();
		textFieldLimite.setColumns(10);
		textFieldLimite.setBounds(423, 325, 56, 20);
		getContentPane().add(textFieldLimite);
		
		JLabel lblNewLabel_Limite = new JLabel("Limite:");
		lblNewLabel_Limite.setBounds(423, 291, 46, 14);
		getContentPane().add(lblNewLabel_Limite);
		
		//ACTION LISTERNERS
		
		DefaultListModel<String> l1 = new DefaultListModel<>();  

		Iterator it = rs.getHashMap().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			
			l1.addElement(pair.getKey().toString());
		}
		
		JList<String> listRegras = new JList<>(l1);

		JList<String> listLimites = new JList<>();
		listLimites.setBounds(537, 50, 75, 193);
		getContentPane().add(listLimites);
		
		DefaultListModel<String> l2 = new DefaultListModel<>();

		listRegras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listLimites.clearSelection();
				l2.clear();
				String selectedItem =(String) listRegras.getSelectedValue();
				rule=rs.getHashMap().get(selectedItem);
				for(Threshold t:rule.getT_list()) {
					l2.addElement(t.toString());
				}
				listLimites.setModel(l2);

			}
		});
		
		
		listLimites.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedItemIndex = listLimites.getSelectedIndex();
				Threshold oldThresHold = rule.getT_list().get(selectedItemIndex);
				if(rule.getCodeSmell().equals("isGodClass") ){
					comboBoxMetrica.removeAllItems();
					comboBoxMetrica.addItem("LOC_Class");
					comboBoxMetrica.addItem("WMC_Class");
					comboBoxMetrica.addItem("NOM_Class");
				} else if (rule.getCodeSmell().equals("isLongMethod")) {
					comboBoxMetrica.removeAllItems();
					comboBoxMetrica.addItem("LOC_Method");
					comboBoxMetrica.addItem("CYCLO_Method");
				}
				comboBoxSinal.removeAllItems();
				comboBoxSinal.addItem("<");
				comboBoxSinal.addItem(">");

			}
		});
		
		listRegras.setBounds(259,50, 75,193);  
		getContentPane().add(listRegras);
		
		
		



	}
}
