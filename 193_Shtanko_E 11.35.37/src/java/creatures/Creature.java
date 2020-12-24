package creatures;

import cart.Cart;

import static tools.Convertor.fromDegToRad;
import static tools.Convertor.fromMilliSecToSec;
import static tools.Random.genDouble;
import static tools.Random.genInt;

/**
 * Абстрактный класс, описывающий существ, перемещающих некоторый объект.
 */
public abstract class Creature implements Runnable {

    /**
     * Минимальное время, на которое существо может заснуть, восстанавливая силы.
     */
    private static final int MIN_TIME_OF_SLEEP = 1000;
    /**
     * Максимальное время(невкл.), на которое существо может заснуть, восстанавливая силы.
     */
    private static final int MAX_TIME_OF_SLEEP = 5000;
    /**
     * Минимальное значение коэфф., участвующего при вычислении смещения объекта.
     */
    private static final int MIN_COEFF_VALUE = 1;
    /**
     * Максимальное значение коэфф.(невкл.), участвующего при вычислении смещения объекта.
     */
    private static final int MAX_COEFF_VALUE = 10;
    /**
     * Объект, которое смещает существо.
     */
    private final Cart target;
    /**
     * Величина, на котороую существо передвигает телегу по x.
     */
    private final double shiftX;
    /**
     * Величина, на котороую существо передвигает телегу по y.
     */
    private final double shiftY;
    /**
     * Коэффициент, участвующий при вычислении смещения объекта.
     */
    private final double coefficient;

    public Creature(Cart cart) {
        target = cart;
        coefficient = genDouble(MIN_COEFF_VALUE, MAX_COEFF_VALUE); // [1;10)
        // Я посчитала, что будет правильным, вычислить смещения сразу, ведь
        // их значения не меняются.
        shiftX = coefficient * Math.cos(fromDegToRad(getAngle()));
        shiftY = coefficient * Math.sin(fromDegToRad(getAngle()));
    }

    /**
     * Метод, в котором существо смещает(move) объект и уходит спать, восставливая силы.
     * Завершение метода происходит, когда поток, соответствуюзщий существу, прерывается(interrupt).
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            target.move(shiftX, shiftY);
            try {
                int timeOfSleep = genInt(MIN_TIME_OF_SLEEP, MAX_TIME_OF_SLEEP);
                printSleepInfo(timeOfSleep);
                Thread.sleep(timeOfSleep);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Метод, выводящий информацию о продолжительности сна существа.
     *
     * @param timeOfSleep продолжительность сна
     */
    private void printSleepInfo(int timeOfSleep) {
        System.out.printf(Thread.currentThread().getName() + " ушел спать " +
                "на %.2f секунды.\n", fromMilliSecToSec(timeOfSleep));
    }

    /**
     * Метод, выводящий информацию о существе.
     * В частности, его коэффициент, участвующий при вычислении смещения объекта,
     * и угол, под которым он смещает объект.
     */
    void printPersonalInfo() {
        System.out.printf(getClass().getSimpleName() + " имеет коэффициент приблизительно равный %.3f," +
                " его угол - %d.\n", coefficient, getAngle());
    }

    /**
     * Метод, предоставляющий информацию об угле, под которым
     * существо перемещает объект.
     * Угол в градусах!
     *
     * @return угол, под которым существо перемещает объект
     */
    abstract int getAngle();
}