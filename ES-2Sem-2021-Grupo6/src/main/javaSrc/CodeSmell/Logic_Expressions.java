package CodeSmell;

public class Logic_Expressions {
	
		
	public boolean one(Threshold t, int val) {
		if ( t.getMath().equals("<"))
			if( val < t.getValue())
				return true;
			else 
				return false;
		else 
			if( val > t.getValue())
				return true;
			else
				return false;
	}
		
	public boolean twoAnd(boolean b, Threshold t, int val) {
		System.out.println("Estou no and");
		if ( one(t, val) && b)
			return true;
		else 
			return false;
	}
	
	public boolean twoOr(boolean b, Threshold t, int val) {
		System.out.println("Estou no or");
		if ( one(t, val) || b)
			return true;
		else 
			return false;
	}
}
