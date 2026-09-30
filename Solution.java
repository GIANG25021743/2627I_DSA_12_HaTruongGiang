import java.util.Stack;
public class Solution {
    public static void main(String[] arg){
        Queue temp = new Queue();
        

    }
}

class Queue {
    private Stack<Integer> stack1, stack2;
    public Queue(){
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }
    public void enqueue(int x){
        while ( ! this.stack2.isEmpty()){
            this.stack1.push(this.stack2.pop());
        }
        this.stack1.push(x);

        while ( ! this.stack1.isEmpty()){
            this.stack2.push(this.stack1.pop());
        }
    }
    public Integer dequeue(){

        return !this.stack2.isEmpty() ? this.stack2.pop() : null;
    }
    public void print(){
        if (this.stack2.isEmpty()){
            System.out.print("no");
            }
        System.out.print(this.stack2.peek());
    }

}