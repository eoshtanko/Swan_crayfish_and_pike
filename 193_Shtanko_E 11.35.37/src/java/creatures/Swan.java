package creatures;

import cart.Cart;

/**
 * Класс, соответвующий лебедю, что рвётся в облака.
 */
public class Swan extends Creature implements Runnable {

    /**
     * Угол, под которым лебедь передвигает телегу.
     * Угол в градусах!
     */
    private static final int ANGLE = 60;

    public Swan(Cart cart) {
        super(cart);
        printPersonalInfo();
    }

    /**
     * Метод, предоставляющий информацию об угле, под которым
     * лебедь перемещает объект.
     * Угол в градусах!
     *
     * @return угол, под которым лебедь перемещает объект
     */
    @Override
    int getAngle() {
        return ANGLE;
    }
}
