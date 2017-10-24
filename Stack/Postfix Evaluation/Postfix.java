/*Evaluation of Postfix operation */
//ALGORITHM //
/*
 * create a stack
 * take input from user
 * run untill it reaches end of input
 		* if if is a operand then push it into the stack
 		* else it is a operator
 		 	* pop two items from the stack
 		 	* compute the evaluate based on the current operator
 		 	* push the result into the stack
 * peek the stack to display the result
 */

import java.io.*;
class Postfix
{
	int array[];
	int top = -1;
	
	Postfix(int size)
	{
		array = new int[size];
	}
	
	void push(int item)
	{
		array[++top] = item;
	}
	
	int pop()
	{
		return array[top--];
	}
	int peek()
	{
		return array[top];
	}
	
	boolean isEmpty()
	{
		return top == -1;
	}
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int len = input.length();
		Postfix p = new Postfix(len);
		int i = 0;
		
		while(i<len)
		{
			char at_present = input.charAt(i);
			// If it is a operand
			if(at_present >= '0' && at_present <= '9')
			{
				p.push((int)(at_present - '0'));
				i++;
				
			}
			// else it is a operator
			else
			{
				
				int a = p.pop();			// Taking two operand from stack
				int b = p.pop();
				//compute the evaluation based on the current operator
				switch(at_present)
				{
					case '+':
					{
						int c = b +a;
						p.push(c);
						break;
					}
					case '-':
					{
						int c = b-a;
						p.push(c);
						break;
					}
					case '*':
					{
						int c = b*a;
						p.push(c);
						break;
					}
					case '/':
					{
						int c = b/a;
						p.push(c);
						break;
					}
					case '%':
					{
						int c = b%a;
						p.push(c);
						break;
					}
					default:
					{
						System.out.println("Invalid Operator");
						break;
					}
					
				}
				i++;
			}
		}

		System.out.println(p.peek());
		
	}
}