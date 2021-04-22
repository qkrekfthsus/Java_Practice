public class JoinThread {
   public static void main(String args[]) {
      try {
         ImplThread j= new ImplThread();
         Thread t = new Thread(j);	
         t.start();
         t.join();
         System.out.println("변수 sum 출력 : " + j.sum);
      }catch(Exception e) { 
         System.out.println( e.getMessage());  }   }    }
