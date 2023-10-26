package application;

public class Node implements Comparable<Node>{
    Node left , right ;
    int freq ;
    char c;
    byte value = -1 ;
    public byte charr;

  String result="";

    public Node (byte charr, int frequency, Node left, Node right) {
        this.charr = charr;
        this.freq = frequency;
        this.left = left;
        this.right = right;
        
    }
    public Node (char c, int frequency,String result) {
        this.c = c;
        this.freq = frequency;

        this.result=result;
        
    }

    public Node(){
    }
    public String getC() {
		return String.valueOf(c) ;
	}

    boolean isLeaf() {
        return left == null && right == null;
    }
   
    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.freq,o.freq);
    	 //return o.freq - o.freq;
    }
}

