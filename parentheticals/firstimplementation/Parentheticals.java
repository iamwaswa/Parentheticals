package parentheticals.firstimplementation;

import java.util.Stack;

/**
 * The Parentheticals class deals with
 * finding the position of the matching
 * closing parentheses given the position
 * of the opening parentheses
 * @author Waswa Olunga
 */

public class Parentheticals {

	private static final int CLOSING_POS_NOT_FOUND = -1;

	public static void main(String args[]){

		Parentheticals p = new Parentheticals();

		String testOne = "Sometimes (when I nest them (my parentheticals) " +
						 "too much (like this (and this))) they get confusing.";

		int closingPos = p.findMatchingParentheses(testOne, 10);

		System.out.println("Closing parentheses at index: " + closingPos);

	}

	public int findMatchingParentheses(String sentence, int openingPos){

		Stack<Character> charStack = new Stack<>();

		for (int i = openingPos + 1; i < sentence.length(); i++){

			Character currentChar = sentence.charAt(i);

			if(currentChar == '('){
				charStack.push(currentChar);
			} else if (currentChar == ')'){

				int index = extractIndex(charStack, i);
				if (!(index == CLOSING_POS_NOT_FOUND)){
					return index;
				}

			}

		}

		return CLOSING_POS_NOT_FOUND;

	}

	private int extractIndex(Stack<Character> charStack, int index) {

		if(charStack.isEmpty()){
			return index;
		} else if(charStack.peek() == '('){
			charStack.pop();
		} else {
			printGrammarErrorMessage();
		}

		return CLOSING_POS_NOT_FOUND;

	}

	private void printGrammarErrorMessage() {

		System.out.println("There is a grammatical error:");
		System.out.println("The parentheses are not used correctly.");

	}

}
