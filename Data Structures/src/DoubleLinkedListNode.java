
public class DoubleLinkedListNode {
    public int data;
    public DoubleLinkedListNode next, prev;
 
    public DoubleLinkedListNode()
    {
        next = null;
        prev = null;
        data = 0;
    }
   
    public DoubleLinkedListNode(int d,DoubleLinkedListNode n,DoubleLinkedListNode p)
    {
        data = d;
        next = n;
        prev = p;
    }
   
    public void setNext(DoubleLinkedListNode n)
    {
        next = n;
    }
  
    public void setPrev(DoubleLinkedListNode p)
    {
        prev = p;
    }    
  
    public DoubleLinkedListNode getNext()
    {
        return next;
    }
  
    public DoubleLinkedListNode getPrev()
    {
        return prev;
    }
   
    public void setData(int d)
    {
        data = d;
    }
   
    public int getData()
    {
        return data;
    }
    
     public DoubleLinkedListNode Reverse(DoubleLinkedListNode head) {
        if (head == null) {
            return head;
        }

        DoubleLinkedListNode curr = head;
        DoubleLinkedListNode pre = null;

        while (curr != null) {
            DoubleLinkedListNode next = curr.next;
            curr.next = pre;
            curr.prev = next;
            pre = curr;
            curr = next;
        }
        head = pre;
        return head;
    }

    public void Traverse(DoubleLinkedListNode node) {
        if (node == null) {
            node = this;
        }
        System.out.println("\n\nReversed LinkedList: \n\n");

        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
