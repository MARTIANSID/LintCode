class Solution {
    public int numSpecialEquivGroups(String[] words) {
        int n=words.length,max=0;
    
        HashMap<String,Integer> map=new HashMap<>();
        
        for(String word:words){
           int size=word.length();
           char[] even=new char[size%2==0?size/2:((size/2)+1)];
           char[] odd=new char[size/2];
            int ei=0,oi=0;
           for(int i=0;i<size;i++){
               char ch=word.charAt(i);
               if(i%2==0){
                   even[ei++]=ch;
               }else{
                   odd[oi++]=ch;
               }
           }
            Arrays.sort(even);
            Arrays.sort(odd);
            ei=0;
            oi=0;
            String sorted="";
            for(int i=0;i<size;i++){
               if(i%2==0){
                   sorted+=even[ei++];
               }else{
                  sorted+=odd[oi++];
               }
           }

            map.put(sorted,map.getOrDefault(sorted,0)+1);
            
            
        }
        
        return map.size(); 
        
    }
}