package org.softuni.initialproject.service.services;

import org.softuni.initialproject.data.models.Car;
import org.softuni.initialproject.service.models.CarServiceModel;

import java.util.List;

public interface CarService {
    CarServiceModel save(CarServiceModel model);

    List<CarServiceModel> getCars();
}
