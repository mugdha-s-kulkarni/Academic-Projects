
public class DoubleLinkedList {
    protected DoubleLinkedListNode head;
    protected DoubleLinkedListNode tail ;
    public int size;
 
  
    public DoubleLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }
  
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public DoubleLinkedListNode getHeadNode() {
        return head;
    }

    public DoubleLinkedListNode getTailNode() {
        return tail;
    }

   
    public void addNodeAtHead(int val)
    {
        DoubleLinkedListNode nptr = new DoubleLinkedListNode(val, null, null);        
        if(head == null)
        {
            head = nptr;
            tail = head;
        }
        else
        {
            head.setPrev(nptr);
            nptr.setNext(head);
            head = nptr;
        }
        size++;
    }
   
    public void addNodeAtTail(int val)
    {
        DoubleLinkedListNode nptr = new DoubleLinkedListNode(val, null, null);        
        if(head == null)
        {
            head = nptr;
            tail = head;
        }
        else
        {
            nptr.setPrev(tail);
            tail.setNext(nptr);
            tail = nptr;
        }
        size++;
    }
   
    public void addNodeAtPosition(int val , int pos)
    {
        DoubleLinkedListNode nptr = new DoubleLinkedListNode(val, null, null);    
        if (pos == 1)
        {
            addNodeAtHead(val);
            return;
        }            
        DoubleLinkedListNode ptr = head;
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                DoubleLinkedListNode tmp = ptr.getNext();
                ptr.setNext(nptr);
                nptr.setPrev(ptr);
                nptr.setNext(tmp);
                tmp.setPrev(nptr);
            }
            ptr = ptr.getNext();            
        }
        size++ ;
    }
   
    public void deleteNodeAtPosition(int pos)
    {        
        if (pos == 1) 
        {
            if (size == 1)
            {
                head = null;
                tail = null;
                size = 0;
                return; 
            }
            head = head.getNext();
            head.setPrev(null);
            size--; 
            return ;
        }
        if (pos == size)
        {
            tail = tail.getPrev();
            tail.setNext(null);
            size-- ;
        }
        DoubleLinkedListNode ptr = head.getNext();
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                DoubleLinkedListNode p = ptr.getPrev();
                DoubleLinkedListNode n = ptr.getNext();
 
                p.setNext(n);
                n.setPrev(p);
                size-- ;
                return;
            }
            ptr = ptr.getNext();
        }        
    }    
   
    public void display()
    {
        System.out.print("\nDoubly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        if (head.getNext() == null) 
        {
            System.out.println(head.getData() );
            return;
        }
        DoubleLinkedListNode ptr = head;
        System.out.print(head.getData()+ " <-> ");
        ptr = head.getNext();
        while (ptr.getNext() != null)
        {
            System.out.print(ptr.getData()+ " <-> ");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
