public class Clock {
    private int h;
    private int min;
    private int totalTime;

// setters
    public int getH() {
        return h;
    }

    public int getMin() {
        return min;
    }
// constructors
    public Clock(String s) {
        String[] string = s.split(":");
        h = Integer.parseInt(string[0]);
        min = Integer.parseInt(string[1]);
        totalTime = h * 60 + min;
    }

    public String toString() {
        String hours = "" + this.h;
        String minutes = "" + this.min;
        return hours + ":" + minutes;
    }

    public Clock(int hour, int min) {
        this.min = min;
        this.h = hour;
        while (true) {
            if (this.h > 23) {
                this.h = this.h - 24;
            } else {
                break;
            }
        }
        /*this.h = (hour + min / 60) % 24
        * this.min = min % 60*/
    }

    public Clock add(int min) {
        Clock newClock = new Clock(this.h, this.min + min);

        while (newClock.min > 59) {
            newClock.h = newClock.h + 1;
            newClock.min = newClock.min - 60;
        }

        while (newClock.h > 23) {
            newClock.h = newClock.h - 24;
        }

        return newClock;
    }

    public Clock add(Clock clock) {
        Clock newClock = new Clock(0, 0);

        newClock.h = this.h + clock.h;
        if (newClock.h > 23) {
            newClock.h = newClock.h - 24;
        }
        newClock.min = this.min + clock.min;
        if (newClock.min > 59) {
            newClock.h = newClock.h + 1;
            newClock.min = newClock.min - 60;
        }
        return newClock;
    }
// create instance clock
    public static void main(String[] args) {
        new Clock(1 + ":" + 30);
        Clock time = new Clock(1, 30);
        time = time.add(30);
        System.out.println(time.toString());
        Clock time2 = new Clock(1, 30);
        time = time.add(time2);
        System.out.println(time);
        System.out.println(time2);
    }
}
