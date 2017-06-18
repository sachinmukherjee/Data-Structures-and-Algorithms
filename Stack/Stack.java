/* * A program for implementing stack using array
   * Created by sachin mukherjee
   * sachinmukherjee29@gmail.com
   * First In Last Out

*/
import java.util.Scanner;
class Stack
{
	final int MAX_SIZE=10;
	int stackarray[] = new int[MAX_SIZE];
	int top;										// for keeping track of top element of array so that we can remove it(FILO)

	Stack()
	{
		top =-1;
	}

	void add(int item)                            
	{
		// inserting element into stack
		stackarray[++top]=item;                   // ++top because we have assign top=-1 so first increment the index then add the item in particular index
	}

	int remove()
	{
		// removing element from stack
		return stackarray[top--];
	}

	int peek()
	{
		// displaying top most element of stack
		return stackarray[top];
	}

	boolean isEmpty()
	{
		// to check if stack is empty or not
		return top==-1;
	}

	boolean isFull()
	{
		// to check if stack is full or not
		return top==MAX_SIZE-1;
	}

	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		Stack thestack = new Stack();
		while(!thestack.isFull())
		{
			System.out.println("Enter Element to enter into stack");
			int item = scan.nextInt();
			thestack.add(item);

		}
		System.out.println("Displaying top most element");
		System.out.println(thestack.peek());
		System.out.println("Removing top element");
		System.out.println(thestack.remove());
		System.out.println(thestack.peek());




	}

}