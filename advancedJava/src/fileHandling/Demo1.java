package fileHandling;

import java.io.*;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		File file = new File("D:/capgeminiTraining/javaFundamentals/advancedJava/src/test.java");
		System.out.println(file.getAbsolutePath());
		System.out.println("File object created");

		if (file.createNewFile()) {
			System.out.println("File Created");
		} else {
			System.out.println("File already exists");

		}
		FileWriter writer = new FileWriter("test.java");
		writer.write("Hello World");
		writer.close();
		System.out.println("Completed");
	}
}
