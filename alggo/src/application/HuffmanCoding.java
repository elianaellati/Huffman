package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class HuffmanCoding {

	List<Node> codes=new ArrayList<Node>();
	 int k = 0;
	
	public  void CreateHuffmanCoding(Node root,String code) {
		if (root != null) {
			if (root.left == null && root.right == null) {                       
				root.result=code;
				codes.add(new Node(root.c, root.freq,root.result));
				return;			
				}
			CreateHuffmanCoding(root.left, code + "0");
			CreateHuffmanCoding(root.right, code + "1");
		}

	}
	

    public static HashMap<String , Byte> Decodedata(Node root) throws IOException {
        HashMap <String, Byte > map2 = new HashMap<>();
        buildTable (map2 , root , "");
      System.out.println("Map 2 "+map2);
        return map2 ;
    }
    private static void buildTable(HashMap<String, Byte> table, Node node, String s) {
        if (node.isLeaf()) {
            table.put(s , node.charr);
            return;
        }
        buildTable(table, node.left, s + '0');
        buildTable(table, node.right, s + '1');
    }
	



	public void printNode(Node root) {
		if (root != null){
			System.out.println("BEFORE : " +root.value);
			printNode(root.left);
			printNode(root.right);
		}
	}
	
	  public static  Node  rebuildTree(String header) {
	        Deque<Node> stack = new LinkedList<>();
              int y=0;
	        for (int i = 0 ; i < header.length() ; i++){
	        
	        			if(header.charAt(i)=='1') {
	        				 y=i+9;
	        		 
	        			if(y<header.length()) {
	        				String h =header.substring(i+1,y);
	        				int number = Integer.parseInt(h, 2);
	        				byte value =(byte) number;
	        				char ch=(char)number;
	        				
	        				 Node node = new Node(value, -1, null, null);
	        				stack.push(node);
	        				i=y-1;
	        			}
	        					
	        			}
	        			
	        			else if(header.charAt(i)=='0') {
	        				
	        				Node right = stack.pop();
	                        Node left = stack.pop();
	                        Node node = new Node((byte) 0,0, left, right);
	                        stack.push(node);
	        				
	        				
	        			}
	        				
	        			}
	        		 

	        		return (stack.pop());
	        		}
	        		public static void print(Node root)
	        		{

	        		    if (root == null) {
	        		     return ;
	        		    }
	        		    
	        		  print(root.left);
	        		  print(root.right);
	        		  
	        		//  System.out.print("/"+(char)root.charr;

	        		}
	

	
	public  Node HuffmanTreeCoding(int []freq , byte []value ) throws IOException {
		PriorityQueue<Node> queue = new PriorityQueue<>() ;
		int k = 0 ;
		for (int i = 0 ; i < freq.length ; i++) {
			if (freq[i]  > 0) {
				Node temp = new Node();
				temp.value = value[i] ;
				temp.c = (char)value[i];
				temp.freq = freq[i] ;
				temp.left = null ;
				temp.right = null ;
				queue.add(temp);
				k++ ;
			}
		}
		Node root = null ;
		for (int i = 0 ; i < k -1; i++) {
			Node z = new Node() ;
			Node x = queue.poll();
			Node y =queue.poll() ;
			z.freq = x.freq + y.freq ;
			z.left = x;
			z.right= y ;
			root = z ;
			queue.add(z);
		}
		root = queue.poll();
       return  root ;

	}

	
}
