/* 
Factory method to create and run a new thread
*/

public class NewThread implements Runnable {
    Thread thread;
    
    NewThread(String name) {
        thread = new Thread(this, name);
    }
    
    // factory method
    public static NewThread create(String name) {
        NewThread tOb = new NewThread(name);
        
        tOb.thread.start();
        
        return tOb;
    }
    
    public void run() {
        try {
            for(int i = 0; i < 10; i++) {
                Thread.sleep(400);
                System.out.println(thread.getName() + " Counter: " + i);
            }
        }
        catch(InterruptedException exc) {
            System.out.println(thread.getName() + " Interrupted");
        }
        System.out.println(thread.getName() + " is over");
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Main thread is running");
 
        NewThread nt_1 = NewThread.create("Thread_1");
        NewThread nt_2 = NewThread.create("Thread_2");
        NewThread nt_3 = NewThread.create("Thread_3");

        for(int i = 0; i < 50; i++ ) {
            System.out.println(".");
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted");
            }
        }
        System.out.println("Main thread is over");
    }
}
