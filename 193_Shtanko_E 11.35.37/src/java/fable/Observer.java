package fable;

import cart.Cart;
import cart.Coordinates;

import static tools.Convertor.fromNanoSecToSec;

/**
 * Класс для наблюдения за объектом.
 * Он реализует вывод координат объекта(точки) для обозрения пользователем
 * каждые INTERVALS секунд с точностью до двух знаков после запятой.
 */
public class Observer implements Runnable {

    /**
     * Значение, соответствующее временному интервалу между выводами информации
     * о текущем положении объекта.
     */
    private static final int INTERVALS = 2000;

    /**
     * Время начала наблюдения.
     */
    private final long timeOfStart;

    /**
     * Объект, за которым происходит наблюдение.
     */
    private final Cart target;

    public Observer(Cart cart) {
        target = cart;
        timeOfStart = System.nanoTime();
    }

    /**
     * Метод, в котором происходит вывод информации о текущем расположении объекта(точки)
     * каждые INTERVALS секунд с точностью до двух знаков после запятой.
     * Завершение метода происходит, когда поток, соответствуюзщий "наблюдателю", прерывается(interrupt).
     */
    @Override
    public void run() {
        Coordinates coordinates;
        while (!Thread.currentThread().isInterrupted()) {
            coordinates = target.getCoordinates();
            double time = fromNanoSecToSec(System.nanoTime() - timeOfStart);
            System.out.printf("Time: %.2f: x = %.2f y = %.2f \n", time, coordinates.getX(), coordinates.getY());
            try {
                Thread.sleep(INTERVALS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}