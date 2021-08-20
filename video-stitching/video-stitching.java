class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips,(a,b)->{
            return a[0]-b[0];
        });
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return b[1]-a[1];
        });
        
        
        int start=0,i=0,clip=0;
        
        while(start<time){
            while(i<clips.length&&clips[i][0]<=start){
                pq.add(clips[i]);
                i++;
            }
            
            if(pq.size()==0)return -1;
            clip++;
            
            start=pq.poll()[1];
            
            
        }
        
        return clip;
        
        
    }
}


// 0,2    [1,9]   8,10

// 0, 8 