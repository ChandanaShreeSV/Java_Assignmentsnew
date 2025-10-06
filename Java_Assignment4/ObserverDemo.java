import java.util.*;

interface Observer {
    void update(int temp);
}
class PhoneDisplay implements Observer {
    public void update(int temp) {
        System.out.println("Phone shows: " + temp + "°c");
    }
}
class TVDisplay implements Observer {
    public void update(int temp) {
        System.out.println("TV shows: " + temp + "°c");
    }
}
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;
     public void addObserver(Observer o) {
        observers.add(o);
    }
     public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Temperature changed to " + temp);
        notifyObservers();
    }
    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }
}
public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.addObserver(new PhoneDisplay());
        station.addObserver(new TVDisplay());

        station.setTemperature(25);
        station.setTemperature(30);
    }
}
