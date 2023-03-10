
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    public static final Integer hd = null;
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
			String s = br.readLine();
			Node root = buildTree(s);
			Solution tree = new Solution();
			ArrayList<Integer> ans = tree.bottomView(root);

            for(Integer num:ans)
            System.out.print(num+" ");

            System.out.println();
		}
	}
}
  
class node{
    int data;
    node left, right;
    int hd;
  }

class Solution{

	static node create(int data){
        node tmp = new node();
        tmp.data = data;
        tmp.left = tmp.right = null;
        tmp.hd = 0;
        return tmp;
    }
  
    public ArrayList <Integer> bottomView(Node root)

    {
             ArrayList <Integer> res = new ArrayList <Integer>(0);
        if (root == null)
            return res; 
 
        //initializing a variable 'hd' with 0 for the root element.
        Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
        Queue<node> q = new LinkedList<node>();
        q.add(root);
        m.put(root.hd, root.data);
        while(!q.isEmpty()){
            node now = q.remove();
            m.put(now.hd, now.data);
            if(now.left != null){
              now.left.hd = now.hd - 1;
              q.add(now.left);
            }
            if(now.right != null){
              now.right.hd = now.hd + 1;
              q.add(now.right);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = m.entrySet();
 
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
 
        //traversing the map elements and storing nodes in the list.
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> me = iterator.next();
            res.add(me.getValue());
        }
        //returning the output list.
        return res;
    }

}