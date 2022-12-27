package CarRacing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Racing {
    public String[] nameSplit(String inputString) {
        return inputString.split(",");
    }

    public void nameException(String name) {
        if (name.length() > 5) {
            throw new RuntimeException("다섯 글자 이상입니다.");
        }
    }

    public void nameExceptions(String[] names) {
        for (int i = 0; i < names.length; i++) {
            nameException(names[i]);
        }
    }

    public Car[] makeCarList(String[] names) {
        Car[] cars = new Car[names.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new CarBuilder().name(names[i]).buildCar();
        }
        return cars;
    }

    public List<String> getWinner(Car[] cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        for (int i = 0; i < cars.length; i++) {
            maxPosition = cars[i].getMaxPosition(maxPosition);
        }
        for (int i = 0; i < cars.length; i++) {
            String winnerName = cars[i].getWinnerName(maxPosition);
            winners = addWinner(winners, winnerName);
        }
        return winners;
    }

    public List<String> addWinner(List<String> winners, String name) {
        if(name != null) {
            winners.add(name);
        }
        return winners;
    }

    public String[] handleNames(String inputNames) {
        String[] names = nameSplit(inputNames);
        nameExceptions(names);
        return names;
    }
}
