package racingcar.service;

import java.util.Random;
import racingcar.domain.Car;
import racingcar.util.RandomUtil;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    public static void startRace(final List<Car> cars, final int tryNum) {
        Output.printResultWord();

        for (int i = 0; i < tryNum; i++) {
            moveCar(cars);
            printRace(cars);
        }
    }

    public static void printRace(final List<Car> cars) {
        for (Car car : cars) {
            Output.printName(car);
            Output.printPositionWord(car);
            System.out.println();
        }

        System.out.println();
    }

    public static void finalWinner(final List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winnerList = getWinnerList(cars, maxPosition);
        Output.printWinner(winnerList);
    }

    private static void moveCar(final List<Car> cars) {
        Random random = new Random();

        for (Car car : cars) {
            car.goForward(RandomUtil.getRandomNum());
        }
    }

    private static List<String> getWinnerList(final List<Car> cars, final int maxPosition) {
        List<String> winnerList = new ArrayList<>();

        for (Car car : cars) {
            if (car.checkIfPositionSame(maxPosition)) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }

    private static int findMaxPosition(final List<Car> cars) {
        int maxNum = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxNum) {
                maxNum = car.getPosition();
            }
        }

        return maxNum;
    }
}
