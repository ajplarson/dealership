/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.dealership.controllers;

import ajplarson.dealership.models.CarModel;
import ajplarson.dealership.models.Make;
import ajplarson.dealership.models.SearchCriteria;
import ajplarson.dealership.models.ServiceCar;
import ajplarson.dealership.models.Vehicle;
import ajplarson.dealership.service.VehicleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AjaxController {
    
    private final VehicleService vehicleService;

    @Autowired
    public AjaxController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    
    @PostMapping("/inventory/new")
    public List<ServiceCar> searchNewCars(@RequestBody SearchCriteria search) {
        return vehicleService.searchForNewVehicles(search);
    }
    
    @PostMapping("/inventory/used")
    public List<ServiceCar> searchUsedCars(@RequestBody SearchCriteria search) {
        return vehicleService.searchForUsedVehicles(search);
    }
    
    @PutMapping("admin/addVehicle")
    public List<CarModel> getModelsForMake(@RequestBody Make make) {
        return vehicleService.getAllModelsByBrand(make.getName());
    }
    
    
}
