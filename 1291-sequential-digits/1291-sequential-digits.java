class Solution {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        
        
        for(int i=1;i<=9;i++)
         generate(low,high,0,i);
        
        
        Collections.sort(ans);
            return ans;
        //s="123456789"
        // 23456
    }
    public void  generate(int low,int high,int current,int i){
        
        if(current >= low && current <= high) {
                ans.add(current);
        }
        
        if(current > high || i>9){
            return;
        }
        
            generate(low,high,current*10+i,i+1);
    }
}