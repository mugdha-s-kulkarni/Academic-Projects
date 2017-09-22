
public class Stack {

    LinkedList li = new LinkedList();

    public boolean isEmpty() {
        return li.isEmpty();
    }

    public int getSize() {
        return li.getSize();
    }

    public void push(int data) {
        li.addNodeAtHead(data);
    }

    public int pop() {
        int pop = 0;

        pop = li.getHeadNode().getData();
        li.deleteNodeAt(1);

        return pop;
    }

    public int peek() {

        return li.getHeadNode().getData();
    }

    public void display() {

        System.out.print("\nStack : \n ");
        if (li.getSize() == 0) {
            System.out.print("empty\n");
            return;
        }
        if (li.getHeadNode().getNext() == null) {
            System.out.println(li.getHeadNode().getData());
            return;
        }
        Node ptr = li.getHeadNode();
        System.out.print(li.getHeadNode().getData() + "\n");

        ptr = li.getHeadNode().getNext();
        while (ptr.getNext() != null) {
            System.out.print(ptr.getData() + "\n");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData() + "\n");

    }
}
