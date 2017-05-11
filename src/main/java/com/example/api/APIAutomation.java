package com.example.api;

import java.util.ArrayList;
import java.util.List;

public class APIAutomation {

	public List<Integer> getNumbers(List<Integer> numbers) {

		if (numbers.size() < 2) {

			throw new IllegalArgumentException("Size of the list cannot be less than 2");
		}

		int highest = numbers.get(0);
		int second = numbers.get(1);

		List<Integer> returnList = new ArrayList<Integer>();

		for (Integer number : numbers) {

			if (number > highest) {
				second = highest;
				highest = number;

			} else if (number != highest && number > second) {
				second = number;
			}
		}

		returnList.add(highest);
		returnList.add(second);

		return returnList;

	}

}
