import java.util.* ;
public class BST {
    static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data ;
        }
    }
    public static Node insert(Node root, int val){
        if(root==null){
            root =new Node(val);  // Nayi Node bana rhe yaha pr.
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left,val);
        } else{
            root.right=insert(root.right,val);
        }
        return root;
    }

    // check 
    public static void inOrder(Node root){
        if(root==null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    // search in BST
    public static boolean search(Node root, int key){
        if(root==null){     // means ke we have reached leaf node and key is not found.
            return false ;
        }
        if(key>root.data){
            return search(root.right, key);  // during this recursive call, key kahi na kahi root.data ke equal ho jayegi, toh vaha pr else case execute ho jayega.
        }
        if(key<root.data){
            return search(root.left, key);
        } else{
            return true ;
        }
    }

    /*check this :
     * public static boolean search(Node root, int key){
        if(root.val==key){     // means ke we have reached leaf node and key is not found.
            return true ;
        }
        if(key>root.data){
            return search(root.right, key);  // during this recursive call, key kahi na kahi root.data ke equal ho jayegi, toh vaha pr else case execute ho jayega.
        }
        if(key<root.data){
            return search(root.left, key);
        } else{
            return false ;
        }
    }
     */

    // deleting a node in BST
    public static Node delete(Node root, int val){
        if(root.data>val){
            root.left = delete(root.left,val);
        }
        if(root.data<val){
            root.left = delete(root.right,val);
        }
        // searching of that data is completed here
        else{
            // root.data ==val - hume root mil gyi hai yaha.
            if(root.left==null && root.right==null){
                return null ;
            }
            if(root.right == null){
                return root.left ;
            }
            if(root.left== null){
                return root.right ;    // generally hum root ko hi return karte hai, lekin yaha root ke left and right ko return krrhe hai, kyuki hume root ki jagah ye chaiye.
            }
            Node IS = inOrderSuccessor(root.right);   // yeh tab call ho rha jab, left and right kuch bhi khaali nhi hai.
            root.data = IS.data ;
            root.right = delete(root.right,IS.data);   // yaha pr hum duplicate node ko hata rhe.
        }                                              // yaha pr humne root ke right me left most node nikaala bcz uski hi value root ke immediate next hogi.
        return root ;

    }
    public static Node inOrderSuccessor(Node root){
        while(root.left!=null){
            root = root.left ;  
        }
        return root ;
    }
    public static void printInRange(Node root, int x, int y){  // x - min lim , y - max lim .
        if(root.data>=x && root.data<=y){
            printInRange(root.left, x, y);
            System.out.println(root.data + " ");
            printInRange(root.right, x, y);
        }
        else if(y<= root.data){
            printInRange(root.left, x, y);

        } else {
            printInRange(root.right, x, y);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i = 0 ; i < path.size() ; i++){
            System.out.print(path.get(i) + "-> ");
            System.out.println();
        }
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root == null){              
            return ;
        }
        path.add(root.data);

        if(root.left==null && root.right==null){             // leaf par poch ke ye condition aayegi.
            printPath(path);
        } else {                                     
            printRoot2Leaf(root.left, path);   
            printRoot2Leaf(root.right,path);
        }
        path.remove(path.size()-1);                   
    }
    public static void main(String[] args) {
        Node root = null;
        int values[]  = {2,3,4,5,6,1,32,0,7};

        for(int i=0;i<values.length;i++){
            root=  insert(root,values[i]);
        }
        inOrder(root);
        System.out.println();

        if(search(root,7)){
            System.out.println("Found");
        }
        delete(root, 0);
        inOrder(root);

        printInRange(root, 3, 12);

        printRoot2Leaf(root, new ArrayList<>(););
    }
}
