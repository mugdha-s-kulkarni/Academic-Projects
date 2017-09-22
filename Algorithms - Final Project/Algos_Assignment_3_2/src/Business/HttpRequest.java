package Business;
import java.sql.Time;
import javax.swing.Timer;

/**
 *
 * @author Mugdha
 */
public class HttpRequest {

    private int id;
    private long enqueueTime;
    private long dequeueTime;
    private long waitingTime;
    static int count = 0;

    public HttpRequest() {
      count = count + 1;
      id = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    public String toString(){
        return String.valueOf(id);
    }

    public long getEnqueueTime() {
        return enqueueTime;
    }

    public void setEnqueueTime(long enqueueTime) {
        this.enqueueTime = enqueueTime;
    }

    public long getDequeueTime() {
        return dequeueTime;
    }

    public void setDequeueTime(long dequeueTime) {
        this.dequeueTime = dequeueTime;
    }

    public long getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(long waitingTime) {
        this.waitingTime = waitingTime;
    }

    
}
