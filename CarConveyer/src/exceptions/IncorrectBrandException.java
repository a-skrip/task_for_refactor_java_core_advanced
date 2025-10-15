package exceptions;

public class IncorrectBrandException extends RuntimeException{
    public IncorrectBrandException() {
        super("Конвейер не производит автомобили этого бренда");
    }
}
