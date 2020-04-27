package org.softuni.initialproject.service.services.implementations;

import org.modelmapper.ModelMapper;
import org.softuni.initialproject.data.models.Car;
import org.softuni.initialproject.data.repositories.CarRepository;
import org.softuni.initialproject.service.models.CarServiceModel;
import org.softuni.initialproject.service.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final ModelMapper modelMapper;
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(ModelMapper modelMapper, CarRepository carRepository) {
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
    }

    @Override
    public CarServiceModel save(CarServiceModel model) {
        Car car = this.modelMapper.map(model, Car.class);
        this.carRepository.saveAndFlush(car);
        return model;
    }

    @Override
    public List<CarServiceModel> getCars() {
        return this.carRepository.findAll()
                .stream()
                .map(car -> this.modelMapper.map(car, CarServiceModel.class)).collect(Collectors.toList());
    }
}
