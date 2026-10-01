import java.util.*;

public class w3_tailop_25021743 {


    private static int precedence(String op) {
        switch (op) {
            case "+":
            case "-":
                return 2; 
            case "*":
            case "/":
                return 3; 
            case "^":
            case "**":
                return 4; 
            default:
                return -1;
        }
    }

    
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static List<String> infixToRPN(String[] tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            token = token.trim();
            if (token.isEmpty()) continue;

            
            if (isNumeric(token)) {
                output.add(token);
            } 
            
            else if (token.equals("(")) {
                stack.push(token);
            } 
            
            else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop(); // Bỏ dấu '(' ra khỏi stack
                }
            } 
        
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    output.add(stack.pop());
                }
                stack.push(token);
            }
        }

    
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return output;
    }


    public static double calculateRPN(List<String> rpnTokens) {
        Stack<Double> stack = new Stack<>();

        for (String token : rpnTokens) {
            
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } 
        
            else {
                double a = stack.pop(); 
                double b = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        if (a == 0) {
                            throw new ArithmeticException("Lỗi: Không thể chia cho 0!");
                        }
                        stack.push(b / a);
                        break;
                    case "^":
                    case "**":
                        stack.push(Math.pow(b, a));
                        break;
                }
            }
        }

        return stack.pop(); // Kết quả cuối cùng
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lưu ý: Nhập các phần tử cách nhau bởi khoảng trắng (Ví dụ: ( 3 + 4 ) * 2 )");
        System.out.print("Nhập biểu thức toán học: ");
        String input = scanner.nextLine();

        
        String[] tokens = input.trim().split("\\s+");

       
        List<String> rpn = infixToRPN(tokens);
        System.out.println("Biểu thức RPN (Hậu tố): " + String.join(" ", rpn));

      
        try {
            double result = calculateRPN(rpn);
            System.out.println("Kết quả: " + result);
        } catch (Exception e) {
            System.out.println("Lỗi tính toán: " + e.getMessage());
        }

        scanner.close();
    }
}