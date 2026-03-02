package stream;


import java.util.*;

public class Demo1 {

	public static void main(String[] args) 
		
	 {
		List<Integer> list=Arrays.asList(1,2,3,4,5,6);
//		List<Integer> even=new ArrayList<>();
//		for(Integer n: list) {
//			if(n%2==0) {
//				even.add(n);
//			}
//		}
		
		//Stream pipeline stages:
		
		//source->intermediate ops-> terminal ops
		
		//Collection > Stream > Filter > Transform > Collect > Result
		
		List<Integer> even=list.stream()//source
								.filter(n->n%2==0)//intermediate 
								.map(n->n*2)//intermediate
								.toList();//collect or terminate
		
		System.out.println(even);
		
	}
}
