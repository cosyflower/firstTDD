package tdd.firstOOP.clock;

import java.time.LocalDateTime;

public class BizClock {
    private static BizClock DEFAULT = new BizClock();
    private static BizClock instance = DEFAULT;

    public static void reset(){
        instance = DEFAULT;
    }

    public static LocalDateTime now(){
        return instance.timeNow();
    }

    public LocalDateTime timeNow(){
        return LocalDateTime.now();
    }

    protected void setInstance(BizClock bizClock) {
        BizClock.instance = bizClock;
    }
}
