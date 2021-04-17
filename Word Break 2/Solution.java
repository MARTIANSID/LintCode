class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
             // HashMap<String,Boolean> map=new HashMap <>();
            
            List<String> ans=new ArrayList<>();
           solve(s,wordDict, new ArrayList<>(),ans);
            
            return ans;
            
            
            
    }
        
        
         public boolean solve(String s,List<String> wordfDict,List<String> ans,List<String> result){
                
                if(s.length()==0){
                        
                        String ss="";
                        
                        for(int i=0;i<ans.size();i++){
                                if(i==ans.size()-1) ss+=ans.get(i);
                                else
                                ss+=ans.get(i)+" ";
                        }
                        result.add(ss);
                        
                        return   false;
                        }
                
                
               
                
                for(int i=0;i<s.length();i++){
                        
                        String str=s.substring(0,i+1);
                        
                        String rem=s.substring(i+1,s.length());
                        
                        
                        if(wordfDict.contains(str)){
                                
                                ans.add(str);

                            boolean x=  solve(rem,wordfDict,ans,result);
                                if(x)return true;
                                
                                ans.remove(ans.size()-1);
                           
                                
                        }
                        
                }
              
                return false;
                
                
        }
}