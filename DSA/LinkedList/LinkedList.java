/* code for inserting and deleting element at head and last, inserting and deleting in between, showing all elements // do in doubly linked list also.  */
// Node class is defined separately in another file Node.
public class LinkedList{
    private Node head ;
    private Node tail ;
    public LinkedList(){                      // while using collections framework : LinkedLise ll = new LinkedList<>)();
        this.head = null ;
        this.tail = null ;
    }
    public void insertAtStart(int data){
        Node n1 = new Node(data);
        if(head != null){
            n1.next = head ;
            head = n1 ;
        }
        else{
            head = n1 ;
            tail = n1 ;                                                                                        
        }
    }
    public void insertAtEnd(int data){
        Node n1 = new Node(data);
        Node current = head ;
        while(current!=null){
            current = current.next ;
        }
        current = tail; 
        tail.next = n1 ;
    }
    public void insert(int data, int position){
        Node n1 = new Node(data);
        Node current = head ;
        for(int i=0; i<position-1 ;i++){
            current = current.next ;
        }
        n1.next = current.next ;
        current.next = n1 ;
        if(n1.next == null){
            tail = n1 ;
        }
    }
    public void show(){
        Node current = head ;
        while(current!=null){
            System.out.print(current.data + " ");
            current = current.next ;
        }
        System.out.println();
    }





    // for deletion
    public void deleteAtStart(){
        if(head==null){
            System.out.println("List is empty");
        } else{
            head = head.next ;
        }
    }
    public void deleteAtEnd(){
        Node current = head;
        while(current.next!=null&&current.next.next!= null){
            current = current.next ;
        }
        current.next = null ;
        tail = current ;

    }

    public void deletefrom(int position){
        Node current = head ;
        for(int i=0; i<position-1 ;i++){
            current = current.next ;
        }
        current.next = current.next.next ;

    }
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        // Node n1  = new Node(0);
        // Node n2  = new Node(1);
        // Node n3  = new Node(3);
        l.insertAtStart(1);
        l.insertAtStart(0);
        l.insertAtEnd(3);
        l.insert(2,1);
        l.insert(2,2);
        l.insert(2,2);
        l.deleteAtEnd();
        l.deleteAtStart();
        l.deletefrom(3);
        l.show();
    }
}

