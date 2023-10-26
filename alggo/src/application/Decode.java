package application;

import java.util.Arrays;
import java.util.HashMap;

public class Decode {
	public int index=0;
 public byte[] decode(byte [] data ,HashMap<String, Byte> huffmanTable) {
	 byte []result = new byte[999999999];
	 String d="";
	 String buff="";
	 System.out.print(Arrays.toString(data));
	 int i=0;
	 for(;i<data.length-2;++i) {
		 d= String.format("%8s", Integer.toBinaryString(data[i] & 0xFF)).replace(' ', '0');
		 for(int j=0;j<d.length();++j) {
			 buff=buff+d.charAt(j);
			 if(huffmanTable.containsKey(buff)==true) {
				 result[index]=huffmanTable.get(buff);
				 ++index;
				 buff="";
			 }
		 }
		 d="";
	 }
	String last= String.format("%8s", Integer.toBinaryString(data[i] & 0xFF)).replace(' ', '0');
	System.out.println("hfvhgnbgjb"+last);
	System.out.println(data[i]);
	String t="";
	for(int j=0;j<data[data.length-1];++j) {
		d=d+last.charAt(j);
	}
	System.out.println("hfvhgnbgjb"+d);
	 for(int j=0;j<d.length();++j) {
		 buff=buff+d.charAt(j);
		 if(huffmanTable.containsKey(buff)==true) {
			 result[index]=huffmanTable.get(buff);
			 ++index;
			 buff="";
		 }
	 }

	 for(int y=0;y<index;++y) {
		 String lastt= String.format("%8s", Integer.toBinaryString(result[y]& 0xFF)).replace(' ', '0');
		 System.out.println(lastt);
	 }

	 return result;
	 
 }
}
