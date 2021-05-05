package Main;

import java.util.HashMap;

import javax.swing.JPanel;

import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

import com.github.javaparser.utils.Pair;

public class Quality_Graph extends ApplicationFrame{
	
	private int VPCount = 0;
	private int VNCount = 0;
	private int FPCount = 0;
	private int FNCount = 0;
	
	private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Quality_Graph(HashMap<String, Pair<Boolean, Boolean>> classSmells, HashMap<String, Pair<Boolean, Boolean>> methodSmells ) {
		super( "Grafico" ); 
		for(HashMap.Entry mapElement: classSmells.entrySet()) {
			Boolean app = ((Pair<Boolean, Boolean>)mapElement.getValue()).a;
			Boolean man = ((Pair<Boolean, Boolean>)mapElement.getValue()).b;
			if( app == man && app == true  ) 
				VPCount ++;
			else if ( app == man && app == false) 
				VNCount ++;
			else if ( app != man && app == true) 
				FPCount ++;
			else 
				FNCount ++;
		}
		
		for(HashMap.Entry mapElement: methodSmells.entrySet()) {
			Boolean app = ((Pair<Boolean, Boolean>)mapElement.getValue()).a;
			Boolean man = ((Pair<Boolean, Boolean>)mapElement.getValue()).b;
			if( app == man && app == true  ) 
				VPCount ++;
			else if ( app == man && app == false) 
				VNCount ++;
			else if ( app != man && app == true) 
				FPCount ++;
			else 
				FNCount ++;
		}
		
		dataset.addValue(VPCount, "", "VP");
		dataset.addValue(VNCount, "", "VN");
		dataset.addValue(FPCount, "", "FP");
		dataset.addValue(FNCount, "", "FN");
	}
	
	
	public DefaultCategoryDataset getDataset() {
		return dataset;
	}
	
	public int getVP() {
		return VPCount;
	}
	
	public int getVN() {
		return VNCount;
	}
	public int getFP() {
		return FPCount;
	}
	public int getFN() {
		return FNCount;
	}
	
}
