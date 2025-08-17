class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int n = pattern.length();

        for (int i = 0; i <= n; i++) {  // <= n ensures last number is handled
            stack.push(i + 1);           // digits are 1..n+1

            // Pop stack if end of pattern or current char is 'I'
            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }
}
