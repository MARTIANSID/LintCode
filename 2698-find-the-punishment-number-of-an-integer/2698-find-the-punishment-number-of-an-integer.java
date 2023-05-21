class Solution {
    public int punishmentNumber(int n) {
        int sum=0;        
        for(int i=1;i<=n;i++){
            if(dfs((i*i)+"",0,0)){
               
                sum+=(i*i);
            }
        }
       
        return sum;
    }
    public boolean dfs(String n,int si,int sum){
        
        if(si == n.length()){
            int val=(int)Math.sqrt(Integer.parseInt(n));
            if(sum == val){
                return true;
            }else{
                return false;
            }
        }        

        for(int i=si;i<=n.length()-1;i++){
            int sub=Integer.parseInt(n.substring(si, i+1));
            if(dfs(n,i+1,sum+sub)){
                return true;
            }

        }
        return false;
    }
}