
class Solution
{
    //Function to return the largest possible number of n digits
    //with sum equal to given sum.
    static String largestNumber(int n, int sum)
    {   
        int expect=9;
        String ans="";
        if(n*9<sum)return "-1";
        
        while(sum!=0){
            if(sum>=expect){
                ans+=expect+"";
                sum-=expect;
            }else{
                expect--;
            }
        }
        while(ans.length()<n){
            ans+="0";
        }
        return ans;
    }
}

