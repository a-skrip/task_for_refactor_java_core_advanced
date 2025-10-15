import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    /*
    Приложение - симулятор автомобильного конвейера.
    Задача - собрать определенное кол-во автомобилей по ТЗ,
    для автомобиля Лада - с атмосферным двигателем, для
    автомобиля Dodge - с турбированным. Каждому автомобилю
    должен быть присвоен уникальный серийный номер.
     */

    static int amountOfCars = 200;
    static int amountOfLada = 10;

    static int amountOfDodge = 190;

    public static void main(String[] args) {
        List<Object> cars = new ArrayList<>();
        for (int i = 0; i <= amountOfCars; i++) {
            if(i < amountOfLada){
                Conveyer conveyer = new Conveyer();
                Lada lada = new Lada();
                cars.add(conveyer.makeLada(lada, engineType.ATMOSPHERE, i));
            }
            if(i > amountOfLada){
                Conveyer conveyer = new Conveyer();
                Dodge dodge = new Dodge();
                cars.add(conveyer.makeDodge(dodge, engineType.TURBO, i));
            }
        }

        System.out.println("Автомобилей выпущено:");
        AtomicInteger amountOfLada = new AtomicInteger();
        cars.forEach(car -> {
            if(car instanceof Lada){
                amountOfLada.getAndIncrement();
            }
        });
        AtomicInteger amountOfDodge = new AtomicInteger();
        cars.forEach(car -> {
            if(car instanceof Dodge){
                amountOfDodge.getAndIncrement();
            }
        });
        System.out.println("Lada: " + amountOfLada.get());
        System.out.println("Dodge: " + amountOfDodge.get());
    }

    static class Dodge {
        private String serialnumber;

        private Engine engine;

        private void drive(){
            System.out.println("Car driving");
        }
    }

    static class Lada {
        private String serialnumber;

        private Engine engine;

        private void drive(){
            System.out.println("Car driving");
        }
    }

    static class Conveyer {
        Object makeLada(Lada lada, engineType engineType, int number){
            Lada car = new Lada();
            Engine engine = new Engine();
            engine.engineType = engineType;
            car.engine = engine;
            car.serialnumber = String.valueOf(number);
            return car;
        }

        Object makeDodge(Dodge dodge, engineType engineType, int number){
            Dodge car = new Dodge();
            Engine engine = new Engine();
            engine.engineType = engineType;
            car.engine = engine;
            car.serialnumber = String.valueOf(number);
            return car;
        }
    }

    static class Engine {
        engineType engineType;
    }

    enum engineType {
        ATMOSPHERE,
        TURBO
    }


}
