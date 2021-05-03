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

public class ModificarRegras extends JFrame {
	public ModificarRegras(MainMenu mainmenu) {
		RuleSet rs = new RuleSet();
		Threshold t1 = new Threshold("ola",  "<",2, "and");
		Threshold t2 = new Threshold("ola", "<", 2);
		Rule a1 = new Rule ("Regra1", "God_class");
		a1.add_threshold(t1);
		a1.add_threshold(t2);
		rs.addRule(a1);
		Rule a2 = new Rule ("Regra2", "God_class");
		a2.add_threshold(t1);
		a2.add_threshold(t2);
		rs.addRule(a2);

		setResizable(false);
		setSize(900,500);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


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
				String selectedItem =(String) listRegras.getSelectedValue();
				Rule rule=rs.getHashMap().get(selectedItem);
				for(Threshold t:rule.getT_list()) {
					l2.addElement(t.toString());
				}
				listLimites.setModel(l2);

			}
		});
		listRegras.setBounds(259,50, 75,193);  
		getContentPane().add(listRegras);

		JLabel lblRegras = new JLabel("Regras:");
		lblRegras.setBounds(259, 27, 45, 13);
		getContentPane().add(lblRegras);


		JLabel lblLimites = new JLabel("Limites:");
		lblLimites.setBounds(537, 27, 45, 13);
		getContentPane().add(lblLimites);


	}
}
