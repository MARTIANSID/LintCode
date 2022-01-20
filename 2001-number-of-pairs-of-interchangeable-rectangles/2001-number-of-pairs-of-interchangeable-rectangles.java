class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        int n=rectangles.length;
        HashMap<Double,Long> map=new HashMap<>();
        long ans=0;
        for(int[] r:rectangles){
            int l=r[0],w=r[1];
            
            double ratio=(double)((double)l/(double)w);
            ans+=map.getOrDefault(ratio,(long)0);
            map.put(ratio,map.getOrDefault(ratio,(long)0)+1);
            
        }
        return ans;
    }
}