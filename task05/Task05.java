package by.epamtc.mtv.viaryshko.thirdtask.task05;

import by.epamtc.mtv.viaryshko.thirdtask.task01.Task01;

//Дан одномерный массив A[N]. Найти:

public class Task05 {

    private double[] array;
    private int size;

    public Task05(int size) {

        this.size = size;

        if (isEvenSize()) {
            array = new double[size];
            Task01.printArray(fillArray());
        } else {
            System.out.println("Введите корректный размер");
        }
    }

    //проверка размера массива
    private boolean isEvenSize() {
        return size % 2 == 0 && size > 0;
    }

    //заполнение массива числами
    private double[] fillArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = ((Math.random() * 31) - 15);
        }
        return array;
    }

    //нахождения суммы
    public double receiveResult() {
        double max = array[1];
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                if (min > array[i]) {
                    min = array[i];
                }
            } else {
                if (max < array[i]) {
                    max = array[i];
                }
            }
        }
        return max + min;
    }
}

