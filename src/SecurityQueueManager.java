import java.util.PriorityQueue;

public class SecurityQueueManager {
    private PriorityQueue<passenger> queue = new PriorityQueue<>();

    public void addPassenger(String name, PassengerType type) {
        queue.add(new passenger(name, type));
    }

    public passenger processNextPassenger() {
        return queue.poll();
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}