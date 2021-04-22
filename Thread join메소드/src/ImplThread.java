public class ImplThread implements Runnable {
   int sum=0;
   public void run() {
      try {
         Thread.sleep(500);
      }catch(InterruptedException e) { 
         e.printStackTrace();
      }
      for(int x=1; x<500; x++) {
         sum = sum + x;   }   }   } 