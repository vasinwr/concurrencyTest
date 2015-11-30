

/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class ControllerPartI {

  public static int Max = 9;
  protected NumberCanvas passengers;

  // declarations required
  private int count = 0;

  public ControllerPartI(NumberCanvas nc) {
    passengers = nc;
  }

  public synchronized void newPassenger() throws InterruptedException {
     // complete implementation
     // use "passengers.setValue(integer value)" to update diplay
    while(count >= Max) wait();
    count++ ;
    passengers.setValue(count);
    notifyAll();
  }

  public synchronized int getPassengers(int mcar) throws InterruptedException {
     // complete implementation for part I
     // update for part II
     // use "passengers.setValue(integer value)" to update diplay
     assert (mcar > 0) : "mcar can't less than or eq to 0";
     while(count < mcar) wait();
     count = count - mcar;
     passengers.setValue(count);
     notifyAll();
     return mcar;
  }

  public synchronized void goNow() {
    // complete implementation for part II
  }

}