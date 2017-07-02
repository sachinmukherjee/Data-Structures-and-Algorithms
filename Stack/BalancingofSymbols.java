/* Program for checking Balancing of symbols using stack array based
   created by Sachin mukherjee
   sachinmukherjee29@gmail.com
*/

import java.util.Scanner;

class Stack
{
    int top;
    char stackarray[];

    Stack(int len)
    {
        stackarray = new char(len);
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
    public static void main(String[] args) 
    {
        System.out.println("Enter String to Balance");
        Scanner scan = new Scanner(System.in);
        String symbol = scan.next();
        int len = symbol.length();
        Stack thestack = new Stack(len);
        int i=0;

        while(i<len)
        {
            
        }
    }   
}