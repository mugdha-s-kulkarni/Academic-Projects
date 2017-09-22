package Business;


public class Queue {
    
    LinkedList li = new LinkedList();
      
   
    public void enqueue(HttpRequest req) {
        li.addNodeAtTail(req);
        req.setEnqueueTime(System.currentTimeMillis());
        
    }
   
    public HttpRequest dequeue() {
        HttpRequest req = li.getHeadNode().getRequest();
        req.setDequeueTime(System.currentTimeMillis());
        li.deleteNodeAt(1);
        return req;
    }
    
    public HttpRequest peek() {
      return li.getHeadNode().getRequest();
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
