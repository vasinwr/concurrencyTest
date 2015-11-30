

/**
 * Complete the implementation of this class in line with the FSP model
 */

public class PlatformAccess {

  /* declarations required */
  boolean full = false;

  public synchronized void arrive() throws InterruptedException {
    // complete implementation
    while(full) wait();
    full = true;
  }

  public synchronized void depart() {
    // complete implementation
    full = false;
    notifyAll();
  }

}