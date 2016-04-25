package classes.java;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial
{	
	private ArrayList<Term> expression;
	public Polynomial()
	{
		expression = new ArrayList<>();
	}
	
	//FUNCTIONS
	/**Inserts new terms as sorted polynomials into the Array list
	 * @param [Term] newTerm
	 */
	public void insert(Term newTerm)
	{
		if (expression.isEmpty())
		{
			expression.add(0, newTerm);
			return;
		}
		Term current = newTerm;
		for (int i = 0; i < expression.size(); i++)
		{
			if (expression.get(i).getExponent() > current.getExponent())
			{
				Term temp = expression.set(i, current);
				current = temp;
			}
		}
		expression.add(current);
	}
	
	/**Concatenates all polynomials in the Array list into a string and returns them
	 * @return updated Array list
	 */
	public String getList()
	{
		String myList = "";
		for (int i = 0; i < expression.size(); i++)
		{
			if (i > 0 && expression.get(i).getCoefficient() >= 0)
			{
				myList += " + ";
			}
			else if (i > 0)
			{
				myList += " ";
			}
			myList += expression.get(i).toString();
		}
		return myList;
	}
	
	/**Deletes an index of the array list
	 * @param termToDelete
	 */
	public void delete(Term termToDelete)
	{
		boolean removed = false;
		for (int i = 0; i < expression.size(); i++)
		{	
			if(expression.get(i).getCoefficient() == termToDelete.getCoefficient() &&
				expression.get(i).getExponent() == termToDelete.getExponent())
			{
				expression.remove(i);
				removed = true;
				break;
			}
		}
		if (!removed)
		{
			System.out.println("Term given was not in the Array list and therefore not removed");
		}
		expression.removeAll(Collections.singleton(null));	// Line used to remove any accumulated null terms from the Array list
	}
	
	/**Reverses the list by swapping each element with the opposite index
	 * 
	 */
	public void reverse()
	{
		for (int i = 0; i < expression.size() / 2; i++)		// i < expression.size() / 2 because we only need to iterate through half of the list
		{
			Term temp = expression.set(i, expression.get(expression.size() - 1 - i));
			expression.set(expression.size() - 1 - i, temp);
		}
	}
}