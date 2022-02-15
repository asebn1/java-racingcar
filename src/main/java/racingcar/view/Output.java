package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class Output {
    private static final String SPLIT_DELIM = ", ";
    private static final String OUTPUT_WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printRace(List<Car> cars) {
        for (Car car : cars) {
            String printValue = car.getName() + " : ";
            printValue += printPosition(car.getPosition());
            System.out.println(printValue);
        }
        System.out.println();
    }

    public static void printWinner(List<String> winnerNames) {
        System.out.println(String.join(SPLIT_DELIM, winnerNames) + OUTPUT_WINNER_MESSAGE);
    }

    private static String printPosition(int position) {
        String info = "";

        for (int i = 0; i < position; i++) {
            info += "-";
        }

        return info;
    }
}
