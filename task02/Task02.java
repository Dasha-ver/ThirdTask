package by.epamtc.mtv.viaryshko.thirdtask.task02;

import java.util.Arrays;

//Дана последовательность целых чисел . Образовать новую последовательность, выбросив из исходной те члены, которые равны  min.
public class Task02 {

    private int[] array;
    private int size;

    public Task02(int size) {

        this.size = size;
        if (isValidSize()) {
            array = new int[size];
            System.out.println(Arrays.toString(fillArray()));
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
            array[i] = ((int) (Math.random() * 31) - 15);
        }
        return array;
    }

    //нахождение минимального значения
    public int getMinValue() {

        int min = array[0];

        for (int value : array) {
            if (min > value)
                min = value;
        }

        return min;
    }

    //новая последовательность
    public void getSequenceWithoutMin() {

        for (int value : array) {

            if (value == getMinValue()) {
                continue;
            } else {
                System.out.print(value + " ");
            }
        }
    }
}
