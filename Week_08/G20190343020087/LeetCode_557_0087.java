class Solution {
	public String reverseWords(String s) {

		StringBuilder sb = new StringBuilder();

		for (String word : s.split(" ")) {
			Stack<Character> stack = new Stack();

			for (Character c : word.toCharArray())
				stack.push(c);

			while (!stack.empty())
				sb.append(stack.pop());

			sb.append(' ');
		}

		return sb.toString().trim();
	}
}