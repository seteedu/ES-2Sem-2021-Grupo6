package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import CodeSmell.RuleSet;
import Main.CodeSmell_Detector;
import Main.Quality_Graph;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

public class MenuAvaliacao extends JFrame {
	
	public MenuAvaliacao(RuleSet rs, CodeSmell_Detector CD, MenuCodeSmells mcs) {
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
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(38, 409, 89, 23);
		getContentPane().add(btnVoltar);
		
		JLabel lblVerdadeirosPositivos = new JLabel("Verdadeiros Positivos:");
		lblVerdadeirosPositivos.setBounds(10, 63, 170, 13);
		getContentPane().add(lblVerdadeirosPositivos);
		
		JLabel lblVerdadeirosNegativos = new JLabel("Verdadeiros Negativos:");
		lblVerdadeirosNegativos.setBounds(10, 86, 170, 13);
		getContentPane().add(lblVerdadeirosNegativos);
		
		JLabel lblFalsosPositivos = new JLabel("Falsos Positivos:");
		lblFalsosPositivos.setBounds(10, 125, 153, 13);
		getContentPane().add(lblFalsosPositivos);
		
		JLabel lblFalsosNegativos = new JLabel("Falsos Negativos:");
		lblFalsosNegativos.setBounds(10, 148, 170, 13);
		getContentPane().add(lblFalsosNegativos);
		
		JLabel lblVPValor = new JLabel("0");
		lblVPValor.setBounds(191, 63, 45, 13);
		getContentPane().add(lblVPValor);
		
		JLabel lblVNValor = new JLabel("0");
		lblVNValor.setBounds(190, 86, 45, 13);
		getContentPane().add(lblVNValor);
		
		JLabel lblFPValor = new JLabel("0");
		lblFPValor.setBounds(191, 125, 45, 13);
		getContentPane().add(lblFPValor);
		
		JLabel lblFNValor = new JLabel("0");
		lblFNValor.setBounds(191, 148, 45, 13);
		getContentPane().add(lblFNValor);
		
		Quality_Graph graph = new Quality_Graph(CD.classPairs(),CD.methodPairs());
		
		JFreeChart chart = ChartFactory.createBarChart(
		         "Indicadores",           
		         "",            
		         "Numero de indicadores",            
		         graph.getDataset(),          
		         PlotOrientation.VERTICAL,           
		         true, true, false);
		
		 ChartPanel chartPanel = new ChartPanel( chart );        
		 chartPanel.setBounds(262, 22, 544, 337);
	      chartPanel.setPreferredSize(new java.awt.Dimension( 300 , 150 ) );        
	      getContentPane().add( chartPanel );
	      
	      lblFNValor.setText(String.valueOf(graph.getFN()));
	      lblFPValor.setText(String.valueOf(graph.getFP()));
	      lblVNValor.setText(String.valueOf(graph.getVN()));
	      lblVPValor.setText(String.valueOf(graph.getVP()));
		
		//Listeners
		
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mcs.setVisible(true);
				dispose();
			}
		});
		
		
	}
}
