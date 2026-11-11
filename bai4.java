import java.util.*;


public class bai4{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        
        Node root = new Node(arr[0]);
        for (int i = 1 ; i<n; i++){
            add(root,arr,arr[i]);
        }
        
        System.out.print((Check(root,v1,v2)));
        
    }
    static void add(Node root,int[] arr,int a){
        Node newnode = new Node(a);
        if (root == null){
            root = newnode;
            return;
        }
        else{
            Node cur = root;
            while(true){
                if (newnode.value > cur.value){
                    if (cur.right == null){
                        cur.right = newnode;
                        return;
                    }
                    else{
                        cur = cur.right;
                    }
                }
                else{
                    if (cur.left == null){
                        cur.left = newnode;
                        return;
                    }
                    else{
                        cur = cur.left;
                    }
                }
            }
        }
    }
   static int Check(Node root,int v1, int v2){
         Node cur = root;
         while (true){
            if (v1 > cur.value && v2 > cur.value){
                cur = cur.right;
            }
            else if(v1 < cur.value && v2 < cur.value){
                cur = cur.left;
            }
            else{
                return cur.value;
            }
            
         }
   }
    
   static class Node{
    Node left;
    Node right;
    public int value ;
    
    public Node( int value){
        this.value = value;
    }
    
    
  }
}