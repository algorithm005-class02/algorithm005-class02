class Solution {
	public String reverseStr(String s, int k) {
		char[] a = s.toCharArray();
		for (int i = 0; i < a.length; i += 2 * k) {
			int j = Math.min(i + k - 1, a.length - 1);
			reverse(a, i, j);
		}
		return String.valueOf(a);
	}

	private void reverse(char[] a, int i, int j) {
		while (i < j) {
			char temp = a[i];
			a[i++] = a[j];
			a[j--] = temp;
		}
	}
}