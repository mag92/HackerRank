import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        // Stack of opening brackets:
        Stack<Character> stack = new Stack<Character>();
        // Flag denoting whether or not the string is balanced:
        boolean balanced = true;
        
        // Iterate through each char 'ch' in the string and check if brackets are balanced:
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // If 'ch' is an opening bracket:
            if(     '(' == ch
               ||   '[' == ch
               ||   '{' == ch
              ) {
                stack.push(ch);
            }
            // Else, 'ch' is a closing bracket:
            else {
                // If there's no opening brace to balance, then the string cannot be balanced.
                if(stack.empty()){
                    balanced = false; 
                    break;
                }
                // Check if 'ch' closes the opening bracket at the top of the stack.
                else {
                    char top = stack.pop();
                    
                    // If the char popped off the 'top' of the stack doesn't match ch:
                    if(     (top == '(' && ch != ')') 
                       ||   (top == '[' && ch != ']') 
                       ||   (top == '{' && ch != '}') 
                      ) {
                        balanced = false;
                        break;
                    }
                }
            }
        }
        
        return (balanced && stack.empty()) ? "YES" : "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
