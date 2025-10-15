package model;

import enums.Brand;

import java.util.UUID;

public class Dodge extends Car {


    public Dodge(Brand brand, Engine engine, UUID serialnumber) {
        super(brand, engine, serialnumber);
    }
}
