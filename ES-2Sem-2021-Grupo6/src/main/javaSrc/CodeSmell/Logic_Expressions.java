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
	
//	public static void main (String[]args) {
//		Logic_Expressions n = new Logic_Expressions();
//		Threshold t1 = new Threshold("ola",  "<",2, "and");
//		Threshold t2 = new Threshold("ola", "<", 2);
//		Rule a1 = new Rule ("um","God_class");
//		a1.add_threshold(t1);
//		a1.add_threshold(t2);
//		System.out.println(a1.toFile());
//	}
	
		
	
	
	
}
