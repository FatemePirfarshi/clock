import static java.lang.String.format;

public class Clock {

    private int hour;
    private int minute;
    private int second;
    private boolean mode = true;
    private String amORpm;


    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Clock() {
        this(0, 0, 0);
    }

    public void changeMode() {

        if (mode)
            mode = false;
        else
            mode = true;

        this.setHour(this.hour);
    }

    public String getHour() {
        return format("%02d", this.hour);
    }

    public void setHour(int hour) {
        if (mode)
            this.hour = hour;
        else {
            if (hour > 11) {
                int counter = 0;
                for (int i = 12; i < 24; i++) {
                    if (hour == i)
                        break;
                    else
                        counter++;
                }
                amORpm = "pm";
                this.hour = counter;
            } else {
                amORpm = "am";
                this.hour = hour;
            }
        }
    }

    public String getMinute() {
        return format("%02d", this.minute);
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute < 60)
            this.minute = minute;
    }

    public String getSecond() {
        return format("%02d", this.second);
    }

    public void setSecond(int second) {
        if (second >= 0 && second < 60)
            this.second = second;
    }

    public void setClock(int hour, int minute, int second) {
        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);
    }

    public String showTime() {

        if (mode) {
            String time = "\"" + getHour() + ":" + getMinute() + ":" + getSecond() + "\"";
            return time;

        } else {
            String time = "\"" + getHour() + ":" + getMinute() + ":" + getSecond() + "\"" + amORpm;
            return time;
        }

    }

    public Clock nextHour() {

        if (this.hour == 23 || (this.hour == 11 && !mode))
            setHour(0);
        else
            this.hour += 1;

        return this;
    }

    public Clock nextMinute() {

        if (this.minute == 59 && (this.hour == 23 || (this.hour == 11 && !mode))) {
            setMinute(0);
            setHour(0);
        } else if (this.minute == 59) {
            setMinute(0);
            nextHour();
        } else
            this.minute += 1;

        return this;
    }

    public Clock nextSecond() {

        if (this.second == 59 && this.minute == 59 && (this.hour == 23 || (this.hour == 11 && !mode))) {
            setClock(0, 0, 0);
        } else if (this.second == 59 && this.minute == 59) {
            setSecond(0);
            setMinute(0);
            nextHour();
        } else if (this.second == 59) {
            setSecond(0);
            nextMinute();
        } else
            this.second += 1;

        return this;
    }

    public boolean isEqual(Clock clk) {

        if (!this.mode && clk.mode) {
            clk.changeMode();
        } else if (this.mode && !clk.mode) {
            this.changeMode();
        }

        if (this.showTime().equals(clk.showTime()))
            return true;
        else
            return false;
    }

}