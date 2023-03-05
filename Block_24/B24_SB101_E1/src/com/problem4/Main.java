package com.problem4;

import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		List<Integer> ages = Arrays.asList(12, 36, 24, 15, 45, 25, 65, 42, 19, 35);
				
		boolean allCanVote = ages.stream().allMatch(a -> a >= 18);		
		System.out.println(allCanVote ? "You all can cast your vote." : "Some or none will cast vote.");
						
		ages.stream().distinct().forEach(a -> System.out.print(a + " "));
		System.out.println();
		
		ages.stream().sorted().skip(5).limit(3).forEach(a -> System.out.print(a + " "));
		System.out.println();
		
		Integer sum = ages.stream().reduce(0, (a,b) -> a+b);
		System.out.println("The sum of ages is " + sum);		
		
		// false, BinaryOperator interface is sub-interface of BiFunction interface.
		// false, BiConsumer interface is not a sub-interface of Consumer.
	}

}
