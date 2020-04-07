import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return path;
        }
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String c : components) {
            if (!c.equals(".") && !c.isEmpty()) {
                if (c.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}