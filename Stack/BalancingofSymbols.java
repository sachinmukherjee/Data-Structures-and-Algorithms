/* Program for checking Balancing of symbols using stack array based
   created by Sachin mukherjee
   sachinmukherjee29@gmail.com
*/

import java.io.*;

class Stack
{
    int top;
    char stackarray[];

    Stack(int len)
    {
        stackarray = new char[len];
        top=-1;
    }

    void push(char data)
    {
        stackarray[++top]=data;
    }

    char pop()
    {
        return stackarray[top--];
    }
    boolean isEmpty()
    {
        return top==-1;
    }

}
class BalancingofSymbols
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String");
        String input = br.readLine();
        int len = input.length();
        Stack thestack = new Stack(len);
        int i=0;
        while(i<len)
        {
            if(input.charAt(i)=='{' || input.charAt(i) == '[' || input.charAt(i) == '(')
            {
                thestack.push(input.charAt(i));
                i++;
            }
            else if(input.charAt(i) == '}' || input.charAt(i) == ']' || input.charAt(i) == ')')
            {
                if(input.charAt(i) == thestack.pop())
                {
                    i++;
                }
                else
                {
                    System.out.println("You have encountered an error at position " +i + " due to missing closing delimiter of " +input.charAt(i));
                    break;
                }
            }
            else
            {
                i++;
            }
            if(!thestack.isEmpty())
                System.out.println("Please check your string one again");
            else
                System.out.println("You have entered a correct string");

        }
    }   
}