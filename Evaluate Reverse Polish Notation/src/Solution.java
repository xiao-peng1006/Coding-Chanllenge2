import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(token.length() - 1))) {
                nums.push(Integer.parseInt(token));
            } else {
                int b = nums.pop(), a = nums.pop();
                switch (token) {
                    case "+":
                        nums.push(a + b);
                        break;
                    case "-":
                        nums.push(a - b);
                        break;
                    case "*":
                        nums.push(a * b);
                        break;
                    default:
                        nums.push(a / b);
                        break;
                }
            }
        }

        return nums.pop();
    }
}