class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        int n=segments.length;
        // Arrays.sort(segments,(a,b)->{
        //     if(a[0]==b[0])return a[1]-b[1];
        //     else return a[0]-b[0];
        // });
        
        long[] temp=new long[(int)1e5+1];
        boolean[] end=new boolean[(int)1e5+1];
        
        for(int[] seg:segments){
            temp[seg[0]]+=seg[2];
            temp[seg[1]]-=seg[2];
            end[seg[1]]=true;
            end[seg[0]]=true;
            
        }   
        
        List<List<Long>> ans=new ArrayList<>();
        
        int prev=-1;
        long sum=0;
        for(int i=0;i<temp.length;i++){
            List<Long> a=new ArrayList<>();
            if(prev!=-1&&(end[i]||temp[i]!=0)&&sum>0){
                a.add((long)prev);
                a.add((long)i);
                a.add(sum);
                ans.add(a);
            }
        if(temp[i]!=0||end[i]){
            sum+=temp[i];
            prev=i;
    }
          
        }
        return ans;
        
    }
}