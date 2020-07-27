import java.util.Scanner;

public class TestClock {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Clock clock = new Clock();
        System.out.println(clock.showTime());

        clock.changeMode();

        clock.setClock(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println(clock.showTime());

        System.out.println("Hour is: " + clock.getHour());
        System.out.println("Minute is: " + clock.getMinute());
        System.out.println("Second is: " + clock.getSecond());

        Clock clock2 = new Clock(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        clock2.changeMode();
        System.out.println(clock2.showTime());
        System.out.println(clock.isEqual(clock2));

        clock.nextHour();
        System.out.println(clock.showTime());

        clock.nextMinute();
        System.out.println(clock.showTime());

        clock.nextSecond();
        System.out.println(clock.showTime());

    }
}
