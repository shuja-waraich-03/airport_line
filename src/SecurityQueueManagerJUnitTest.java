import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SecurityQueueManagerJUnitTest {
    private SecurityQueueManager manager;


    

    @Before
    public void setUp() {
        manager = new SecurityQueueManager();
    }

    

    @Test
    public void testProcessOrder() {
        manager.addPassenger("James", PassengerType.ECONOMY);
        manager.addPassenger("John", PassengerType.VIP);
        manager.addPassenger("Jane", PassengerType.STAFF);
        manager.addPassenger("Alicia", PassengerType.ECONOMY);

        assertEquals(PassengerType.STAFF, manager.processNextPassenger().getType());
        assertEquals(PassengerType.VIP, manager.processNextPassenger().getType());
        assertEquals(PassengerType.ECONOMY, manager.processNextPassenger().getType());
        assertEquals(PassengerType.ECONOMY, manager.processNextPassenger().getType());
    }


    @Test
    public void testMultiplePassengersSameType() {
        manager.addPassenger("James", PassengerType.ECONOMY);
        manager.addPassenger("John", PassengerType.ECONOMY);
        manager.addPassenger("Jane", PassengerType.ECONOMY);
        assertEquals(PassengerType.ECONOMY, manager.processNextPassenger().getType());
        assertEquals(PassengerType.ECONOMY, manager.processNextPassenger().getType());
        assertEquals(PassengerType.ECONOMY, manager.processNextPassenger().getType());
        assertNull(manager.processNextPassenger());
    }

    @Test
    public void testOrderOfPassengersWithSamePriority() {
        manager.addPassenger("James", PassengerType.ECONOMY);
        manager.addPassenger("John", PassengerType.ECONOMY);
        assertEquals("James", manager.processNextPassenger().getName());
        assertEquals("John", manager.processNextPassenger().getName());
        assertNull(manager.processNextPassenger());
    }

    @Test
public void testMultiplePassengersAllTypes() {
    // Add multiple passengers of each type
    manager.addPassenger("VIP1", PassengerType.VIP);
    manager.addPassenger("Staff1", PassengerType.STAFF);
    manager.addPassenger("Staff2", PassengerType.STAFF);
    manager.addPassenger("Economy1", PassengerType.ECONOMY);
    manager.addPassenger("VIP2", PassengerType.VIP);
    manager.addPassenger("Economy2", PassengerType.ECONOMY);

    // Staff passengers should be processed first
    assertEquals("Staff1", manager.processNextPassenger().getName());
    assertEquals("Staff2", manager.processNextPassenger().getName());

    // Then VIP passengers
    assertEquals("VIP1", manager.processNextPassenger().getName());
    assertEquals("VIP2", manager.processNextPassenger().getName());

    // Finally, Economy passengers
    assertEquals("Economy1", manager.processNextPassenger().getName());
    assertEquals("Economy2", manager.processNextPassenger().getName());

    // There should be no more passengers in the queue
    assertNull(manager.processNextPassenger());
}
}
