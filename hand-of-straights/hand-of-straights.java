class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<hand.length;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        
        int n=hand.length;
        
        for(int i=0;i<n;i++){
            
            if(map.containsKey(hand[i])){
                 int f= map.get(hand[i])-1;
                    if(f>0){
                        map.put(hand[i],f);
                    }else map.remove(hand[i]);
                int size=groupSize;
                int curr=hand[i];
                while(size-->1){
                    
                    if(map.containsKey(curr+1)){
                       int x= map.get(curr+1)-1;
                        if(x>0){
                        map.put(curr+1,x);
                        }else{
                            map.remove(curr+1);
                        }
                  
                        curr=curr+1;
                    }
                    else return false;
                }
                
            }
        }
        
        return true;
    }
}


// [1,2,3,4]