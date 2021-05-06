package CodeSmell;

public class Threshold{
	private String name;
	private int value;
	private String math;
	private String logic;
	
	/**Threshold constructor when it comes with logical operators ("E" or "OU")
	 * 
	 * @param name	metrics name to compare
	 * @param math	"<" or ">" to compare the metrics value and the value given to this threshold
	 * @param value	value defined by user to use as code smells barrier
	 * @param logic	logical operator if the Rule has more Thresholds after this
	 */
	public Threshold (String name,  String math, int value, String logic) {
		this.name = name;
		this.value = value;
		this.math = math;
		this.logic = logic;
	}
	
	/**Threshold constructor when it doesn't come with logical operators ("E" or "OU")
	 * 
	 * @param name	metrics name to compare
	 * @param math	"<" or ">" to compare the metrics value and the value given to this threshold
	 * @param value	value defined by user to use as code smells barrier
	 */
	public Threshold (String name,  String math, int value) {
		this.name = name;
		this.value = value;
		this.math = math;
	}
	
	/** Returns how the threshold should be shown in the GUI
	 * 	Depends on which constructor was used
	 * 
	 * @return string with the thresholds attributes separated by " "
	 */
	@Override
	public String toString () {
		if (logic == null)
			return name + " " + math + " " + value;
		else
			return  name + " " + math + " " + value + " " + logic;
	}

	/**Returns how the threshold should be written in the text file
	 * Depends on which constructor was used
	 * 
	 * @return	string with thresholds attributes separated by ","
	 */
	public String toFile() {
		if (logic == null) {
			System.out.println("THRESHOLD: entrei no to file null");
			return name + ", " + math + ", " + value;
		}
		else 
			return name + ", " + math + ", " + value + ", " + logic;
	}
	
	/**Returns the metrics used in this threshold to get the value of excel file
	 * 
	 * @return string of metrics name
	 */
	public String getName() {
		return name;
	}
	
	/** Returns the operator to compare
	 * 
	 * @return	"<" or ">"
	 */
	public String getMath() {
		return math;
	}
	
	/** Returns the value to compare with metrics value obtained in excel file
	 * 
	 * @return integer defined by user as code smell barrier
	 */
	public int getValue() {
		return value;
	}
	
	/** Returns the logic operator 
	 * 
	 * @return "E" or "OU"
	 */
	public String getLogic() {
		return logic;
	}
	
	
}
