package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.Validation;
import racingcar.view.Input;
import racingcar.view.Output;

public class CarController {
    public CarController() {
    }

    public void play() {
        Cars cars = new Cars(makeCars());
        int tryNum = makeTryNum();

        startRace(cars, tryNum);
        Output.printWinner(cars.getWinners());
    }

    public static List<Car> makeCars() {
        String names = Input.inputCarNames();

        try {
            return Cars.createCars(names);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return makeCars();
        }
    }

    public static int makeTryNum() {
        String tryValue = Input.inputTry();

        try {
            Validation.checkTryNumValidation(tryValue);
            return Integer.parseInt(tryValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeTryNum();
        }
    }

    public static void startRace(final Cars cars, final int tryNum) {
        Output.printResultWord();

        for (int i = 0; i < tryNum; i++) {
            moveCar(cars);
            Output.printCarsRace(cars);
        }
    }

    public static void moveCar(final Cars cars) {
        cars.move();
    }
}
