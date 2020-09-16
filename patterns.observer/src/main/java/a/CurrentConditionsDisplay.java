package a;

public class CurrentConditionsDisplay implements DisplayElement, Observer{

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions:\ntemp = " + temperature + " degree\nhumidity = " + humidity);
    }

    @Override
    public void update(float temperature, float humidity, float pressure1) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

}
