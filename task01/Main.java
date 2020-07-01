package by.epamtc.mtv.viaryshko.thirdtask.task01;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Task01 task01 = new Task01(8);
        System.out.println(Arrays.toString(task01.fillArrayForAmount()));
        System.out.println(task01.getMaxValue());

    }
}
