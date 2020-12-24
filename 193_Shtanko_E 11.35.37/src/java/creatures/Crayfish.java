package creatures;

import cart.Cart;

/**
 * Класс, соответвующий раку, что пятится назад.
 */
public class Crayfish extends Creature implements Runnable {

    /**
     * Угол, под которым краб передвигает телегу.
     * Угол в градусах!
     */
    private static final int ANGLE = 180;

    public Crayfish(Cart cart) {
        super(cart);
        printPersonalInfo();
    }

    /**
     * Метод, предоставляющий информацию об угле, под которым
     * рак перемещает объект.
     * Угол в градусах!
     *
     * @return угол, под которым рак перемещает объект
     */
    @Override
    int getAngle() {
        return ANGLE;
    }
}