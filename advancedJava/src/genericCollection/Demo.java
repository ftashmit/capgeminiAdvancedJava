package genericCollection;

public class Demo {

	public static void main(String[] args) {
		Box<String> box=new Box();
		box.set("10");
		System.out.println(box.value);
		String s=box.get();
		System.out.println(s);
	}
	
}
class Box<T>{//generic collection
	T value;
	void set(T value) {//custom setter
		this.value=value;
	}
	T get() {//custom getter
		return value;
	}
}
