class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        int n=rectangles.length;
        HashMap<String,Long> map=new HashMap<>();
        long ans=0;
        
        for(int[] r:rectangles){
            int w=r[0],h=r[1];
            
            int hcf=gcd(w,h);
            w=w/hcf;
            h=h/hcf;
            
            String key=w+","+h;
            ans+=map.getOrDefault(key,(long)0);
            map.put(key,map.getOrDefault(key,(long)0)+1);
            
        }
        
        return ans;
    }
    
    public int gcd(int a,int b){
        if(b==0)return a;
        
        return gcd(b,a%b);
    }
}