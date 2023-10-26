package application;

import java.io.IOException;

public class Header {
	int lastbyte;
	int length;
	
	public Header() {
		super();
	}

	public byte [] Headerr(Node root) throws IOException {
		StringBuilder d=new StringBuilder();//take the post order 
		postOrder(root,d);
	    int count =0;
		byte [] output=new byte[69999];
	     String r="";
		String f="";
	
  

		for(int i=0;i<d.length();++i) {
			char ch=d.charAt(i);
			
			if(ch!='0' && ch!='1') {
				 int p=(int)ch;
				 
				String binaryStringg= String.format("%8s", Integer.toBinaryString(p& 0xFF)).replace(' ', '0');
				 f=f+binaryStringg;
				
			}else if(ch=='1' || ch=='0' ){
				if(i+1<d.length()  ) {
					int  t=d.charAt(i+1);
				if( ch=='1' && (Character.isDigit(t))) {
					String binaryStringg= String.format("%8s", Integer.toBinaryString(t& 0xFF)).replace(' ', '0');
					f=f+ch+binaryStringg;
					
				i=i+1;
				}
				else {
					f=f+ch;
					
				}
			
				
				}
				else {
					f=f+ch;
					
				}
			}
		}

	
		
	System.out.println("the header"+f);

		for(int i=0;i<f.length();++i) {
		
			char ch=f.charAt(i);
			
			if(ch=='1') {
			
			output[count / 8] =   ((byte) (output[count / 8] | 1 << 7 - count % 8));   
		
				++count;
			}
	       if(ch=='0') {
				++count;
			}

		
			
		}
		 lastbyte=count%8;
		 length= (count / 8)+1;
		
		// System.out.print("the postorder");
		// print(root);
		  return output;
		  
}
	private static void postOrder(Node node,StringBuilder ss) {
        if (node.left == null && node.right == null) {
        	ss.append("1");
			ss.append((char)node.value);
          
        } else {
            postOrder(node.left, ss);
            postOrder(node.right, ss);
        	ss.append("0");
        }
        
    }
   
   public void print(Node root)
   {

       if (root == null) {
        return ;
       }
       
     print(root.left);
     print(root.right);
     System.out.print("/"+root.c);

   }	
	
	
	
	
	
	
}
