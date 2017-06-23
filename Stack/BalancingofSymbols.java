/* Program for checking Balancing of symbols using stack array based
   created by Sachin mukherjee
   sachinmukherjee29@gmail.com
*/

import java.util.Scanner;

class Stack
{
	char stackarray[];
	int top;

    Stack(int len)
    {
    	stackarray = new char[len];
    	top=-1;
    }

    boolean isEmpty()
    {
    	return top==-1;
    }


    void push(char item)
    {
    		stackarray[++top]=item;
    }

    char pop()
    {
    	return stackarray[top--];
    }
}

class Balancingofsymbols
{
    public static void main(String[] args) 
    {
        System.out.println("Enter string to balace");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int len = s.length();
        Stack thestack = new Stack(len);

        for(int i=0;i<len;i++) 
        {
            char c = s.charAt(i);
            if(c=='{' || c=='[' || c=='(')
                thestack.push(c);
            else
            {
                if(c=='}' || c==']' || c==')')
                {
                    if(thestack.isEmpty())
                    {
                        System.out.println("First Checking");
                        System.out.println("You have entered an extra symbol at line "+i);
                        break;
                    }

                    else if(c!=thestack.pop()) 
                    {
                        System.out.println("Second checking");
                        System.out.println("You have entered a wrong symbol at line "+i);
                        break;

                    }

                }
            }
            
        }
        if(!thestack.isEmpty())
            System.out.println("Error");


        
    }
}

