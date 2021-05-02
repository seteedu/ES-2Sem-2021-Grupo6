package CodeSmell;

public class Logic_Expressions {

	public boolean expression (Rule rule) {
		String[] s = rule.toFile().split(", ");
		if ( s.length < 6 ) {
			return one(s);
		}
		else {
			System.out.println(s[0] + "####" + s[1] + "####" + s[2] + "####" + s[3] + "####" + s[4] + "####" + s[5] + "####" + s[6] + "####" + s[7] + "####");
			if ( s[4].equals("and"))
				return twoAnd(s);
			else
				return twoOr(s);
		}
	}
	
	
	
	public boolean one(String[] proposition) {
		if ( proposition[3].equals("<"))
			if( 2 < Integer.parseInt(proposition[3]))
				return true;
			else
				return false;
		else
			if ( 2 > Integer.parseInt(proposition[3]))
				return true;
			else 
				return false;
	}
	
	
	public boolean twoAnd(String[] rule) {
		System.out.println("Estou no and");
		String[] p1 = {rule[0], rule[1], rule[2], rule[3]};
		String[] p2 = {rule[0], rule[5], rule[6], rule[7]};
		if ( one(p1) && one(p2))
			return true;
		else 
			return false;
	}
	
	public boolean twoOr(String[] rule) {
		System.out.println("Estou no or");
		String[] p1 = {rule[0], rule[1], rule[2], rule[3]};
		String[] p2 = {rule[0], rule[5], rule[6], rule[7]};
		if ( one(p1) || one(p2))
			return true;
		else 
			return false;
	}
	
	public static void main (String[]args) {
		Logic_Expressions n = new Logic_Expressions();
		Threshold t1 = new Threshold("ola",  "<",2, "and");
		Threshold t2 = new Threshold("ola", "<", 2);
		Rule a1 = new Rule ("um","God_class");
		a1.add_threshold(t1);
		a1.add_threshold(t2);
		System.out.println(a1.toFile());
		n.expression(a1);
	}
	
		
	
	
	
}
