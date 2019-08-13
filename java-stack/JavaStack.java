import java.util.*;
        class Solution{

            public static void main(String []argh)
            {
                Scanner sc = new Scanner(System.in);

                outerloop:
                while (sc.hasNext()) {
                    Stack<Character> stack;
                    stack = new Stack<>();
                    String input=sc.next();
                    char[] inputArr = input.toCharArray();



                    for (char c : inputArr) {
                        if (c == '(' || c == '{' || c == '[')
                            stack.push(c);
                        else if (c == ')' && !stack.isEmpty())
                        {
                            if (stack.peek() == '(')
                                stack.pop();
                        }    
                        else if (c == ']' && !stack.isEmpty()) {                           
                            if (stack.peek() == '[')
                                stack.pop();
                        }
                        else if (c == '}' && !stack.isEmpty()) {
                            if (stack.peek() == '{')
                                stack.pop();
                        }
                        else if ((c == ')' || c == '}' || c == ']') && stack.empty()) { System.out.println("false"); continue outerloop; }
                    }
                    System.out.println(stack.isEmpty());
                }


            }
        }



