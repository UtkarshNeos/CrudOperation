package in.neosoft;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterName {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("John", "Alice", "Jack", "Bob", "Julia");
		
		List<String> filteredName =names.stream().filter(name->name.startsWith("J")).collect(Collectors.toList());
		
		System.out.print(filteredName);

	}

}
