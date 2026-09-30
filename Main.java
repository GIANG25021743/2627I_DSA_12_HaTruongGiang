import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        
       
        check temp = new check(input);
        
        
        System.out.println(temp.examine());
    }
}

class check{
    public String test;
    Stack<Character> stack = new Stack();
    public check(String test){
        this.test = test;
    }
    public boolean examine(){
        for ( int i= 0; i< this.test.length() ; ++i){
                char x = this.test.charAt(i);
            if ( x == '{' || x == '[' || x == '(' ){
                this.stack.push(x);
            }
            else if (x == ')' || x == '}' || x == ']'){
                if (this.stack.isEmpty()) return false;

                if (x == ')' && this.stack.pop() != '('){
                    return false;
                }
                else if (x == ']' && this.stack.pop() != '['){
                    return false;
                }
                else if (x == '}' && this.stack.pop() != '{'){
                    return false;
                }
            }
        }
        return this.stack.isEmpty();

    }
}