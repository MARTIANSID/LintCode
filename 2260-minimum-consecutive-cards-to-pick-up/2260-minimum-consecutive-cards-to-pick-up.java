
class Solution {

    public int minimumCardPickup(int[] cards) {
        int n = cards.length;

        //sliding window approach
        
        int count=0;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int ei=0,si=0,min=(int)1e9;
        
        while(ei<n){
            map.put(cards[ei],map.getOrDefault(cards[ei],0)+1);
            if(map.get(cards[ei++])>1)count++;
            
            while(count>0){
                min=Math.min(min,ei-si);
                map.put(cards[si],map.get(cards[si])-1);
                if(map.get(cards[si])==1)count--;
                si++;
            }
        }
        
        return min == (int)1e9 ? -1:  min;
    }
}