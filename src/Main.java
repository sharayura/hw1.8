import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
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
        return (int) (1 + Math.ceil((double) (distance - 20) / 40));
    }

    public static void task4() {
        /**
         * Напишите метод, который в виде параметра принимает отсортированную строку.
         * Например, aabccddefgghiijjkk.
         * С помощью цикла проверьте, что в строке нет дублей, и выведите в консоль сообщение об этом.
         * Если дубль найден, нужно прервать поиск по остальным символам и вывести сообщение о присутствии дубля,
         * причем с указанием, какой именно символ задублирован. Затем сразу же прервать выполнение метода.
         * Сам метод ничего возвращать не должен (void).
         */
        String thisString = "aabccddefgghiijjkk";
        findDoubles(thisString);
    }

    public static void findDoubles(String testStr) {
        for (int i = 0; i < testStr.length() - 1; i++) {
            if (testStr.charAt(i) == testStr.charAt(i + 1)) {
                System.out.println("Найден дубль " + testStr.charAt(i));
                return;
            }
        }
        System.out.println("Дубли не найдены.");
    }

    public static void task5() {
        /**
         * В метод приходит массив, допустим:
         * {3, 2, 1, 6, 5}.
         * Нужно без вспомогательного массива переместить элементы так, чтобы поданный массив стал: {5, 6, 1, 2, 3}.
         * Рекомендуем написать этот метод без возвращаемого значения. Вы будете приятно удивлены, что даже если мы
         * не вернем массив, первоначальный массив изменится, когда мы будем модернизировать пришедший в виде параметра
         * массив внутри метода.
         */
        int[] arr = {3, 2, 1, 6, 5};
        System.out.println(Arrays.toString(arr));
        reverseArr(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArr(int[] arr1) {
        for (int i = 0; i < arr1.length / 2; i++) {
            int temp = 0;
            temp = arr1[i];
            arr1[i] = arr1[arr1.length - 1 - i];
            arr1[arr1.length - 1 - i] = temp;
        }
    }

    public static void task6() {
        /**
         *Снова вспоминаем домашнее задание по массивам. В нем была задача, которая требовала высчитать среднюю выплату
         * за день. Был дан сгенерированный массив из 30 значений от 100 до 200 тысяч, для его генерации допускается
         * использовать метод из прошлого домашнего задания.
         * Нам нужно понять, какую в среднем сумму наша компания тратила в течение данных 30 дней.
         * Нужно написать программу, которая посчитает среднее значение трат за месяц (то есть сумму всех трат за месяц
         * поделить на количество дней), и вывести в консоль результат в формате: «Средняя сумма трат за месяц составила … рублей».
         * Нужно сгенерировать массив, подать его в наш метод, а внутри метода подсчитать сумму элементов и вычислить
         * среднее значение, которое нужно вернуть из метода в виде результата.
         * Сложность в том, что метод нужно не просто написать, но еще и декомпозировать.
         * То есть для работы этого метода нужно будет создать еще методы (1 или более), которые его будут обслуживать
         * и вычислять промежуточные результаты. Среднее значение нужно вычислять в дробном виде, так как результат должен быть точным.
         */

        int arrLenght = 30;
        int[] thisArr = generateRandomArray(arrLenght);
        System.out.printf("Средняя сумма трат за месяц составила %.2f рублей", averageArr(sumArr(thisArr), thisArr));
    }

    public static int[] generateRandomArray(int l) {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[l];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    public static int sumArr(int[] arr) {
        int sum = 0;
        for (int current : arr) {
            sum += current;
        }
        return sum;
    }

    public static double averageArr(int sum, int[] arr) {
        double res = (double) sum / arr.length;
        return res;
    }
}