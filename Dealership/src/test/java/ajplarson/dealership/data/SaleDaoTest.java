//package ajplarson.dealership.data;
//
//import ajplarson.dealership.TestApplicationConfiguration;
//import ajplarson.dealership.models.BodyStyle;
//import ajplarson.dealership.models.Color;
//import ajplarson.dealership.models.Make;
//import ajplarson.dealership.models.Model;
//import ajplarson.dealership.models.PurchaseType;
//import ajplarson.dealership.models.Sale;
//import ajplarson.dealership.models.State;
//import ajplarson.dealership.models.User;
//import ajplarson.dealership.models.Vehicle;
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = TestApplicationConfiguration.class)
//public class SaleDaoTest {
//
//    @Autowired
//    SaleDao saleDao;
//
//    @Autowired
//    PurchaseTypeDao purchaseDao;
//
//    @Autowired
//    VehicleDao vDao;
//
//    @Autowired
//    StateDao stateDao;
//
//    @Autowired
//    UserDao userDao;
//
//    @Autowired
//    BodyStyleDao bodyDao;
//
//    @Autowired
//    ColorDao colorDao;
//
//    @Autowired
//    ModelDao modelDao;
//
//    @Autowired
//    MakeDao makeDao;
//
//    @BeforeEach
//    public void setUp() {
//
//        List<Sale> sales = saleDao.getAll();
//        for (Sale sale : sales) {
//            saleDao.deleteById(sale.getSaleId());
//        }
//
//        List<PurchaseType> purchases = purchaseDao.getAll();
//        for (PurchaseType purchase : purchases) {
//            purchaseDao.deleteById(purchase.getPurchaseTypeId());
//        }
//
//        List<Vehicle> cars = vDao.getAll();
//        for (Vehicle car : cars) {
//            vDao.deleteById(car.getVehicleId());
//        }
//
//        List<State> states = stateDao.getAll();
//        for (State state : states) {
//            stateDao.deleteById(state.getStateId());
//        }
//
//        List<User> users = userDao.getAll();
//        for (User sale : users) {
//            userDao.delete(sale.getId());
//        }
//
//        List<Color> colors = colorDao.getAll();
//        for (Color color : colors) {
//            colorDao.deleteById(color.getColorId());
//        }
//
//        List<Make> makes = makeDao.getAll();
//        for (Make make : makes) {
//            makeDao.deleteById(make.getMakeId());
//        }
//        List<Model> models = modelDao.getAll();
//        for (Model model : models) {
//            modelDao.deleteById(model.getModelId());
//        }
//        
//        List<BodyStyle> styles = bodyDao.getAll();
//        for (BodyStyle body : styles) {
//            bodyDao.deleteById(body.getBodyStyleId());
//        }
//
//    }
//
//    @Test
//    public void testAddSale() {
//        assertTrue(purchaseDao.getAll().size() == 0);
//        assertTrue(vDao.getAll().size() == 0);
//        assertTrue(stateDao.getAll().size() == 0);
//        assertTrue(userDao.getAll().size() == 0);
//        assertTrue(saleDao.getAll().size() == 0);
//        PurchaseType purchaseType = new PurchaseType();
//        purchaseType.setName("Test Name");
//        purchaseDao.add(purchaseType);
//        Vehicle vehicle = new Vehicle();
//        State state = new State();
//        User user = new User();
//        Sale sale = new Sale();
//        assertTrue(makeDao.getAll().size() == 0);
//        assertTrue(modelDao.getAll().size() == 0);
//        Make make = new Make();
//        make.setName("Test Make");
//        make = makeDao.add(make);
//
//        Model model = new Model();
//        model.setName("Test Model");
//        model.setMakeId(make.getMakeId());
//        model = modelDao.add(model);
//        assertTrue(bodyDao.getAll().size() == 0);
//        assertTrue(colorDao.getAll().size() == 0);
//        BodyStyle style = new BodyStyle();
//        style.setName("test");
//        bodyDao.add(style);
//        Color color = new Color();
//        color.setName("blue");
//        colorDao.add(color);
//        state.setAbbr("Test State Abbreviation");
//        state.setName("Test State Name");
//        purchaseType.setName("Test Purchase Type");
//        user.setUsername("username");
//        user.setPassword("password");
//        user.setEnabled(true);
//        user.setFirstName("firstName");
//        user.setLastName("lastName");
//        user.setEmail("email");
//        vehicle.setBodyStyleId(style.getBodyStyleId());
//        vehicle.setDescription("Test Description");
//        vehicle.setExteriorColorId(color.getColorId());
//        vehicle.setInteriorColorId(color.getColorId());
//        vehicle.setIsAutomatic(true);
//        vehicle.setIsFeatured(false);
//        vehicle.setIsNew(false);
//        vehicle.setMileage(10000);
//        vehicle.setModelId(model.getModelId());
//        vehicle.setMsrp(BigDecimal.ZERO);
//        vehicle.setPrice(BigDecimal.ONE);
//        vehicle.setVin("1234");
//        vehicle.setYear(2005);
//
//        user = userDao.create(user);
//        state = stateDao.add(state);
//        vehicle = vDao.add(vehicle);
//
//        sale.setAddressOne("Test Address");
//        sale.setAddressTwo("Test Address Two");
//        sale.setCity("Test City");
//        sale.setEmail("test@test.com");
//        sale.setName("Test name");
//        sale.setPhone("555-555-5555");
//        sale.setPurchaseTypeId(purchaseType.getPurchaseTypeId());
//        sale.setStateId(state.getStateId());
//        sale.setTimeOfSale(Timestamp.valueOf(LocalDateTime.now()));
//        sale.setUserId(user.getId());
//        sale.setVehicleId(vehicle.getVehicleId());
//        sale.setZipcode("55555");
//        sale = saleDao.add(sale);
//
//        Sale fromDao = saleDao.findById(sale.getSaleId());
//
//        assertEquals(sale, fromDao);
//    }
//
//    @Test
//    public void testGetAllSales() {
//        assertTrue(purchaseDao.getAll().size() == 0);
//        assertTrue(vDao.getAll().size() == 0);
//        assertTrue(stateDao.getAll().size() == 0);
//        assertTrue(userDao.getAll().size() == 0);
//        assertTrue(saleDao.getAll().size() == 0);
//        PurchaseType purchaseType = new PurchaseType();
//        purchaseType.setName("Test Name");
//        purchaseDao.add(purchaseType);
//        Vehicle vehicle = new Vehicle();
//        State state = new State();
//        User user = new User();
//        Sale sale = new Sale();
//        assertTrue(makeDao.getAll().size() == 0);
//        assertTrue(modelDao.getAll().size() == 0);
//        Make make = new Make();
//        make.setName("Test Make");
//        make = makeDao.add(make);
//
//        Model model = new Model();
//        model.setName("Test Model");
//        model.setMakeId(make.getMakeId());
//        model = modelDao.add(model);
//        assertTrue(bodyDao.getAll().size() == 0);
//        assertTrue(colorDao.getAll().size() == 0);
//        BodyStyle style = new BodyStyle();
//        style.setName("test");
//        bodyDao.add(style);
//        Color color = new Color();
//        color.setName("blue");
//        colorDao.add(color);
//        state.setAbbr("Test State Abbreviation");
//        state.setName("Test State Name");
//        purchaseType.setName("Test Purchase Type");
//        user.setUsername("username");
//        user.setPassword("password");
//        user.setEnabled(true);
//        user.setFirstName("firstName");
//        user.setLastName("lastName");
//        user.setEmail("email");
//        vehicle.setBodyStyleId(style.getBodyStyleId());
//        vehicle.setDescription("Test Description");
//        vehicle.setExteriorColorId(color.getColorId());
//        vehicle.setInteriorColorId(color.getColorId());
//        vehicle.setIsAutomatic(true);
//        vehicle.setIsFeatured(false);
//        vehicle.setIsNew(false);
//        vehicle.setMileage(10000);
//        vehicle.setModelId(model.getModelId());
//        vehicle.setMsrp(BigDecimal.ZERO);
//        vehicle.setPrice(BigDecimal.ONE);
//        vehicle.setVin("1234");
//        vehicle.setYear(2005);
//
//        user = userDao.create(user);
//        state = stateDao.add(state);
//        vehicle = vDao.add(vehicle);
//        sale.setAddressOne("Test Address");
//        sale.setAddressTwo("Test Address Two");
//        sale.setCity("Test City");
//        sale.setEmail("test@test.com");
//        sale.setName("Test name");
//        sale.setPhone("555-555-5555");
//        sale.setPurchaseTypeId(purchaseType.getPurchaseTypeId());
//        sale.setStateId(state.getStateId());
//        sale.setTimeOfSale(Timestamp.valueOf(LocalDateTime.now()));
//        sale.setUserId(user.getId());
//        sale.setVehicleId(vehicle.getVehicleId());
//        sale.setZipcode("55555");
//        sale = saleDao.add(sale);
//
//        Sale secondSale = new Sale();
//
//        secondSale.setAddressOne("Second Test Address");
//        secondSale.setAddressTwo("Second Test Address Two");
//        secondSale.setCity("Second Test City");
//        secondSale.setEmail("Secondtest@test.com");
//        secondSale.setName("Second Test name");
//        secondSale.setPhone("535-555-5555");
//        secondSale.setPurchaseTypeId(purchaseType.getPurchaseTypeId());
//        secondSale.setStateId(state.getStateId());
//        secondSale.setTimeOfSale(Timestamp.valueOf(LocalDateTime.now()));
//        secondSale.setUserId(user.getId());
//        secondSale.setVehicleId(vehicle.getVehicleId());
//        secondSale.setZipcode("55555");
//        secondSale = saleDao.add(secondSale);
//        List<Sale> testSales = saleDao.getAll();
//
//        assertEquals(2, testSales.size());
//        assertTrue(testSales.contains(secondSale));
//        assertTrue(testSales.contains(secondSale));
//    }
//
//    @Test
//    public void testUpdateSale() {
//        assertTrue(purchaseDao.getAll().size() == 0);
//        assertTrue(vDao.getAll().size() == 0);
//        assertTrue(stateDao.getAll().size() == 0);
//        assertTrue(userDao.getAll().size() == 0);
//        assertTrue(saleDao.getAll().size() == 0);
//        PurchaseType purchaseType = new PurchaseType();
//        purchaseType.setName("Test Name");
//        purchaseDao.add(purchaseType);
//        Vehicle vehicle = new Vehicle();
//        State state = new State();
//        User user = new User();
//        Sale sale = new Sale();
//        assertTrue(makeDao.getAll().size() == 0);
//        assertTrue(modelDao.getAll().size() == 0);
//        Make make = new Make();
//        make.setName("Test Make");
//        make = makeDao.add(make);
//
//        Model model = new Model();
//        model.setName("Test Model");
//        model.setMakeId(make.getMakeId());
//        model = modelDao.add(model);
//        assertTrue(bodyDao.getAll().size() == 0);
//        assertTrue(colorDao.getAll().size() == 0);
//        BodyStyle style = new BodyStyle();
//        style.setName("test");
//        bodyDao.add(style);
//        Color color = new Color();
//        color.setName("blue");
//        colorDao.add(color);
//        state.setAbbr("Test State Abbreviation");
//        state.setName("Test State Name");
//        purchaseType.setName("Test Purchase Type");
//        user.setUsername("username");
//        user.setPassword("password");
//        user.setEnabled(true);
//        user.setFirstName("firstName");
//        user.setLastName("lastName");
//        user.setEmail("email");
//        vehicle.setBodyStyleId(style.getBodyStyleId());
//        vehicle.setDescription("Test Description");
//        vehicle.setExteriorColorId(color.getColorId());
//        vehicle.setInteriorColorId(color.getColorId());
//        vehicle.setIsAutomatic(true);
//        vehicle.setIsFeatured(false);
//        vehicle.setIsNew(false);
//        vehicle.setMileage(10000);
//        vehicle.setModelId(model.getModelId());
//        vehicle.setMsrp(BigDecimal.ZERO);
//        vehicle.setPrice(BigDecimal.ONE);
//        vehicle.setVin("1234");
//        vehicle.setYear(2005);
//
//        user = userDao.create(user);
//        state = stateDao.add(state);
//        vehicle = vDao.add(vehicle);
//        sale.setAddressOne("Test Address");
//        sale.setAddressTwo("Test Address Two");
//        sale.setCity("Test City");
//        sale.setEmail("test@test.com");
//        sale.setName("Test name");
//        sale.setPhone("555-555-5555");
//        sale.setPurchaseTypeId(purchaseType.getPurchaseTypeId());
//        sale.setStateId(state.getStateId());
//        sale.setTimeOfSale(Timestamp.valueOf(LocalDateTime.now()));
//        sale.setUserId(user.getId());
//        sale.setVehicleId(vehicle.getVehicleId());
//        sale.setZipcode("55555");
//        sale = saleDao.add(sale);
//
//        Sale fromDao = saleDao.findById(sale.getSaleId());
//
//        assertEquals(sale, fromDao);
//
//        sale.setName("Another Test Name");
//
//        saleDao.update(sale);
//
//        assertNotEquals(sale, fromDao);
//
//        fromDao = saleDao.findById(sale.getSaleId());
//
//        assertEquals(sale, fromDao);
//    }
//
//    @Test
//    public void testDeleteSale() {
//        assertTrue(purchaseDao.getAll().size() == 0);
//        assertTrue(vDao.getAll().size() == 0);
//        assertTrue(stateDao.getAll().size() == 0);
//        assertTrue(userDao.getAll().size() == 0);
//        assertTrue(saleDao.getAll().size() == 0);
//        PurchaseType purchaseType = new PurchaseType();
//        purchaseType.setName("Test Name");
//        purchaseDao.add(purchaseType);
//        Vehicle vehicle = new Vehicle();
//        State state = new State();
//        User user = new User();
//        Sale sale = new Sale();
//        assertTrue(makeDao.getAll().size() == 0);
//        assertTrue(modelDao.getAll().size() == 0);
//        Make make = new Make();
//        make.setName("Test Make");
//        make = makeDao.add(make);
//
//        Model model = new Model();
//        model.setName("Test Model");
//        model.setMakeId(make.getMakeId());
//        model = modelDao.add(model);
//        assertTrue(bodyDao.getAll().size() == 0);
//        assertTrue(colorDao.getAll().size() == 0);
//        BodyStyle style = new BodyStyle();
//        style.setName("test");
//        bodyDao.add(style);
//        Color color = new Color();
//        color.setName("blue");
//        colorDao.add(color);
//        state.setAbbr("Test State Abbreviation");
//        state.setName("Test State Name");
//        purchaseType.setName("Test Purchase Type");
//        user.setUsername("username");
//        user.setPassword("password");
//        user.setEnabled(true);
//        user.setFirstName("firstName");
//        user.setLastName("lastName");
//        user.setEmail("email");
//        vehicle.setBodyStyleId(style.getBodyStyleId());
//        vehicle.setDescription("Test Description");
//        vehicle.setExteriorColorId(color.getColorId());
//        vehicle.setInteriorColorId(color.getColorId());
//        vehicle.setIsAutomatic(true);
//        vehicle.setIsFeatured(false);
//        vehicle.setIsNew(false);
//        vehicle.setMileage(10000);
//        vehicle.setModelId(model.getModelId());
//        vehicle.setMsrp(BigDecimal.ZERO);
//        vehicle.setPrice(BigDecimal.ONE);
//        vehicle.setVin("1234");
//        vehicle.setYear(2005);
//
//        user = userDao.create(user);
//        state = stateDao.add(state);
//        vehicle = vDao.add(vehicle);
//        sale.setAddressOne("Test Address");
//        sale.setAddressTwo("Test Address Two");
//        sale.setCity("Test City");
//        sale.setEmail("test@test.com");
//        sale.setName("Test name");
//        sale.setPhone("555-555-5555");
//        sale.setPurchaseTypeId(purchaseType.getPurchaseTypeId());
//        sale.setStateId(state.getStateId());
//        sale.setTimeOfSale(Timestamp.valueOf(LocalDateTime.now()));
//        sale.setUserId(user.getId());
//        sale.setVehicleId(vehicle.getVehicleId());
//        sale.setZipcode("55555");
//        sale = saleDao.add(sale);
//        assertTrue(saleDao.getAll().size() == 1);
//        saleDao.deleteById(sale.getSaleId());
//        assertTrue(saleDao.getAll().size() == 0);
//    }
//
//}
