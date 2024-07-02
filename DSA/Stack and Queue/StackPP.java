import java.util.* ;
public class StackPP{
//1. puch at bottom of stack.
// given an integer and you have to push that integer at the bottom.
    public static void pushAtBottom(int data, Stack<Integer> s){
        //iteration
     /* Stack<Integer> temp = new Stack<>();
        while(!s.isEmpty()){
            temp.push(s.pop());
        }
        s.push(data);
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }       */
        // recursion
         if(s.isEmpty()){
            s.push(data);
        }
        else{
            int top = s.pop();
            pushAtBottom(data, s);
            s.push(top);
        }
    }


    //2. Reverse a stack.
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return ;
        }
        int top  =s.pop();
        reverseStack(s);
        pushAtBottom(top, s);

        // to do this iteratively, take 3 stacks and perform similar as perv Q.
        }
    public static void main(String[] args) {
        Stack<Integer> s=  new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(4,s);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }

}