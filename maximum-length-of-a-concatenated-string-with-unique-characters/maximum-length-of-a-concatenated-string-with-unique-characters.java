class Solution {
    public int maxLength(List<String> arr) {
        int n =arr.size();
        
        return solve(arr,"",0);
    }
    
    public int solve(List<String> arr,String curr,int index){
        
        if(index==arr.size())return 0;
        
        String include=curr+arr.get(index);
        int x=-(int)1e9;
        if(unique(include))
        x=solve(arr,include,index+1) +arr.get(index).length();
        
       int y= solve(arr,curr,index+1);
        
        return Math.max(x,y);
        
    }
    
    public boolean unique(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(map.containsKey(ch))return false;
            map.put(ch,i);
        }
        return true;
    }
}