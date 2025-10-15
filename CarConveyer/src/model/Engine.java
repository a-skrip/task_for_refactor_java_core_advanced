package model;

import enums.EngineType;

public class Engine {
    private EngineType engineType;

    public Engine(EngineType engineType) {
        this.engineType = engineType;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return "type= " + engineType +'}';
    }
}
