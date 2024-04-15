public class passenger implements Comparable<passenger> {
    private String name;
    private PassengerType type;
    private static int sequenceCounter = 0;

    public passenger(String name, PassengerType type) {
        this.name = name;
        this.type = type;
        this.priority = type.getPriority();
        this.sequenceNumber = ++sequenceCounter;
    }

    @Override
    public int compareTo(passenger other) {
        int priorityComparison = this.priority - other.priority;
        if (priorityComparison == 0) {
            return this.sequenceNumber - other.sequenceNumber;
        } else {
            return priorityComparison;
        }
    }

    public String getName() {
        return name;
    }

    public PassengerType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.name() + " (Priority: " + priority + ")";
    }

    
}
