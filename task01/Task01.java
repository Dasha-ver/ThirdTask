package by.epamtc.mtv.viaryshko.thirdtask.task01;
import java.util.Arrays;

//Даны действительные числа . Найти max

public class Task01 {

    private double[] array;
    private double[] arrayForAmount;
    private int size;

    public Task01(int size) {
        this.size = size;
        if (isEvenSize()) {
            array = new double[size];
            arrayForAmount = new double[size / 2];
            System.out.println(Arrays.toString(fillArray()));
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

    //заполнение массива суммами
    public double[] fillArrayForAmount() {
        for (int i = 0; i < array.length / 2; i++) {
            arrayForAmount[i] = array[i] + array[array.length - 1 - i];
        }
        return arrayForAmount;
    }

    //нахождение максимального значения
    public double getMaxValue() {
        double max = arrayForAmount[0];

        for (double value : arrayForAmount) {
            if (max < value)
                max = value;
        }
        return max;
    }
}
