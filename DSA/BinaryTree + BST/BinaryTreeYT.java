/*Trees : heirerchical structure
 * code wala tree me root upar hoti hai and leaves neecge. sabse upar root node.
 * Binary tree: at max - 2 branches.(left and right child)
 * leaf node ke child nhi hote.
 * different levels are there in trees. also depth, level and depth can ve asked.
 * 
 */

import java.util.*;

public class BinaryTreeYT{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null ;
            this.right = null ;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1 || idx >= nodes.length){
                return null;
            }
            Node newNode = new Node(nodes[idx]);  // newNode hi root node hai, and hum iske left and right me build tree recursively call krrhe.
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode ;
        }
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data+" ");

    }

    public static void inOrder(Node root){
        if(root==null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void levelOrder(Node root){
        if(root==null){
            return ;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            Node curr = q.remove();   // yaha pr 1 remove hoga kyuki yeh Queue hai. so, curr=1
            if(curr == null){      // dhyan rahe ye curr hum koi new Node nhi bana rhe hai, ye existing tree ki node hai jisko humne queue me add kiya tha. curr is working as a pointer.
                System.out.println();              /*Node curr = q.remove(); does not create a new node with null children. Instead, it retrieves and references an existing node
                                                     from the queue. This existing node has its left and right children already set (if they exist), 
                                                     so when we access curr.left and curr.right, we are accessing the actual children of the node that was constructed earlier. */
                if(q.isEmpty()){
                    break ;
                }
            
                else{
                    q.add(null);
                }
            }
            System.out.println(root.data);    // print 1
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
    }

    public static int countOfNodes(Node root){    // remember: backtracking occurs automatically in recursive call, inherently it uses stack based backtracking approach.
        if(root==null){
            return 0 ;
        } else{
            int c1 =countOfNodes(root.right);
            int c2 = countOfNodes(root.left);
            return c1+c2+1;
        }
    }
    public static int sumOfNodes(Node root){
        if(root==null){
            return 0 ;
        } else { 
            int s1 = sumOfNodes(root.right);
            int s2 = sumOfNodes(root.left);
            return s1+s2+root.data;
        }

    }

    public static int diameter(Node root){      // time complexity:O(N^2)
        if(root==null){
            return 0 ;
        } else {
            int d1 = diameter(root.left);
            int d2 = diameter(root.right);
            int d3 = height(root.left)+height(root.right)+1 ;

            return Math.max(d3,Math.max(d1,d2));
        }
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int l=height(root.left);
        int r=height(root.right);
        return Math.max(l,r)+1; 
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,1,5,-1};
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);
        if(root!=null){
            System.out.println(root.data);
        }
    }
}