class Solution {
    // List<Integer> ans=new ArrayList<>();/
    public List<Integer> sequentialDigits(int low, int high) {
        
        String s="123456789";
        
        List<Integer> ans=new ArrayList<>(); 
        
        
        for(int i=2;i<=9;i++){
            for(int j=0;j+i<10;j++){
                int num=Integer.parseInt(s.substring(j,j+i));
                if(num>=low&&num<=high)ans.add(num);
                else if(num>high) return ans;
            }
        }
        
        return ans;
            
        
        //first add all the 2 digit numbers
        //then 3 digit
        //then 4 digit
        //and so on
        
       
        //s="123456789"
        // 23456
    }
//     public void  generate(int low,int high,int current,int i){
        
//         if(current >= low && current <= high) {
//                 ans.add(current);
//         }
        
//         if(current > high || i>9){
//             return;
//         }
        
//             generate(low,high,current*10+i,i+1);
//     }
}