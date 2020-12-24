package tools;

/**
 * Класс, содержащий методы для конвертирования величин.
 * Решение создать отдельный класс показалось мне корректным с точки зрения архитектуры. Данные
 * методы не соотносятся напрямую с логикой специфических, специализированных классов программы.
 * Они - просто интструменты и должны быть отделены.
 */
public class Convertor {

    /**
     * Количество миллисекунд в секунде.
     */
    private static final int MILLISEC_IN_SEC = 1000;

    /**
     * Количество наносекунд в секунде.
     */
    private static final int NANOSEC_IN_SEC = 1000000000;

    /**
     * Метод для конвертирования из градусов в радианы.
     *
     * @param deg угол в градусах
     * @return угол в радианах
     */
    public static double fromDegToRad(int deg) {
        return deg * Math.PI / 180;
    }

    /**
     * Метод для конвертирования из миллисекунд в секунды.
     *
     * @param millisec миллисекнуды
     * @return секунды
     */
    public static double fromMilliSecToSec(long millisec) {
        return (double) millisec / MILLISEC_IN_SEC;
    }

    /**
     * Метод для конвертирования из наносекунд в секунды.
     *
     * @param nanoSec наносекнды
     * @return секунды
     */
    public static double fromNanoSecToSec(long nanoSec) {
        return (double) nanoSec / NANOSEC_IN_SEC;
    }
}
