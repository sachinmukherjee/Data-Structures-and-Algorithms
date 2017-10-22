import java.util.Scanner;
class Stack
{
// These are basic stack operation // 
	int array[];
	int top = -1;
	
	Stack(int size)
	{
		array = new int[size];
	}
	
	void push(int item)
	{
		array[++top] = item;
	}
	
	void pop()
	{
		top--;
	}
	
	int peek() 
	{
		return array[top];
	}
	
	public static void main(String args[])
	{
// These are random operation just to illustrate the stack //
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter size of stack");
		int size_of_stack = scan.nextInt();
		Stack s = new Stack(size_of_stack);
		System.out.println("Entering three items in Stack 10, 22, 30");
		s.push(10);
		s.push(22);
		s.push(30);
		System.out.println("Entering two more item into the stack");
		s.push(50);
		s.push(40);
		System.out.println("Removing one item from stack");
		s.pop();
		System.out.println("Displaying top of the stack");
		System.out.println(s.peek());
		scan.close();
		
		
	}
}
