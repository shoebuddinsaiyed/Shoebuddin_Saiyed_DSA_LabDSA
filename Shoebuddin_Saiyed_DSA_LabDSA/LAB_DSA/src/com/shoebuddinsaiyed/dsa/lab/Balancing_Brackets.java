package com.shoebuddinsaiyed.dsa.lab;

import java.util.Stack;

public class Balancing_Brackets {
	public static void main(String[] args) {
		String bracketexpression = "({[]})";
		boolean result = Bracket_Balancing_Check(bracketexpression);
		if (result == true) {
			System.out.println("The entered String have Balanced bracket");
		}

		else {
			System.out.println("The entered String do not have Balanced bracket");
		}
	}

	private static boolean Bracket_Balancing_Check(String bracketexpression) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < bracketexpression.length(); i++) {
			char Character = bracketexpression.charAt(i);
			if (Character == '(' || Character == '{' || Character == '[') {
				stack.push(Character);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char char_pop;
			switch (Character) {
			case ')':
				char_pop = stack.pop();

				if (char_pop == '{' || char_pop == '[')
					return false;

				break;

			case '}':
				char_pop = stack.pop();

				if (char_pop == '(' || char_pop == '[')
					return false;

				break;

			case ']':
				char_pop = stack.pop();

				if (char_pop == '{' || char_pop == '(')
					return false;
				break;
			default:
				break;

			}

		}

		return stack.isEmpty();
	}
}
