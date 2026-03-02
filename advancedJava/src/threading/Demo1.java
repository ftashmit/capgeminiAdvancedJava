package threading;

//Life Cycle :- New -> Runnable -> Running -> (Blocked/Waiting/Timed Waiting) -> Runnable -> Terminated


public class Demo1 {
  static final Object lock = new Object();

  public static void main(String[] args) throws InterruptedException {
      Thread worker = new Thread(
              //Multiple Line Lambda Function
              ()->{
                  try{
                      System.out.println("Worker : Started");
                      Thread.sleep(2000);// It stops for 2000ms = 2s
                      synchronized (lock){
                          System.out.println("Worker : Going  to waiting state");
                          lock.wait();
                      }
                      System.out.println("Worker : Resumed and finishing");
                  }catch (InterruptedException e){
                      throw new RuntimeException(e);
                  }
              }
      );
      System.out.println("State after creation : "+worker.getState());
      worker.start();
      Thread.sleep(100);
      System.out.println("State after starting:  "+worker.getState());
      Thread.sleep(500);
      System.out.println("State during sleep: 	 "+worker.getState());
      Thread.sleep(2000);
      System.out.println("State during wait():   "+worker.getState());

      synchronized (lock){
          lock.notify();
      }
      worker.join();
      System.out.println("Stater after complete: "+worker.getState());
  }
}
