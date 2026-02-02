package main.concept.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx0 {
	
	public static void main(String[] args) throws Exception{
		
		solution_1();
		
		
	}
	
	
	public static void solution_1() {
		
		System.out.println("Stream test");
		System.out.println("--------------------------");
		
		List<String> ids = Arrays.asList("첫번째(ok)", "두번째(ok)", "세번째(ok)", "네번째(no)");
		List<String> newIds = ids.stream()
						.peek(x -> System.out.println("first peek() : " + x))
						.peek(x -> System.out.println("second peek() : " + x))
						.peek(x -> System.out.println("third peek() : " + x))
						.filter(x -> x.contains("no"))
						.collect(Collectors.toList());
		System.out.println("newIds size : " + newIds.size());
	}
	
	public static void solution_2() {
		
		
		
	}
	

}

