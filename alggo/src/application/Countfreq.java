package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Countfreq {
	int [] count  ;
    byte [] value;
    byte [] read;
public void  CountFrequency(String Path) throws IOException {
 count  = new int[256] ;
 value = new byte[256] ;
 read= Files.readAllBytes(Paths.get(Path));
  for (int i = 0 ; i < read.length ; i++) {
      if (read[i] < 0) {
          count[256+read[i]]++;
          value[256+read[i]] = read[i] ;
      }
      else
      {
          count[read[i]]++;
          value[read[i]] = read[i] ;
      }
      
  }
   
}
}
