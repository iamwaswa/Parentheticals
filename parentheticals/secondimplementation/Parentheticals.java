package parentheticals.secondimplementation;

/**
 * The Parentheticals class deals with
 * finding the position of the matching
 * closing parentheses given the position
 * of the opening parentheses
 *
 * Time complexity: O(N)
 * Space complexity: O(1)
 *
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

		int openingCount = 0;

		for (int i = openingPos + 1; i < sentence.length(); i++){

			Character currentChar = sentence.charAt(i);

			if(currentChar == '('){

				openingCount++;

			} else if (currentChar == ')'){

				int index = extractIndex(openingCount, i);
				if (!(index == CLOSING_POS_NOT_FOUND)){
					return index;
				}

				openingCount--;

			}

		}

		return CLOSING_POS_NOT_FOUND;

	}

	private int extractIndex(int openingCount, int index) {

		if(openingCount == 0){
			return index;
		} else {
			return CLOSING_POS_NOT_FOUND;
		}

	}

}

