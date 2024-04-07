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
        manager.addPassenger(PassengerType.ECONOMY);
        manager.addPassenger(PassengerType.VIP);
        manager.addPassenger(PassengerType.STAFF);
        manager.addPassenger(PassengerType.ECONOMY);

        assertEquals(PassengerType.STAFF, manager.processNextPassenger().getType());
        assertEquals(PassengerType.VIP, manager.processNextPassenger().getType());
        assertEquals(PassengerType.ECONOMY, manager.processNextPassenger().getType());
        assertEquals(PassengerType.ECONOMY, manager.processNextPassenger().getType());
    }
}
