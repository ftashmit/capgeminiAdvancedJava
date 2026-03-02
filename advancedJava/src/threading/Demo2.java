package threading;

class Multithreading extends Thread{
	
	int threadNumber;
	public Multithreading(int threadNumber) {
		this.threadNumber=threadNumber;
	}
	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
					System.out.println(Thread.currentThread().getName()+":"+i);
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
	}
}
public class Demo2 {
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			Multithreading th = new Multithreading(i);
			th.start();
		}

	}
}
