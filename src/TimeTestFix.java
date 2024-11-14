import java.time.LocalTime;

class Hour {
    private int hour;

    public Hour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Час должен быть в диапазоне от 0 до 23");
        }
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }
}

class Minute {
    private int minute;

    public Minute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Минута должна быть в диапазоне от 0 до 59");
        }
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }
}

class Day {
    private HourFix hour;
    private MinuteFix minute;

    public Day(HourFix hour, MinuteFix minute) {
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
        HourFix hour = null;
        MinuteFix minute = null;

        try {
            hour = new HourFix(now.getHour());
            minute = new MinuteFix(now.getMinute());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при получении текущего времени: " + e.getMessage());
            return null;
        }

        return new DayFix(hour, minute);
    }
}

public class TimeTestFix {
    public static void main(String[] args) {
        DayFix day = DayFix.getCurrentTime();

        if (day != null) {
            day.displayCurrentTime();
            day.displayTimeOfDay();
        } else {
            System.out.println("Не удалось получить текущее время.");
        }
    }
}
