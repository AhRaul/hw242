import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ST500InfoAdapter implements MeteoSensor {
    ST500Info sensor;

    public ST500InfoAdapter(ST500Info sensor) {
        this.sensor = sensor;
    }

    @Override
    public int getId() {
        return this.sensor.getData().identifier();
    }

    @Override
    public Float getTemperature() {
        return (float)this.sensor.getData().temperature();
    }

    @Override
    public Float getHumidity() {
        return null;
    }

    @Override
    public Float getPressure() {
        return null;
    }

    @Override
    public LocalDateTime getDateTime() {
        int year = this.sensor.getData().year();
        int dayOfYear = this.sensor.getData().day();            //0 - 365 day of year or 366 in a leap year
        int secondOfDay = this.sensor.getData().second();       //0 - 86400 sec of day

        LocalDate localDate = LocalDate.ofYearDay(year, dayOfYear);
        LocalTime localTime = LocalTime.ofSecondOfDay((long)secondOfDay);

        LocalDateTime now = LocalDateTime.of(localDate, localTime);
        return now;
    }
}
