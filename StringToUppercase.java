package in.neosoft;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToUppercase {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("apple", "banana", "cherry");
		
		List<String> result =fruits.stream().map(fruit->fruit.toUpperCase()).collect(Collectors.toList());
		System.out.print(result);
		

	}

}
