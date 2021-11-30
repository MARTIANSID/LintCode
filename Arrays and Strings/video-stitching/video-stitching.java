class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips,(a,b)->{
            return a[0]-b[0];
        });
     
        
        int start=0,i=0,clip=0,max=0;
        
        while(start<time){
            while(i<clips.length&&clips[i][0]<=start){
               max=Math.max(max,clips[i][1]);
                i++;
            }
            
            if(max<=start)return -1;
            clip++;
            
            start=max;
            
            
        }
        
        return clip;
        
        
    }
}


// 0,2    [1,9]   8,10

// 0, 8 