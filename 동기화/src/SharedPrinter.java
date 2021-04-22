class SynkThread { 
    private int PrtUsedNo = 0; 
    synchronized int usingPrinter() {
          return PrtUsedNo++; 
    }    } 
class PC extends Thread { 
        SynkThread printer; 
        PC(SynkThread printer, String name) { 
                super(name); 
                this.printer = printer; 
        } 
        public void run() {
                try { 
                   for(int i=0; i<3; i++) { 
                   System.out.println(getName() + "--프린터 " + printer.usingPrinter() + "번째 사용"); 
                   sleep(500); 
                   } 
                }catch(InterruptedException e) { } 
        }     } 
public class SharedPrinter { 
       public static void main(String[] args) { 
                SynkThread printer = new SynkThread(); 
                PC p1 = new PC(printer, "컴퓨터1");
                PC p2 = new PC(printer, "컴퓨터2"); 
                PC p3 = new PC(printer, "컴퓨터3"); 
                p1.setPriority(p1.MAX_PRIORITY);
                p2.setPriority(p2.NORM_PRIORITY); 
                p3.setPriority(p3.MIN_PRIORITY); 
                p1.start();
                p2.start();
                p3.start(); 
        }   }   