class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        int i=0;
        int j=people.length-1;
        int ans=0;
        
        while(i<=j){
            if(people[i]+people[j]<=limit){
                ans++;
                i++;
                j--;
            }else{
                j--;
                ans++;
            }
        }
        return ans;
    }
}



// 1,2,2,3  
// 3,3,4,5