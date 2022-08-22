public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        /**
         * Реализуйте метод, который получает в качестве параметра год, а затем проверяет, является ли он високосным,
         * и выводит результат в консоль. Эту проверку вы уже реализовывали в задании по условным операторам.
         * Теперь проверку нужно обернуть в метод и использовать год, который приходит в виде параметра.
         * Результат программы выведите в консоль. Если год високосный, то должно быть выведено “номер года — високосный год”.
         * Если год не високосный, то, соответственно: “номер года — не високосный год”.
         */
        int thisYear = 2019;
        isYearLeap(thisYear);
    }

    public static void isYearLeap(int year) {
        String flag = " не";
        if ((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0)) {
            flag = "";
        }
        System.out.printf("%d -%s високосный год.", year, flag);
        System.out.println();
    }

    public static void task2() {
        /**
         * Напишите метод, куда подаются два параметра: тип операционной системы (ОС) ( 0 — iOS или 1 — Android)
         * и год выпуска устройства. Если устройство старше текущего года, предложите ему установить lite-версию (облегченную версию).
         * В результате программа должна выводить в консоль в зависимости от исходных данных, какую версию приложения
         * (обычную или lite) и для какой ОС (Android или iOS) нужно установить пользователю.
         */
        int osType = 1;
        int thisYear = 2022;
        adviseOS(osType, thisYear);
    }

    public static void adviseOS(int os, int year) {
        String thisOS = "iOS";
        String thisType = "lite-";
        if (os != 0 && os != 1) {
            System.out.println("Неверный тип операционной системы.");
            return;
        }
        if (os == 1) {
            thisOS = "Android";
        }
        if (year == java.time.LocalDate.now().getYear()) {
            thisType = "";
        }
        System.out.printf("Установите %sверсию приложения для %s.", thisType, thisOS);
        System.out.println();
    }

    public static void task3() {
        /**
         * Возвращаемся к любимой многими задаче на расчет дней доставки банковской карты от банка.
         * Наша задача — доработать код, а именно написать метод, который на вход принимает дистанцию и возвращает
         * итоговое количество дней доставки.
         */
        int deliveryDistance = 95;
        int daysNum = getDaysNum(deliveryDistance);
        System.out.println(daysNum);
    }
    public static int getDaysNum(int distance) {
        return (int)(1 + Math.ceil((distance - 20)/40d));
    }
}