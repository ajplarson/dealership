package ajplarson.dealership.data;

import ajplarson.dealership.TestApplicationConfiguration;
import ajplarson.dealership.models.Contact;
import ajplarson.dealership.models.State;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class StateDaoTest {

    @Autowired
    StateDao sDao;

    @Autowired
    ContactDao cDao;

    @BeforeEach
    public void setUp() {

        List<Contact> contacts = cDao.getAll();
        for (Contact contact : contacts) {
            cDao.deleteById(contact.getContactId());
        }

        List<State> states = sDao.getAll();
        for (State state : states) {
            sDao.deleteById(state.getStateId());
        }

    }

    @Test
    public void testAddState() {
        assertTrue(sDao.getAll().size() == 0);
        State state = new State();
        state.setName("Test State");
        state.setAbbr("Test");
        state = sDao.add(state);

        State fromDao = sDao.findById(state.getStateId());

        assertEquals(state, fromDao);
    }

    @Test
    public void testGetAllStates() {
        assertTrue(sDao.getAll().size() == 0);
        State state = new State();
        state.setName("Test State");
        state.setAbbr("Test");
        state = sDao.add(state);

        State secondState = new State();
        secondState.setName("Second Test State");
        secondState.setAbbr("Test Two");
        secondState = sDao.add(secondState);
        List<State> testStates = sDao.getAll();

        assertEquals(2, testStates.size());
        assertTrue(testStates.contains(state));
        assertTrue(testStates.contains(secondState));
    }


    @Test
    public void testDeleteState() {
        assertTrue(sDao.getAll().size() == 0);
        State state = new State();
        state.setName("Test State");
        state.setAbbr("Test");
        state = sDao.add(state);
        assertTrue(sDao.getAll().size() == 1);
        sDao.deleteById(state.getStateId());
        assertTrue(sDao.getAll().size() == 0);
    }

}
