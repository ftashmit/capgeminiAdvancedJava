package functionalInterface;

public class Main2 {

	public static void main(String[] args) {
		//if the method is not an argument method and not a return type method in the Functional Interface
		Demo2 demo=(a)->{
			//didnt have to create an additional implementation class to implement the sample method
			System.out.println("Method impled by Lambda expression");
		};
		demo.sample(5000);
		
	}
}
