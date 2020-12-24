package cart;

/**
 * Класс, соответствующий тележке.
 */
public class Cart {

    /**
     * Координаты расположения телеги.
     */
    private final Coordinates coordinates;

    /**
     * Конструктор, на случай, если при запуске введены обе координаты.
     *
     * @param x координата x
     * @param y координата y
     */
    public Cart(double x, double y) {
        coordinates = new Coordinates(x, y);
    }

    /**
     * Конструктор, на случай, если при запуске введена одна координата.
     *
     * @param x координата x
     */
    public Cart(double x) {
        coordinates = new Coordinates(x, 0);
    }

    /**
     * Конструктор, на случай, если при запуске не введена ни одна координата.
     */
    public Cart() {
        coordinates = new Coordinates(0, 0);
    }

    /**
     * Метод для "передвижения" телеги.
     * Устанавливает телеге координаты "после смещения".
     *
     * @param shiftX смещение по x
     * @param shiftY смещение по y
     */
    public synchronized void move(double shiftX, double shiftY) {
        printInfo(shiftX, shiftY);
        coordinates.setX(coordinates.getX() + shiftX);
        coordinates.setY(coordinates.getY() + shiftY);
    }

    /**
     * Метод для получения информации о расположении телеги.
     *
     * @return координаты расположения телеги
     */
    public synchronized Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Метод, выводящий информацию о перемещении телеги.
     *
     * @param shiftX смещение по x
     * @param shiftY смещение по y
     */
    private void printInfo(double shiftX, double shiftY) {
        System.out.printf(Thread.currentThread().getName() + " сдвинул телегу " +
                "на %.2f по x и %.2f по y.\n", shiftX, shiftY);
    }
}

