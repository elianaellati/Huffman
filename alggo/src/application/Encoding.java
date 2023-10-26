package application;

import java.io.FileNotFoundException;
import java.util.List;

public class Encoding {
	 public byte  lastDataByte  ;
	 int indexx = 0 ;
    public byte[] returnData (byte data[] , List <Node> p) throws FileNotFoundException {
     
      COUNTER = 0 ;
      nextByte = 0;
      byte result[] = new byte[999999999];
      
      for (int i = 0 ; i < data.length ; i++) {
      	String code=search((char)data[i],p) ;
    
      	  if (code != null) {
                for (int m = 0 ; m < code.length() ;m++) {
                        if (code.charAt(m) == '1') {
                      	  result[nextByte] = (byte) (result[nextByte] | 1 << 7 - index % 8);
                      	  index++;
                        } else {
                      	  index++;
                        }
                       
                    if (index == 8) {
                        index = 0;
                        nextByte++ ;
                        COUNTER++;
                    }
                }
            }

        }
        
       /* for(int i=0;i<COUNTER;++i) {
      	  String binaryStringg= String.format("%8s", Integer.toBinaryString(result[i]& 0xFF)).replace(' ', '0');
      	  System.out.println("hi" +"           "+binaryStringg+""+result[i]);
        }*/
       
       String lastbyte=String.format("%8s", Integer.toBinaryString(result[nextByte]& 0xFF)).replace(' ', '0');
       String last="";
        for (int i = 0 ; i <index ; i++) {
      	last=last+lastbyte.charAt(i);
        }
        
        System.out.print("hello"+last);
       lastDataByte=result[nextByte]  ;
       indexx=index;
        return  result ;  
  }
  
 

   private  int index =0 , nextByte = 0;
   public   int COUNTER = 0 ;

   String d="";
public String search(char h,List<Node>p) {

	for(int j=0;j<p.size();++j) {
	
		if(p.get(j).c==h) {
			d=p.get(j).result;
			break;
		}else {
			d=null;
		}
	}
	return d;
}


}








/*public byte[] returnData (byte data[] , List <Node> p) throws FileNotFoundException {
   index = 0 ;
   COUNTER = 0 ;
   nextByte = 0;
   byte result[] = new byte[999999999];
   for (int i = 0 ; i < data.length ; i++) {
   	String code=search((char)data[i],p) ;
   	System.out.print(code);
   	  if (code != null) {
             for (int m = 0 ; m < code.length() ;m++) {
                     if (code.charAt(m) == '1') {
                   	  result[nextByte] = (byte) (result[nextByte] | 1 << 7 - index % 8);
                   	  index++;
                       //  result[nextByte] = (byte) (result[nextByte] << 1);
                     } else {
                   	  index++;
                     }
                    
                 if (index == 8) {
                     index = 0;
                     nextByte++ ;
                     COUNTER++;
                 }
             }
         }

     }
     String sss= "" ;
     for(int i=0;i<COUNTER;++i) {
   	  String binaryStringg= String.format("%8s", Integer.toBinaryString(result[i]& 0xFF)).replace(' ', '0');
   	  System.out.print(binaryStringg);
     }
    
     String lastbyte=String.format("%8s", Integer.toBinaryString(result[nextByte]& 0xFF)).replace(' ', '0');
     String last="";
     for (byte i = 0 ; i <index ; i++) {
   	last =last+lastbyte.charAt(i);
     }
     System.out.println("DATA IN BYTE BUFFER IS : " + last);
 

    
  //   System.out.println("LAST BYTE : " + lastDataByte.length());


     return  result ;
	
     

}*/











/*public byte[] returnData (byte data[] , List <Node> p) throws FileNotFoundException {
    index = 0 ;
    COUNTER = 0 ;
    nextByte = 0;
    byte result[] = new byte[999999999];
    for (int i = 0 ; i < data.length ; i++) {
    	String code=search((char)data[i],p) ;
    	System.out.print(code);
    	  if (code != null) {
              for (int m = 0 ; m < code.length() ;m++) {
                      if (code.charAt(m) == '1') {
                    	  result[nextByte] = (byte) (result[nextByte] | 1 << 7 - index % 8);
                    	  index++;
                        //  result[nextByte] = (byte) (result[nextByte] << 1);
                      } else {
                    	  index++;
                      }
                     
                  if (index == 8) {
                      index = 0;
                      nextByte++ ;
                      COUNTER++;
                  }
              }
          }

      }
      String sss= "" ;
      for(int i=0;i<COUNTER;++i) {
    	  String binaryStringg= String.format("%8s", Integer.toBinaryString(result[i]& 0xFF)).replace(' ', '0');
    	  System.out.print(binaryStringg);
      }
     
      String lastbyte=String.format("%8s", Integer.toBinaryString(result[nextByte]& 0xFF)).replace(' ', '0');
      String last="";
      for (byte i = 0 ; i <index ; i++) {
    	last =last+lastbyte.charAt(i);
      }
      System.out.println("DATA IN BYTE BUFFER IS : " + last);
  

     
   //   System.out.println("LAST BYTE : " + lastDataByte.length());


      return  result ;
	
      

}*/

























