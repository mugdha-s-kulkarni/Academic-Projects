
public class LinkedList {

    public Node head;
    public Node tail;
    public int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void addNodeAtHead(int val) {
        Node nptr = new Node(val, null);
        size++;
        if (head == null) {
            head = nptr;
            tail = head;
        } else {
            nptr.setNext(head);
            head = nptr;
        }
    }

    public Node getHeadNode() {
        return head;
    }

    public Node getTailNode() {
        return tail;
    }

    public void addNodeAtTail(int val) {
        Node nptr = new Node(val, null);
        size++;
        if (head == null) {
            head = nptr;
            tail = head;
        } else {
            tail.setNext(nptr);
            tail = nptr;
        }
    }

    public void addNodeAtPosition(int val, int pos) {
        Node nptr = new Node(val, null);
        Node ptr = head;
        pos = pos - 1;
        for (int i = 1; i < size; i++) {
            if (i == pos) {
                Node tmp = ptr.getNext();
                ptr.setNext(nptr);
                nptr.setNext(tmp);
                break;
            }
            ptr = ptr.getNext();
        }
        size++;
    }

    public void deleteNodeAt(int pos) {
        if (pos == 1) {
            head = head.getNext();
            size--;
            return;
        }
        if (pos == size) {
            Node s = head;
            Node t = head;
            while (s != tail) {
                t = s;
                s = s.getNext();
            }
            tail = t;
            tail.setNext(null);
            size--;
            return;
        }
        Node ptr = head;
        pos = pos - 1;
        for (int i = 1; i < size - 1; i++) {
            if (i == pos) {
                Node tmp = ptr.getNext();
                tmp = tmp.getNext();
                ptr.setNext(tmp);
                break;
            }
            ptr = ptr.getNext();
        }
        size--;
    }

    public void display() {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (head.getNext() == null) {
            System.out.println(head.getData());
            return;
        }
        Node ptr = head;
        System.out.print(head.getData() + "->");
        ptr = head.getNext();
        while (ptr.getNext() != null) {
            System.out.print(ptr.getData() + "->");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData() + "\n");
    }

    public int checkCircular() {
         Node first = head, second = head;
         while (first != null && second != null && second.next != null) {
           
            second = second.next;
            if (second.next == first) {
                System.out.println("This is a circular linked list");
                return 1;
            }
        }
        System.out.println("This is not a circular linked list");
        return 0;
    }
}
