
import java.util.NoSuchElementException;

public class queueUsingStack {

    Stack s;
    Stack tmp;

    public queueUsingStack() {
        s = new Stack();
        tmp = new Stack();
    }

    public void enqueue(int data) {
        if (s.getSize() == 0) {
            s.push(data);
        } else {
            int l = s.getSize();
            for (int i = 0; i < l; i++) {
                tmp.push(s.pop());
            }

            s.push(data);
            for (int i = 0; i < l; i++) {
                s.push(tmp.pop());
            }
        }
    }

    public int dequeue() {
        if (s.getSize() == 0) {
            throw new NoSuchElementException("Underflow Exception");
        }
        return s.pop();
    }

    public int peek() {
        if (s.getSize() == 0) {
            throw new NoSuchElementException("Underflow Exception");
        }
        return s.peek();
    }

    public boolean isEmpty() {
        return s.getSize() == 0;
    }

    public int getSize() {
        return s.getSize();
    }

    public void display() {
        System.out.print("\nQueue = ");
        int l = getSize();
        if (l == 0) {
            System.out.print("Empty\n");
        } else {
            s.display();
        }
    }
}
