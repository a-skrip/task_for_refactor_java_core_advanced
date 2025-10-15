package model;

import enums.Brand;

import java.util.UUID;

public class Lada extends Car {

    public Lada(Brand brand, Engine engine, UUID serialnumber) {
        super(brand, engine, serialnumber);
    }
}
