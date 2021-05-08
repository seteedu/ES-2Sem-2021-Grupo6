package CodeSmell;

public class Logic_Expressions {
	
	/**Returns a boolean resulted from the comparison between one threshold and 
	 * a value gotten from the excel file with the project metrics
	 *  
	 * 
	 * @param t		Threshold from Rule being used
	 * @param val	Value from metrics to compare
	 * @return boolean from the comparison
	 */
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
	
	/**Returns a boolean from an "OR" comparison to find the logic value of the rule being used
	 * 
	 * @param b		current boolean from others expression logics
	 * @param t		threshold for the comparison
	 * @param val	value for the comparison 
	 * @return		boolean from an "AND" expression logic
	 */
	public boolean twoAnd(boolean b, Threshold t, int val) {
		if ( one(t, val) && b)
			return true;
		else 
			return false;
	}
	
	/**Returns a boolean from an "AND" comparison to find the logic value of the rule being used
	 * 
	 * @param b		current boolean from others expression logics
	 * @param t		threshold for the comparison
	 * @param val	value for the comparison 
	 * @return		boolean from an "OR" expression logic
	 */
	public boolean twoOr(boolean b, Threshold t, int val) {
		if ( one(t, val) || b)
			return true;
		else 
			return false;
	}
}
