package threading.synchronization;

class Task
{
	public synchronized void countDown() throws InterruptedException
	{
		for (int i=0;i<=5;i++)
		{
			System.out.println("Count : "+i);
			Thread.sleep(1000);
		}
	}
}
public class Demo1 
{
	public static void main(String[] args) 
	{
		Task t1 = new Task();
		Thread th1 = new Thread(()->{
			try {
				t1.countDown();
			}
			catch(InterruptedException e)
			{
				throw new RuntimeException (e);
			}
		},"Th1");
		Task t2 = new Task();
		Thread th2 = new Thread(()->{
			try {
				th1.join();
				t2.countDown();
			}
			catch(InterruptedException e)
			{
				throw new RuntimeException (e);
			}
		},"Th2");
		th1.start();
		th2.start();
	}
	
}