package by.epamtc.mtv.viaryshko.thirdtask.task04;
import by.epamtc.mtv.viaryshko.thirdtask.task02.Task02;

//В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число.
// Если таких чисел несколько, то определить наименьшее из них.

public class Task04 {

    private int[] array;
    private int[] arrayForCounter;
    private int[] arrayForMaxValue;
    private int size;
    private int index;

    public Task04(int size) {

        this.size = size;
        if (isValidSize()) {
            array = new int[size];
            arrayForCounter = new int[size];
            arrayForMaxValue = new int[size];
            Task02.printArray(fillArray());
        } else {
            System.out.println("Введите корректный размер");
        }
    }

    //проверка размера массива
    private boolean isValidSize() {
        return size > 0;
    }

    //заполнение массива числами
    private int[] fillArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 5));
        }
        return array;
    }

    //заполняем массив значениями встречаемости чисел
    public int[] receiveArrayForCounter() {

        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] == array[j]) {
                    counter++;
                }
            }
            arrayForCounter[i] = counter;
            counter = 0;
        }

        return arrayForCounter;
    }

    //проверка есть ли повторяющиеся элементы
    private boolean isHaveRepeat() {

        int counterForSize = 0;
        for (int value : arrayForCounter) {

            if (value == 1) {
                counterForSize++;
            }
        }

        return counterForSize != arrayForCounter.length;
    }

    //находим максимальное число
    public int receiveMax() {

        int max = arrayForCounter[0];
        for (int i = 0; i < arrayForCounter.length; i++) {
            if (max < arrayForCounter[i]) {
                max = arrayForCounter[i];
                index = i;
            }

        }
        return max;
    }

    //количество максимально повторяющихся элементов
    public int receiveCounterForMax() {

        int counterForMax = 0;
        for (int value : arrayForCounter) {
            if (receiveMax() == value) {
                counterForMax++;
            }
        }
        return counterForMax;
    }

    //находим минимальное значение
    public int receiveMinValue(int[] arrayForMin) {

        int min = arrayForMin[0];
        for (int value : arrayForMin) {
            if (min > value) {
                min = value;
            }

        }
        return min;
    }


    public int receiveResult() {

        int min = 0;

        if (!isHaveRepeat()) {
            return receiveMinValue(array);
        }else if (receiveCounterForMax() == 1) {
            return array[index];
        } else {
            for (int i = 0; i < arrayForCounter.length; i++) {
                if (arrayForCounter[i] == receiveMax()) {
                    arrayForMaxValue[i] = array[i];
                }
            }

            min = arrayForMaxValue[0];
            for (int i = 0; i < arrayForMaxValue.length; i++) {

                if (min > arrayForMaxValue[i]){
                    min = arrayForMaxValue[i];
                }
            }
            return min;
        }
    }
}
