public class passenger implements Comparable<passenger> {
    private PassengerType type;
    private int priority; // This is now derived directly from the PassengerType enum


    public passenger(PassengerType type) {
        this.type = type;
        this.priority = type.getPriority();
    }

    @Override
    public int compareTo(passenger other) {
        return this.priority - other.priority;
    }

    public PassengerType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.name() + " (Priority: " + priority + ")";
    }

    
}
