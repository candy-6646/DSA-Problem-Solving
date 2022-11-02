/* Largest rectangle in a histogram

Brute force- for every ele of arr[i] find it's left min. index, if no left min. then lm = -1;
             for every ele of arr[i] find it's right min. index, if no right min. then rm = n;
            Now when we found lm and rm, now it's time to compute the area of curr arr[i]
            width = (rm-lm)-1, height = arr[i]
            Area = width*height
            After that update max;


*/


/***************************************BRUTE-FORCE*********************************************** */
import java.util.ArrayList;

public class Solution {
  public static int largestRectangle(ArrayList < Integer > heights) {
      long ans = 0;
      for(int i = 0; i < heights.size(); i++) {
          //left minimum index, if itself min. return -1
          int lm = i;
          for(int j = i; j >= 0; j--) {
              if(heights.get(j) < heights.get(lm)) {
                  lm = j;
                  break;
              }
          }
          lm = lm==i ? -1:lm;
          //right min index, if itself is min. return n
          int rm = i;
          for(int j = i; j < heights.size(); j++) {
              if(heights.get(j) < heights.get(rm)) {
                  rm = j;
                  break;
              }
          }
          rm = rm==i ? heights.size():rm;
//           System.out.println(heights.get(i) + " " + lm + " " + rm);
          int w = (rm-lm)-1;
          ans = Math.max(ans, (long)w*heights.get(i));
      }
      
      return (int)ans;
  }
}