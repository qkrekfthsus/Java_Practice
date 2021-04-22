public class PriorityThread  extends Thread {
   public PriorityThread(String name) {
       super(name);
   }
   public void run() {
       try {
          for(int i=0; i<5; i++) {
	sleep(500);
	System.out.println(i + ": " + getName() + " 우선순위 : " + getPriority());
          }
       }catch(InterruptedException e) {}
   }
    public static void main(String[] args) {
       PriorityThread p3 = new PriorityThread("쓰레드 Priority-MAX ");
       PriorityThread p2 = new PriorityThread("쓰레드 Priority-NORM");
       PriorityThread p1 = new PriorityThread("쓰레드 Priority-MIN ");
       p3.setPriority(Thread.MAX_PRIORITY);
       p2.setPriority(Thread.NORM_PRIORITY);
       p1.setPriority(3);
       p1.start();
       p2.start();
       p3.start();
   }
}  