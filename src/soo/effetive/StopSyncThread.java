package soo.effetive;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class StopSyncThread {

  private static boolean stopRequested;

  private static AtomicLong nextSerialNumber = new AtomicLong();

  private static long generateSerialNumber() {
    return nextSerialNumber.getAndIncrement();
  }

  private static synchronized void requestStop() {
    stopRequested = true;
  }

  private static synchronized boolean stopRequested() {
    return stopRequested;
  }

  public static void main(String[] args) throws InterruptedException {
    Thread backgroundThread = new Thread(new Runnable() {
      @Override
      public void run() {
        int i = 0;

        while (!stopRequested()) {
          i++;

          System.out.printf("MainThread %d", i);
        }
      }
    });

    backgroundThread.start();

    TimeUnit.SECONDS.sleep(1);
    requestStop();
  }
}
