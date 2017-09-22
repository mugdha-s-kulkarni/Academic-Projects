
public class Queue {
    
    LinkedList li = new LinkedList();
   
    public void enqueue(int value) {
        li.addNodeAtTail(value);
    }
   
    public int dequeue() {
        int i = li.getHeadNode().getData();
        li.deleteNodeAt(1);
        return i;
    }
 
    public int peek() {
      return li.getHeadNode().getData();
    }
  
    public boolean isEmpty() {
        return li.isEmpty();
    }

    public int size() {
        return li.getSize();
    } 
    
    public void display(){
        li.display();
    }
}
