public enum PassengerType {
    STAFF(1),
    VIP(2),
    ECONOMY(3);

    private final int priority;

    PassengerType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
