import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input (any number less then zero will brake input): ");

        ArrayList<Integer> points = new ArrayList<>();

        int point = 0;
        while (point >= 0) {
            point = scanner.nextInt();
            if (point >= 0) {
                points.add(point);
            }
        }

        scanner.close();

        System.out.print("Scoreboard: ");

        ArrayList<Integer> scoreboard = calculateScore(points);

        for (int i = 0; i < scoreboard.size(); i++) {
            System.out.print(scoreboard.get(i) + " ");
        }
    }

    private static ArrayList<Integer> calculateScore(ArrayList<Integer> points) {

        ArrayList<Integer> scoreboard = new ArrayList<>();

        int result = 0;

        int frameNo = 0;
        int frameScore = 0;

        int roll1 = 0;
        int roll2 = 0;

        for (int i = 0; i < points.size(); i+=2) {

            frameNo++;
            if (frameNo == 11) {
                break;
            }

            roll1 = points.get(i);
            roll2 = points.get(i + 1);

            frameScore = roll1 + roll2;

            if (roll1 + roll2 == 10 && roll2 != 0) {
                frameScore += points.get(i + 2); //spare
            }

            // strike
            if (roll1 + roll2 == 10 && roll2 == 0) {

                if (points.get(i + 2) + points.get(i + 3) == 10 && points.get(i + 3) == 0) {
                    frameScore += (points.get(i + 2) + points.get(i + 4));
                } else {
                    frameScore += (points.get(i + 2) + points.get(i + 3));
                }

            }

            result = result + frameScore;

            scoreboard.add(result);

            roll1 = 0;
            roll2 = 0;
        }

        return scoreboard;
    }
}
