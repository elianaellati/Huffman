package application;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class mainn {

	 public static void compress (byte [] data,Node tree,String PathCompressedFile,List <Node> p,String file) throws IOException {
		       Header m=new Header();
		       byte [] headerr=m.Headerr(tree);
		       System.out.print(Arrays.toString(data));
		       BufferedOutputStream bufferedOutputStream = new BufferedOutputStream (new FileOutputStream(PathCompressedFile)) ;
		       Encoding encoding = new Encoding() ;
		       byte result [] =  encoding.returnData(data,p);
		      
		       int counter = encoding.COUNTER;
		     //  bufferedOutputStream.write((encoding.lastDataByte+"\n").getBytes()); 
		       bufferedOutputStream.write((file+"\n").getBytes());
		       bufferedOutputStream.write(headerr,0,m.length);
		       bufferedOutputStream.write(m.lastbyte);
		       bufferedOutputStream.write("End".getBytes());
		       bufferedOutputStream.write(result ,0, counter);
		       bufferedOutputStream.write(encoding.lastDataByte);
		       bufferedOutputStream.write(encoding.indexx);
		       
		   //    bufferedOutputStream.write(encoding.lastDataByte.getBytes()); 
		       bufferedOutputStream.flush();
		       bufferedOutputStream.close();
		       
		    }
	 
	 public static void decompress(File file) throws IOException {
		 byte[] DATA = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
	        String str=new String(DATA);
	      
	String full = "" ;
	  int k = 0 ;
	    for (int i = 0 ; i < DATA.length ; i++) {
	    	if (DATA[i] != '\n') {
	    		full += (char)DATA[i] ;
	    		k++;
	    	}
	    	else {
	    		break ;
	    	}
	    }
	     
	        System.out.println("File Name : " + full);
	        System.out.println("Str : "+str);
	     
	String ss="";
	//int c =str.indexOf("End") ;

	String d= "" ;
	k=k+1;
	int c =getlast(DATA,k) ;
	for(;k<c-2; ++k) {
    ss = String.format("%8s", Integer.toBinaryString(DATA[k] & 0xFF)).replace(' ', '0');
	System.out.println(ss);
	d=d+ss;
	 }
	String h="" ;

	String lastt = String.format("%8s", Integer.toBinaryString(DATA[k] & 0xFF)).replace(' ', '0');
	for(int j=0;j<DATA[c-1];++j) {
		 h=h+lastt.charAt(j);
	}
	d=d+h;
	System.out.println("the headerrrrr ya alam "+d);
	Node fff= HuffmanCoding.rebuildTree(d);
	DirectoryChooser chooser = new DirectoryChooser() ;
	File file2 = chooser.showDialog(new Stage());
	String Result = file2.getAbsolutePath()+"\\"+full;
	    HashMap<String , Byte> huffmanCode = HuffmanCoding.Decodedata(fff) ;
	   Decode decoding = new Decode();
	     DATA = Arrays.copyOfRange(DATA, c+3, DATA.length);

	       byte[] result =  decoding.decode(DATA, huffmanCode);
	       BufferedOutputStream bufferedOutputStream = new BufferedOutputStream( new FileOutputStream (new File(Result)));

	    bufferedOutputStream.write(result , 0 , decoding.index);
	    bufferedOutputStream.flush();
	    bufferedOutputStream.close();
	    
	        System.out.println("DONE");
		 
	 }
	 
	 private static int getlast(byte[] data,int start) {
		 for(int i=0;i<data.length;i++) {
			 if(data[i]=='E' && data[i+1]=='n' && data[i+2]=='d' ) {
				 return i;
			 }
		 }
		 return 0;
	 }
	 
	 
	 
	 
	 
	 
	 
	
	
}
