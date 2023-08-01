package tdd.firstOOP.clock;

import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

public class TestBizClock extends BizClock {
    private LocalDateTime now;

    public TestBizClock() {
        setInstance(this);
    }

    @Override
    public LocalDateTime timeNow(){
        return now != null ? now : super.now();
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }
}
