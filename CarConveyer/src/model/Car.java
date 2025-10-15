package model;

import enums.Brand;
import java.util.UUID;

public abstract class Car {
    private Brand brand;
    private Engine engine;
    private UUID serialnumber;


    public Car(Brand brand, Engine engine, UUID serialnumber) {
        this.brand = brand;
        this.engine = engine;
        this.serialnumber = serialnumber;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public UUID getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(UUID serialnumber) {
        this.serialnumber = serialnumber;
    }

    @Override
    public String toString() {
        return "brand=" + brand + ", engineType" + engine + ", s/n = " + serialnumber + "\n";
    }
}
