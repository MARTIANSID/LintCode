public class Solution {
    /**
     * @param arrs: an array of arrays
     * @return: return the max distance among arrays
     */
    public int maxDiff(int[][] arrs) {
      
        int max1=-(int)1e9, max2=-(int)1e9;
        int xr1=0,xr2=0;
        int min1=(int)1e9, min2=(int)1e9;
        int nr1=0,nr2=0; 
        for(int i=0;i<arrs.length;i++){
              int max=arrs[i][arrs[i].length-1];
              int min=arrs[i][0];

              if(max>=max1){
                max2=max1;
                xr2=xr1;
                max1=max;
                xr1=i;
              }else if(max>max2){
                  max2=max;
                  xr2=i;
              }

              if(min<=min1){
                  min2=min1;
                  nr2=nr1;
                  min1=min;
                  nr1=i;
              }else if(min<min2){
                  min2=min;
                  nr2=i;
              }
        }

        int max=0;
        if(nr1!=xr1){
            max=Math.max(max,Math.abs(min1-max1));
        }

        if(nr2!=xr1){
            max=Math.max(max,Math.abs(min2-max1));
        }

        if(nr2!=xr2){
            max=Math.max(max,Math.abs(min2-max2));
        }

        if(nr1!=xr2){
            max=Math.max(max,Math.abs(min1-max2));
        }

        max=Math.max(max,Math.abs(min1-min2));
        return max;

   

    }
}

