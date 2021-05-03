package CodeSmell;

public class Threshold{
	private String name;
	private int value;
	private String math;
	private String logic;
	
	public Threshold (String name,  String math, int value, String logic) {
		this.name = name;
		this.value = value;
		this.math = math;
		this.logic = logic;
	}
	
	public Threshold (String name,  String math, int value) {
		this.name = name;
		this.value = value;
		this.math = math;
	}
	
	@Override
	public String toString () {
		if (logic == null)
			return name + " " + math + " " + value;
		else
			return  name + " " + math + " " + value + " " + logic;
	}
	
	public String toFile() {
		if (logic == null)
			return name + ", " + math + ", " + value;
		else 
			return name + ", " + math + ", " + value + ", " + logic;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getMath() {
		return math;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getLogic() {
		return logic;
	}
	
	
}
