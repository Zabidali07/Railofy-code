import java.io.*; 
import java.util.*;

public class Main {
  static boolean checkArray(long[] arr, int selection, long target) {
  
  long sum = 0;
     for (int i = 0; i < arr.length; i++){
        if (((selection >> i) & 1) == 1)
	         sum =sum + arr[i];
              }
         return sum == target;
    }
  
 
  static long[] excludeOtherElements(long[] arr, int selection) {
       long[] res = new long[arr.length];
       int j = 0;

     for (int i = 0; i < arr.length; i++){
        if (((selection >> i) & 1) == 0)
	           res[j++] = arr[i];
                  }
    
    return Arrays.copyOf(res, j);
  }
  
 
static String makeCurry(long[] arr) {
  long sum = 0;
     for(int i=0; i<arr.length; i++){
         sum = sum + arr[i];
     }
    
if (sum % 3 > 0) {
    return "noLuck";
}

  long target = sum / 3;
    
int max1 = 1 << arr.length;	
    for (int i = 0; i < max1; i++) {
	
if (checkArray(arr, i, target)) {
	    
long[] b = excludeOtherElements(arr, i);
	    
int max2 = 1 << b.length;	
	    for (int j = 0; j < max2; j++) {
		
if (checkArray(b, j, target))
   return inPQR(i, j, arr.length);
	      
}
	  
}
      
}
    
return "noLuck";
  
}
  
 
static String inPQR(int p, int q, int len) {
    
char[] res = new char[len];
    Arrays.fill (res, 'P');
    int j = 0;
    
for (int i = 0; i < len; i++)    {
	if (((p >> i) & 1) == 1)
	   res[i] = 'Q';
	
	else {
	   if (((q >> j) & 1) == 1)
	      res[i] = 'R';
	    
     j++;
	}
      
}
    
return new String (res);
  
}
  
 
public static void main (String[]args){
 
    
  
  
    long[] arr = new long[]{ 3, 7, 2, 5, 4 };
    // long[] arr = new long[]{ 3, 6, 9 };
    
System.out.println(makeCurry(arr));

} 
}