class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        int si=0,ei=(int)1e9;
            Arrays.sort(houses);
            Arrays.sort(heaters);
        
        while(si<=ei){
            int mid=(si+ei)/2;
            if(check(houses,heaters,mid)){
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        
        return si;
    }
    
    public boolean check(int[] houses,int[] heaters,int k){
        
        int i=0,j=0;
       while(i<houses.length){
            if(j>=heaters.length)return false;
            
            int low=heaters[j]-k;
            int high=heaters[j]+k;
           int val=heaters[j];
            
           int index=i;
            while(i<houses.length&&houses[i]<val&&low<=houses[i]){
                i++;
            }
          
            if(i==houses.length)return true;
          
           if(houses[i]==val)i++;
          
           
           while(i<houses.length&&houses[i]>val&&high>=houses[i]){
               i++;
           }
           
           
           j++;
        }
        return true;
        
    }
}