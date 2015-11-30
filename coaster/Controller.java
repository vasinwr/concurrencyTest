

/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class Controller {

  public static int Max = 9;
  protected NumberCanvas passengers;

  // declarations required
  private int count = 0;
  private boolean goNow = false;

  public Controller(NumberCanvas nc) {
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
     while(count < mcar && !goNow) wait();
     if(goNow){
       goNow = false;
       if(count < mcar){
         int temp = count;
         count = 0;
         passengers.setValue(count);
         notifyAll();
         return temp;
       }
       else{
         count = count - mcar;
         passengers.setValue(count);
         notifyAll();
         return mcar;
       }
     }
     else{
       count = count - mcar;
       passengers.setValue(count);
       notifyAll();
       return mcar;
     }
  }

  public synchronized void goNow() {
     goNow = true;
     notifyAll();
  }

}