package stream;

import java.util.List;
import java.util.Optional;

public class Demo3 {
	  public static void main(String[] args) {

	        List<Student> students = List.of(
	                new Student("Ram",20),
	                new Student("Hari",17),
	                new Student("Sita",25)
	        );
	        
	        List<Student>names=students.stream()
	        					.peek(s->System.out.println(s.name))
	        					.toList();
	        System.out.println(names);
	        
	        List<Student> adults=students.stream()
							        		.filter(s->s.age>=18)
							        		.toList();
	        System.out.println("No. of adults= "+adults.size());
	        
	        List<Student> doubledAge = students.stream()
	                .filter(s -> s.age >= 18 && s.age <= 40)
	                .map(s -> new Student(s.name, s.age * 2))
	                .toList();
	        System.out.println("Doubled Age Students: " + doubledAge);

	        // 4️⃣ Find first minor (age < 18)
	        Optional<Student> firstMinor = students.stream()
	                                               .filter(s -> s.age < 18)
	                                               .findFirst();
	        firstMinor.ifPresent(s ->
	                System.out.println("First Minor: " + s));

	        // 5️⃣ Sum of ages of adults only
	        int sumOfAdultAges = students.stream()
	                .filter(s -> s.age >= 18)
	                .mapToInt(s -> s.age)
	                .sum();
	        System.out.println("Sum of Adult Ages: " + sumOfAdultAges);

	        // 6️⃣ Check if all students are adults
	        boolean allAdults = students.stream()
	                                    .allMatch(s -> s.age >= 18);
	        System.out.println("Are all students adults? " + allAdults);
	        
	        

	  	}
}
class Student{
    String name;
    int age;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }  
}