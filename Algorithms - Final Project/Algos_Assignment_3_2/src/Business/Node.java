package Business;


public class Node {

   
    public Node next;
    public HttpRequest request;

    public Node() {
        next = null;
        request = null;
    }

    public Node(HttpRequest req, Node n) {
        request = req;
        next = n;
    }

    public void setNext(Node n) {
        next = n;
    }
   
    public Node getNext() {
        return next;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
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
            System.out.println(node.request);
            node = node.next;
        }
    }

    public String toString() {
        return "Value: " + request + " Next: " + String.valueOf(next);
    }
}
