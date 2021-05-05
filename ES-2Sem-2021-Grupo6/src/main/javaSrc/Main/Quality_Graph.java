package Main;

import java.util.HashMap;

import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

import com.github.javaparser.utils.Pair;

/**
 * 
 * Used in "MenuAvaliacao" to show the graph
 *
 */
@SuppressWarnings("serial")
public class Quality_Graph extends ApplicationFrame{
	
	private int VPCount = 0;
	private int VNCount = 0;
	private int FPCount = 0;
	private int FNCount = 0;
	
	private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	
	/**Makes the graph to be shown
	 * 
	 * @param classSmells	HashMap with the classes as keys and a tuple with a boolean gotten
	 *  from the code smell detector and a boolean written by the user
	 * @param methodSmells	HashMap with the methods as keys and a tuple with a boolean gotten
	 * from the code smell detector and a boolean written by the user
	 */
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
	
	/**Gives the data set created
	 * 
	 * @return	DefaultCategoryDataset to create a Bar Chart
	 */
	public DefaultCategoryDataset getDataset() {
		return dataset;
	}
	
	/**Gives the number of True Positives 
	 * 
	 * @return the number of True Positives
	 */
	public int getVP() {
		return VPCount;
	}
	
	/**Gives the number of True Negatives
	 * 
	 * @return	the number of True Negatives
	 */
	public int getVN() {
		return VNCount;
	}
	
	/**Gives the number of False Positives
	 * 
	 * @return	the number of False Positives
	 */
	public int getFP() {
		return FPCount;
	}
	
	/**Gives the number of False Negatives
	 * 
	 * @return	the number of False Negatives
	 */
	public int getFN() {
		return FNCount;
	}
	
}
