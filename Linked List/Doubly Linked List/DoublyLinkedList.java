class Node
{
    int data;
    Node next;
    Node previous;

    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

public class DoublyLinkedList
{
    Node head;

    void insert(int data)
    {
        Node newnode = new Node(data);

        if(head==null)
            head = newnode;
        else
        {
            // for this case set previous first;
           head.previous = newnode;
           newnode.next = head;
           head = newnode;
        }
    }

    void displayNode()
    {
        Node current = head;
        while(current!=null)
        {
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    void deleteFirst()
    {
        if(head==null)
            System.out.println("Empty Linked List");

        else
        {
            head = head.next;
            head.previous = null;
        }
    }

    void deleteLastNode()
    {
        if(head==null)
            System.out.println("Empty Linked List");
        else
        {
            Node current = head;
            Node previous = current;
            Node pre_previous = previous;

            while(current!=null)
            {
                pre_previous = previous;
                previous = current;
                current = current.next;
            }
            pre_previous.next= null;
        }
    }





    public static void main(String args[])
    {
        DoublyLinkedList doubly = new DoublyLinkedList();

        doubly.insert(10);
        doubly.insert(55);
        doubly.insert(12);
        doubly.insert(22);
        doubly.insert(1);
        doubly.insert(100);

        doubly.displayNode();

        doubly.deleteFirst();

        doubly.displayNode();

        doubly.deleteLastNode();

        doubly.displayNode();
    }
}
