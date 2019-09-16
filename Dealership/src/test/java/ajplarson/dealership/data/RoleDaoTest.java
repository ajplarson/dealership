package ajplarson.dealership.data;

import ajplarson.dealership.TestApplicationConfiguration;
import ajplarson.dealership.models.BodyStyle;
import ajplarson.dealership.models.Role;
import ajplarson.dealership.models.User;
import ajplarson.dealership.models.Vehicle;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class RoleDaoTest {

        @Autowired
        RoleDao roleDao;

        @Autowired
        UserDao userDao;


        @BeforeEach
        public void setUp() {

            List<User> users = userDao.getAll();
            for (User user : users) {
                userDao.delete(user.getId());
            }

            List<Role> roles = roleDao.getAll();
            for (Role role : roles) {
                roleDao.delete(role.getId());
            }
        }

        @Test
        public void testAddRole() {
            assertTrue(roleDao.getAll().size() == 0);
            Role role = new Role();
            role.setRole("Test Role");
            role = roleDao.create(role);

            Role fromDao = roleDao.getById(role.getId());

            assertEquals(role, fromDao);
        }

        @Test
        public void testGetAllRoles() {
            assertTrue(roleDao.getAll().size() == 0);
            Role role = new Role();
            role.setRole("Test Role");
            role = roleDao.create(role);

            Role secondRole = new Role();
            secondRole.setRole("Second Test Role");
            secondRole = roleDao.create(secondRole);

            List<Role> testRoles = roleDao.getAll();
            assertEquals(2, testRoles.size());
            assertTrue(testRoles.contains(role));
            assertTrue(testRoles.contains(secondRole));
        }


        @Test
        public void testDeleteBodyStyle() {
            assertTrue(roleDao.getAll().size() == 0);
            Role role = new Role();
            role.setRole("Test Role");
            role = roleDao.create(role);
            assertTrue(roleDao.getAll().size() == 1);
            roleDao.delete(role.getId());
            assertTrue(roleDao.getAll().size() == 0);
        }

    }

