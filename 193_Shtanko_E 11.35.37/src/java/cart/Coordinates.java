package cart;

/**
 * Класс, хранящий информацию о расположении объекта на двумерной плоскости,
 * его x, y координаты.
 */
public class Coordinates {

    private double x, y;

    Coordinates(double xVal, double yVal) {
        x = xVal;
        y = yVal;
    }

    /**
     * Метод, устанавливающий значение x координаты.
     */
    void setX(double newX) {
        x = newX;
    }

    /**
     * Метод, устанавливающий значение y координаты.
     */
    void setY(double newY) {
        y = newY;
    }

    /**
     * Метод, предоставляющий информацию о x координате.
     */
    public double getX() {
        return x;
    }

    /**
     * Метод, предоставляющий информацию о y координате.
     */
    public double getY() {
        return y;
    }
}
