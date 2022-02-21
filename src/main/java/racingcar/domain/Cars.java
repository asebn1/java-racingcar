package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String SPLIT_DELIM = ",";

    private List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public int getMaxPosition() {
        int maxNum = 0;

        for (Car car : cars) {
            maxNum = getMaxNum(maxNum, car);
        }

        return maxNum;
    }

    private int getMaxNum(int maxNum, Car car) {
        if (car.getPosition() > maxNum) {
            maxNum = car.getPosition();
        }
        return maxNum;
    }

    public List<String> getWinners() {
        return cars.stream()
                .filter(car -> car.checkIfPositionSame(getMaxPosition()))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public static List<Car> createCars(final String names) {
        List<Car> cars = new ArrayList<>();
        for (String carName : names.split(SPLIT_DELIM, -1)) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.goForward(RandomNum.getRandomNum());
        }
    }
}
