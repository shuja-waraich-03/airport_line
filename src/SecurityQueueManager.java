import java.util.PriorityQueue;

public class SecurityQueueManager {
    private PriorityQueue<passenger> queue = new PriorityQueue<>();

    public void addPassenger(PassengerType type) {
        queue.add(new passenger(type));
    }

    public passenger processNextPassenger() {
        return queue.poll();
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}