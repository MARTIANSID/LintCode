class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        solve(s,0,new ArrayList<>());
        return ans;
    }
    public void solve(String s,int index,List<String> result){
        
        if(index == s.length()){
            if(result.size()<=3 || result.size()>4)return;
            String ip="";
            for(int i=0;i<result.size();i++){
                ip+=result.get(i);
                if(i!=result.size()-1){
                    ip+=".";
                }
            }
            ans.add(ip);
            return;
        }
        
        String str="";
        
        if(s.charAt(index) == '0'){
            result.add("0");
            solve(s,index+1,result);
            result.remove(result.size()-1);
            return;
        }
        
        for(int i=index;i<Math.min(index+3,s.length());i++){
            str+=s.charAt(i);
            int val=Integer.parseInt(str);
            if(val>=0 && val<=255){
                result.add(str);
                solve(s,i+1,result);
                result.remove(result.size()-1);
            }
        }
        
    }
}