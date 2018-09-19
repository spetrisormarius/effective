package synchronized_properly2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

// Cooperative thread termination with a volatile field
public class StopThread {
    private static volatile boolean stopRequested;
    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested)
                i++;
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }

    // Broken - requires synchronization!
    private static volatile int nextSerialNumber = 0;
    public static int generateSerialNumber() {
        return nextSerialNumber++;
    }


    // Lock-free synchronization with java.util.concurrent.atomic
    private static final AtomicLong nextSerialNum = new AtomicLong();
    public static long generateSerialNumber2() {
        return nextSerialNum.getAndIncrement();
    }
}