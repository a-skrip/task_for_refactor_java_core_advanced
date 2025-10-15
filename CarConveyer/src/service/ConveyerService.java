package service;

import common.TechTask;
import enums.Brand;
import enums.EngineType;
import exceptions.IncorrectBrandException;
import model.Car;
import model.Dodge;
import model.Engine;
import model.Lada;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConveyerService {

    public List<Car> generateCarsByTechTask() {
        List<Car> preparedCarList = new ArrayList<>();
        TechTask.mapBrandAmount.forEach((brand, amount) -> {
            for (int i = 0; i <= amount; i++) {
                preparedCarList.add(makeCar(brand));
            }
        });
        return preparedCarList;
    }

    public Car makeCar(Brand brand) {
        return switch (brand) {
            case LADA -> new Lada(Brand.LADA, setUpEngine(Brand.LADA), UUID.randomUUID());
            case DODGE -> new Dodge(Brand.DODGE, setUpEngine(Brand.DODGE), UUID.randomUUID());
            default -> throw new IncorrectBrandException();
        };
    }

    public Engine setUpEngine(Brand brand) {
        return Brand.LADA.equals(brand) ? new Engine(EngineType.ATMOSPHERE) : new Engine(EngineType.TURBO);
    }
}
