package linkedlists;

import java.util.Stack;

//All testcases passed
//https://leetcode.com/problems/valid-parentheses/
public class ValidParanthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
                stack.add(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    return false;
                }else{
                    stack.pop();
                }
            }else if(s.charAt(i) == '}'){
                if(stack.isEmpty() || stack.peek() != '{'){
                    return false;
                }else{
                    stack.pop();
                }
            }else if(s.charAt(i) == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    return false;
                }else{
                    stack.pop();
                }
            }

        }

        return stack.isEmpty() ? true : false;
    }
}
