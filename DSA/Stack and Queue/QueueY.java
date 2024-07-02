/*public class QueueY{
    // queue using array.
    static class Queue{
        static int arr[];
        static int size;
        static int rear = -1;

        Queue(int n){
            arr = new int[n];
            this.size = n;
        }

        public static boolean isEmpty(){
            return rear == -1 ;
        }

        //enqueue  O(1)
        public static void add(int data){
            if(rear == size - 1){
                System.out.println("Queue is full");
                return;
            }

            rear++;
            arr[rear] = data ;
        }

        //dequeue  O(1)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front =arr[0];
            for(int i = 0; i < rear; i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return front ;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0] ;
        }



        public static void main(String[] args) {
            Queue q = new Queue(5);
            q.add(10);
            q.add(20);
            q.add(30);

            while(!q.isEmpty()){
                System.out.println(q.peek());
                q.remove();
            }
        }

    }
}

*/



        // circular queue using array.
        // rear = (rear+1)%size      ; rear = front queue is full
        // front = (front+1)%size    ; front = rear queue is empty
/*public class QueueY{
    static class Queue{
        static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;

        Queue(int n){
            arr = new int[n];
            this.size = n;
        }

        public static boolean isEmpty(){
            return rear == -1  && front == -1;
        }

        public static boolean isFull(){
            return (rear + 1) % size == front ;
        }

        //enqueue  O(1)
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return ;
            } 
            // add 1st element
            if(front==-1){
                front ++;
            }
            rear = (rear + 1)% size ;
            arr[rear]  = data ;
            if(rear == size - 1){
                System.out.println("Queue is full");
                return;
            }

            rear++;
            arr[rear] = data ;
        }

        //dequeue  O(1)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int result =arr[front];
            if(rear==front){
                rear = front =-1;
            }
            else{
                front = (front + 1)% size ;   //when front at last
            }
            return result ;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front] ;
        }


        public static void main(String[] args) {
            Queue q = new Queue(5);
            q.add(10);
            q.add(20);
            q.add(30);

            while(!q.isEmpty()){
                System.out.println(q.peek());
                q.remove();
            }
        }

    }
}  */



// queue implementation using linked list.
/*public class QueueY{
    static class Node{
        int data ;
        Node next ;
        Node(int data){
            this.data = data ;
            this.next = null ;
        }
    }
    static class Queue{
        static Node head = null; 
        static Node tail = null ;
        public static boolean isEmpty(){
            return head == null  & tail ==null ;
        }


        //enqueue  O(1)
        public static void add(int data){
            Node newNode = new Node(data);
            if(tail == null){
                head = tail = newNode ;
            }
            
            tail.next = newNode ;
            tail = newNode ;
        }

        //dequeue  O(1)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = head.data;
            if(head==tail){
                tail = null ;        //single element.
            }
            head = head.next;
            return front ;
        }
        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data ;
        }


        public static void main(String[] args) {
            Queue q = new Queue();
            q.add(10);
            q.add(20);
            q.add(30);

            while(!q.isEmpty()){
                System.out.println(q.peek());
                q.remove();
            }
        }

    }
} */


// collection framework

import java.util.* ;
public class QueueY{
    


        public static void main(String[] args) {
            //Queue<Integer> q = new LinkedList<>();  // because queue is an interface not class.
            Queue<Integer> q = new ArrayDeque<>();
            q.add(10);
            q.add(20);
            q.add(30);

            while(!q.isEmpty()){
                System.out.println(q.peek());
                q.remove();
            }
        }

    }
// difference in array deque and LinkedList class.