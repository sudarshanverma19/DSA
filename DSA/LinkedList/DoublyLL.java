// Node class is defined separately in another file Node.
public class DoublyLL{
    private Node head; // head of list
    private Node tail; 

    public DoublyLL(){
        this.head = null ;
        this.tail = null ;
    }
    public void insertAtStart(int data){
        Node n = new Node(data);
        if(head == null){
            head = n ;
            tail = n ;
        } else {
            n.next = head ;
            head.prev = n ;
            head = n ;
        }
    }
    public void insertAtEnd(int data){
        Node n = new Node(data);
        if(tail == null){
            head = n ;
            tail = n ;
        } else {
            n.prev = tail ;
            tail.next = n ;
            tail = n ;
        }
    }
    public void insertAt(int data, int position){
        Node n = new Node(data);
        Node current = head ;
        for(int i=0;i<position-1;i++){
            current = current.next ;
        }
        if(current==null || current.next == null){
            insertAtEnd(data);
        }
        if(current.next!=null){
            current.next.prev = n ;
        }
        current.next = n;
        n.prev = current ;      
    }
    public void show(){
        Node current = head ;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next ;
        }
        System.out.println();
    }

    public void deleteAt(int position){
        if(position == 0){
            head = head.next ;
            head.prev = null ;
        }
        if(head == null){
            tail = null ;
        } else {
            head.prev = null ;
        }
        Node current = head ;
        for(int i=0;i<position-1;i++){
            current = current.next ;
        }
        if(position>0 && current.next.next != null){
            Node nodetodelete = current.next ;
            nodetodelete.next.prev = current ;
            current.next = nodetodelete.next ;
        } else {
            tail = current ;
        }
        
    }
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.insertAtStart(10);
        dll.insertAtStart(20);
        dll.insertAtEnd(30);
        dll.insertAt(40,2);
        dll.deleteAt(1);
        dll.show();
    }
}