package ajplarson.dealership.data;

import ajplarson.dealership.TestApplicationConfiguration;
import ajplarson.dealership.models.Make;
import ajplarson.dealership.models.CarModel;
import ajplarson.dealership.models.Vehicle;
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
public class ModelDaoTest {

    @Autowired
    MakeDao makeDao;

    @Autowired
    VehicleDao vDao;

    @Autowired
    ModelDao modelDao;

    @BeforeEach
    public void setUp() {

        List<Vehicle> cars = vDao.getAll();
        for (Vehicle car : cars) {
            vDao.deleteById(car.getVehicleId());
        }

        List<Make> makes = makeDao.getAll();
        for (Make make : makes) {
            makeDao.deleteById(make.getMakeId());
        }
        List<CarModel> models = modelDao.getAll();
        for (CarModel model : models) {
            modelDao.deleteById(model.getModelId());
        }
    }

    @Test
    public void testAddModel() {
        assertTrue(makeDao.getAll().size() == 0);
        assertTrue(modelDao.getAll().size() == 0);
        Make make = new Make();
        make.setName("Test Make");
        make = makeDao.add(make);
        
        CarModel model = new CarModel();
        model.setName("Test Model");
        model.setMakeId(make.getMakeId());
        model = modelDao.add(model);
        
        CarModel fromDao = modelDao.findById(model.getModelId());

        assertEquals(model, fromDao);
    }

    @Test
    public void testGetAllMakes() {
        assertTrue(makeDao.getAll().size() == 0);
        assertTrue(modelDao.getAll().size() == 0);
        Make make = new Make();
        make.setName("Test Make");
        make = makeDao.add(make);
        
        CarModel model = new CarModel();
        model.setName("Test Model");
        model.setMakeId(make.getMakeId());
        model = modelDao.add(model);
        
        Make secondMake = new Make();
        secondMake.setName("Second Test Make");
        secondMake = makeDao.add(secondMake);

        CarModel secondModel = new CarModel();
        secondModel.setName("Second Test Model");
        secondModel.setMakeId(secondMake.getMakeId());
        secondModel = modelDao.add(secondModel);

        List<CarModel> testModels = modelDao.getAll();
        assertEquals(2, testModels.size());
        assertTrue(testModels.contains(model));
        assertTrue(testModels.contains(secondModel));
    }

    //no update or delete of make in specification
}
