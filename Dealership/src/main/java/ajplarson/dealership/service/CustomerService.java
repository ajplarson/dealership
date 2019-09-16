package ajplarson.dealership.service;

import ajplarson.dealership.data.ContactDao;
import ajplarson.dealership.data.SpecialDao;
import ajplarson.dealership.data.StateDao;
import ajplarson.dealership.models.Contact;
import ajplarson.dealership.models.Special;
import ajplarson.dealership.models.State;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author ajplarson
 */
@Service
public class CustomerService {

    private final StateDao stateDao;
    private final ContactDao contactDao;
    private final SpecialDao specialDao;

    public CustomerService(StateDao stateDao, ContactDao contactDao, SpecialDao specialDao) {
        this.stateDao = stateDao;
        this.contactDao = contactDao;
        this.specialDao = specialDao;
    }

    public void addContact(Contact contact) {
        contactDao.add(contact);
    }

    public List<Contact> getAllContacts() {
        return contactDao.getAll();
    }

    public List<State> getAllStates() {
        return stateDao.getAll();
    }
    
    public List<Special> getAllSpecials() {
        return specialDao.getAll();
    }

    public State getStateByName(String name) {
        if (stateDao.findByName(name) == null) {
            return null;
        } else {
            return stateDao.findByName(name);
        }
    }
    
    public void addSpecial(Special special) {
        specialDao.add(special);
    }
    
    public boolean deleteSpecial(int specialId) {
        return specialDao.deleteById(specialId);
    }
    
    public boolean updateSpecial(Special special) {
        return specialDao.update(special);
    }
    

}
