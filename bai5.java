
public class bai5{

    public static void main(String[] args) {
       
    }
    boolean checkBST(Node root) {
    return isBST(root, -1, 10001); // Giới hạn đề bài: 0 <= data <= 10^4
}

boolean isBST(Node node, int min, int max) {
    if (node == null) {
        return true;
    }
    if (node.data <= min || node.data >= max) {
        return false;
    }
    return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
}
class Node{
    Node left;
    Node right;
    public int data ;
}
}