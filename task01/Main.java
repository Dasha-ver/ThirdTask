package by.epamtc.mtv.viaryshko.thirdtask.task01;

public class Main {

    public static void main(String[] args) {

        Task01 task01 = new Task01(8);
        Task01.printArray(task01.fillArrayForAmounts());
        System.out.println(task01.receiveMaxValue());

    }
}
