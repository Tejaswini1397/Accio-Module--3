import java.util.*;

class Node {

  int data;
  Node left, right;
  Node(int item){
    data=item;
    left=right=null;
  }
}

class Solution{
    class BinaryTree{
        void printLeaves(Node node){
            if(node==null){
                return;
            }
            printLeaves(node.left);
            if(node.left==null && node.right==null){
                System.out.print(node.data+ " ");
                printLeaves(node.right);
            }
        }
    }
      void printBoundary(Node node){
        if(node==null){
           return;
        }
     System.out.print(node.data+ " ");
  }
}
public class Main {

  static Node getNode(int data) {
    // Allocate memory
    Node newNode = new Node();

    // put in the data
    newNode.data = data;
    newNode.left = newNode.right = null;
    return newNode;
  }

  static Node LevelOrder(Node root, int data) {
    if (root == null) {
      root = getNode(data);
      return root;
    }
    if (data <= root.data) root.left =
      LevelOrder(root.left, data); else root.right =
      LevelOrder(root.right, data);
    return root;
  }

  static Node constructBst(int arr[], int n) {
    if (n == 0) return null;
    Node root = null;

    for (int i = 0; i < n; i++) root = LevelOrder(root, arr[i]);

    return root;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
    sc.close();
    Node root = constructBst(tree, n);
    Solution.printBoundary(root);
  }
}
