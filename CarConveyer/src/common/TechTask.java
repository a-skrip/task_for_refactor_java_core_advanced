package common;

import enums.Brand;
import java.util.Map;

public class TechTask {
    public static final Long AMOUNT_OF_CARS = 200L;
    public static final Map<Brand, Integer> mapBrandAmount = Map.of(Brand.LADA, 10, Brand.DODGE, 190);
}
