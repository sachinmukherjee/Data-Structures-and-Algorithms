class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

public class SingleLinkedList
{
    Node head;

    void insert(int data)
    {
        Node newnode = new Node(data);
        if(head==null)
            head = newnode;

        else
        {
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

    void deleteFirstNode()
    {
        if(head==null)
            System.out.println("Empty Linked List");
        else
        {
            head = head.next;
        }
    }

    void deleteLastNode()
    {
        if(head==null)
        {
            System.out.println("Empty Linked List");
        }
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

            pre_previous.next = null;
        }
    }

    public static void main(String args[])
    {
        SingleLinkedList single = new SingleLinkedList();
        single.insert(10);
        single.insert(22);
        single.insert(52);
        single.insert(29);
        single.insert(30);

        single.displayNode();

        single.insert(100);
        single.insert(01);

        single.displayNode();

        single.deleteFirstNode();
        single.deleteLastNode();

        single.displayNode();
    }
}
