
import java.util.NoSuchElementException;

public class stackUsingQueue {

    Queue q;
    Queue tmp;

    public stackUsingQueue() {
        q = new Queue();
        tmp = new Queue();
    }

    public void push(int data) {

        if (q.size() == 0) {
            q.enqueue(data);
        } else {

            int l = q.size();
            for (int i = 0; i < l; i++) {
                tmp.enqueue(q.dequeue());
            }
            q.enqueue(data);

            for (int i = 0; i < l; i++) {
                q.enqueue(tmp.dequeue());
            }
        }
    }

    public int pop() {
        if (q.size() == 0) {
            throw new NoSuchElementException("Underflow Exception");
        }
        return q.dequeue();
    }

    public int peek() {
        if (q.size() == 0) {
            throw new NoSuchElementException("Underflow Exception");
        }
        return q.peek();
    }

    public boolean isEmpty() {
        return q.size() == 0;
    }

    public int getSize() {
        return q.size();
    }

    public void display() {
        System.out.print("\nStack = ");
        int l = getSize();
        if (l == 0) {
            System.out.print("Empty\n");
        } else {
            q.display();
        }
    }
}
