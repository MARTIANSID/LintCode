class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n=asteroids.length;
        Arrays.sort(asteroids);
        
        long m=(long)mass;
       
        for(int ele:asteroids){
            if(ele<=m){
                m=m+(long)ele;
                
            }else{
                return false;
            }
        }
        return true;
    }
}