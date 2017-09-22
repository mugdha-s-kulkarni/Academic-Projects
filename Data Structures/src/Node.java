
public class Node {

    public int data;
    public Node next;

    public Node() {
        next = null;
        data = 0;
    }

    public Node(int d, Node n) {
        data = d;
        next = n;
    }

    public void setNext(Node n) {
        next = n;
    }

    public void setData(int d) {
        data = d;
    }

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }

    public Node Reverse(Node head) {
        if (head == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public void Traverse(Node node) {
        if (node == null) {
            node = this;
        }
        System.out.println("\n\nReversed LinkedList\n\n");

        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public String toString() {
        return "Value: " + String.valueOf(data) + " Next: " + String.valueOf(next);
    }
}
