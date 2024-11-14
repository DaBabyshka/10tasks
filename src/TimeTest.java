import java.time.LocalTime;

class HourFix {
    private int hour;

    public HourFix(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Час должен быть в диапазоне от 0 до 23");
        }
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }
}

class MinuteFix {
    private int minute;

    public MinuteFix(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Минута должна быть в диапазоне от 0 до 59");
        }
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }
}

class DayFix {
    private HourFix hour;
    private MinuteFix minute;

    public DayFix(HourFix hour, MinuteFix minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public void displayCurrentTime() {
        System.out.printf("Текущее время: %02d:%02d%n", hour.getHour(), minute.getMinute());
    }

    public String calculateTimeOfDay() {
        int h = hour.getHour();
        if (h >= 6 && h < 12) {
            return "Утро";
        } else if (h >= 12 && h < 18) {
            return "День";
        } else if (h >= 18 && h < 24) {
            return "Вечер";
        } else {
            return "Ночь";
        }
    }

    public void displayTimeOfDay() {
        System.out.println("Время суток: " + calculateTimeOfDay());
    }

    public static DayFix getCurrentTime() {
        LocalTime now = LocalTime.now();
        HourFix hour = new HourFix(now.getHour());
        MinuteFix minute = new MinuteFix(now.getMinute());
        return new DayFix(hour, minute);
    }
}

public class TimeTest {
    public static void main(String[] args) {
        DayFix day = DayFix.getCurrentTime();

        day.displayCurrentTime();
        day.displayTimeOfDay();
    }
}
