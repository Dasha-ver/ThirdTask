package by.epamtc.mtv.viaryshko.thirdtask.task03;

import java.util.Arrays;

//. «Суперзамок». Секретный замок для сейфа состоит из 10 расположенных в рад ячеек,
// в которые надо вставить игральные кубики. Но дверь открывается только в том случае,
// когда в любых трех соседних ячейках сумма точек на передних гранях кубиков равна 10.
// (Игральный кубик имеет на каждой грани от 1 до 6 точек). Напишите программу,
// которая разгадывает код замка при условии, что два кубика уже вставлены в ячейки.

public class Task03 {

    private int[] array;
    private int firstKub;
    private int secondKub;
    private int indexForFirst;
    private int indexForSecond;

    public Task03(int firstKub, int indexForFirst, int secondKub, int indexForSecond) {

        this.firstKub = firstKub;
        this.secondKub = secondKub;
        this.indexForFirst = indexForFirst;
        this.indexForSecond = indexForSecond;
        array = new int[10];
        array[indexForFirst] = firstKub;
        array[indexForSecond] = secondKub;
        if (!isValidData()) {
            System.out.println("Введите допустимые значения!");
        } else if (isUnrealToGetCode()) {
            System.out.println("Ключ невозможно сгенерировать!");
        } else {
            System.out.println(Arrays.toString(array));
            getKey();
           if(!isValidKey() || isHaveNull()){
                System.out.println("Ключ невозможно сгенерировать!");
            }else{
            printArray();
            }
        }
    }

    //проверка введённых данных
    private boolean isValidData() {
        return (firstKub <= 6 && secondKub <= 6 && indexForFirst >= 0 && indexForFirst < 10 && indexForSecond >= 0 && indexForSecond < 10);
    }

    //реально ли составить код на начальном этапе
    private boolean isUnrealToGetCode() {

        if (indexForSecond <= indexForFirst) {
            return true;
        }

        if (indexForFirst - indexForSecond <= 2 && indexForFirst - indexForSecond >= -2
                || indexForSecond - indexForFirst <= 2 && indexForSecond - indexForFirst >= -2) {

            return array[indexForFirst] + array[indexForSecond] >= 10;
        }
        return false;
    }

    //получение ключа
    private int[] getKey() {

        int numberForCheck;
        if (indexForSecond - indexForFirst == 2) {

            array[indexForFirst + 1] = 10 - array[indexForFirst] - array[indexForSecond];
        }
        if (indexForSecond - indexForFirst == 1) {

            array[indexForFirst + 2] = 10 - array[indexForFirst] - array[indexForSecond];
        }
        if (indexForSecond - indexForFirst != 1 && indexForSecond - indexForFirst != 2) {
            if (firstKub == 5 && secondKub == 5) {
                numberForCheck = 10 - array[indexForFirst] - array[indexForSecond] + 1;
            } else {
                numberForCheck = 10 - array[indexForFirst] - array[indexForSecond];
            }
            if ((indexForSecond - indexForFirst) % 2 == 0) {
                for (int i = indexForFirst + 2; i < indexForSecond; i++) {
                    array[indexForFirst + 1] = 10 - array[indexForFirst] - numberForCheck;
                    array[i] = 10 - array[i - 1] - array[i - 2];
                }
            } else {
                for (int i = indexForFirst + 2; i < indexForSecond; i++) {
                    array[indexForFirst + 1] = numberForCheck;
                    array[i] = 10 - array[i - 1] - array[i - 2];
                }
            }

        }
        if (indexForFirst >= 2) {
            for (int i = indexForFirst - 1; i >= 0; i--) {
                array[indexForFirst - 1] = 10 - array[indexForFirst] - array[indexForFirst + 1];

                array[i] = 10 - array[i + 1] - array[i + 2];
            }
        }
        if (indexForFirst < 2) {
            for (int i = indexForFirst - 1; i >= 0; i--) {
                array[i] = 10 - array[indexForFirst] - array[indexForFirst + 1];
            }
        }
        if (indexForSecond < array.length - 1) {
            for (int i = indexForSecond + 1; i < array.length; i++) {
                array[i] = 10 - array[i - 1] - array[i - 2];
            }

        }
        return array;
    }

    //если в массиве есть нули, то ключ не сгенерирован
    private boolean isHaveNull() {

        int counter = 0;
        for (int value : array) {
            if (value == 0) {
                counter++;
            }
        }
        return counter > 0;
    }

    //проврка суммы трёх последних членов
    private boolean isValidKey() {
        return array[array.length - 1] + array[array.length - 2] + array[array.length - 3] == 10;
    }


    public void printArray() {
        for (int value : array) {
            System.out.print(value + "\t");
        }
    }

}
