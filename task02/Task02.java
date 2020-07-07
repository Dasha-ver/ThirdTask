package by.epamtc.mtv.viaryshko.thirdtask.task02;

//Дана последовательность целых чисел . Образовать новую последовательность, выбросив из исходной те члены, которые равны  min.

public class Task02 {

    private int[] array;
    private int size;

    public Task02(int size) {
        this.size = size;

        if (isValidSize()) {
            array = new int[size];
            printArray(fillArray());
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

    //печать массива
    public static void printArray( int [] arrayForPrint){

        for (int value : arrayForPrint) {

            System.out.print(value + "\t");
        }
        System.out.println();
    }

    //нахождение минимального значения
    public int receiveMinValue() {

        int min = array[0];

        for (int value : array) {
            if (min > value)
                min = value;
        }

        return min;
    }

    //новая последовательность
    public void receiveSequenceWithoutMin() {

        for (int value : array) {

            if (value == receiveMinValue()) {
                continue;
            } else {
                System.out.print(value + " ");
            }
        }
    }
}
