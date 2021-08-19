class Solution {
    static ArrayList<Integer> factorial(int N){
        ArrayList<Integer> ans=new ArrayList<>();
         int mod=(int)1e9+7;
          ans.add(1);
          for(int i=2;i<=N;i++){
              long carry=0;
              for(int j=0;j<ans.size();j++){
                 
                 long val= ((ans.get(j)*i)%mod+carry)%mod;
                 ans.set(j,(int)(val%10%mod));
                 carry=val/10;
              }
              while(carry!=0){
                 ans.add((int)(carry%10));
                 carry=carry/10;
                 
                 
              }
          }
          Collections.reverse(ans);
          return ans;
    }
}