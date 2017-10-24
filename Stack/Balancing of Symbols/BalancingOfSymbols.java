/* To Check whether the given string has balanced symbols or not */
/* Algorithm */
/*
 * Input a string which has to be checked whether the string is balanced or not
-------------------LOOP STARTS------------------------------------------------------------
 * run the loop untill the end of character
   * if the character at current position is not any bracket then let it go and move forward
   * if the character at current position is a opening bracket then push it into the stack
   * if the character at given postion  is a closing bracket then 
      * if stack is empty then "Error Mismatched Occurs"
      * if it is closing bracket then match with its opening bracket 
            * if it doesnot match then "Error Mismatched Occurs"
------------------LOOP ENDS---------------------------------------------------------------
 * if the stack is not empty then "Error occurs"

*/

import java.io.*;
class BalancingOfSymbols
{
	char array[];
	int top=-1;
	
	BalancingOfSymbols(int size)
	{
		array = new char[size];
	}
	
	void push(char symbol)
	{
		array[++top] = symbol;
	}
	
	char pop()
	{
		return array[top--];
	}
	
	boolean isEmpty()
	{
		return top ==-1;
	}
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int len = input.length();
		BalancingOfSymbols balance = new BalancingOfSymbols(len);
		int i=0;
		while(i<len)
		{
			char a = input.charAt(i);
			
			if((a!='[' && a!='(' && a!='{') && (a!='}' && a!=']' && a!=')'))
				i++;
			else if(a=='{' || a=='[' || a=='(')
			{
				balance.push(a);
				i++;
			}
			else
			{
				if(balance.isEmpty())
				{
					System.out.println("Error Mismatching");
					break;
				}
				else
				{
					char check = balance.pop();
					if((a=='['&& check!=']') || (a =='{' && check != '}') || (a == '(' && check != ')'))
					{
						System.out.println("Error Mismatching!");
						break;
					}
					else 
					{
						i++;
					}
				}
			}
			
		}
		if(!balance.isEmpty())
			System.out.println("Error Reporting!!");
		
	}
}
