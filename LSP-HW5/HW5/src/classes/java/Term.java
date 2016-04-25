package classes.java;

public class Term
{	private int coefficient, exponent, value;
		
	/**Saves the coefficient, exponent, and calculates the total value
	 * @param givenCoefficient
	 * @param givenExponent
	 */
	public Term(int coeff, int expo)
	{
		coefficient = coeff;
		exponent = expo;
		value = (int) Math.pow(coefficient, exponent);				// Math.pow is used to raise x to the exponent power
	}
	
	/**Converts the coefficient and exponent numbers into a string representation
	 * @return expression
	 */
	public String numToString()
	{
		String expression = "";
		if (exponent == 0 || coefficient == 0)
		{
			return Integer.toString(coefficient);
		}
		if(coefficient > 1)
		{
			expression = Integer.toString(coefficient);
		}
		expression += "x";
		if (exponent > 1)
		{
			expression = expression + "^" + Integer.toString(exponent);
		}
		return expression;
	}
	
	/**Returns value of either Coefficient, Exponent, or Value
	 * @return coefficient
	 * @return exponent
	 * @return value
	 */
	public int getCoefficient()
	{
		return coefficient;
	}
	public int getExponent()
	{
		return exponent;
	}
	public int getValue()
	{
		return value;
	}
}
