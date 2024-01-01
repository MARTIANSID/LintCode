class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length, m=s.length;
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int cnt=0;
        
        int index=0;
        
        for(int i=0;i<s.length;i++){
            if(g.length == index)break;
            if(s[i]>=g[index]){
                cnt++;
                index++;
            }
        }
        
        return cnt;
    }
}