package net.pullolo.wyrwalovers.misc;

import org.bukkit.World;

public class TimeHandler {
    public static boolean isDay(World w){
        long time = w.getTime();
        return time < 12300 || time > 23850;
    }

    public static String getTime(World w){
        long hour = w.getTime()/1000;
        double minute = ((w.getTime() - hour*1000) * 0.06);

        if (hour > 17){
            hour = hour-18;
        } else {
            hour = hour + 6;
        }

        long m = Math.round(minute);
        if (m == 60){
            m = 0;
        }
        if (m < 10){
            return hour + ":0" + m;
        } else {
            return hour + ":" + m;
        }
    }
}
