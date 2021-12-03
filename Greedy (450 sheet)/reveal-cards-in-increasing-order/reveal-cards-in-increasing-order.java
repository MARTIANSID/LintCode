class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length;
        
       Arrays.sort(deck);
        LinkedList<Integer> que=new LinkedList<>();
        
        que.add(deck[n-1]);
        for(int i=n-2;i>=0;i--){
           int ele= que.removeLast();
            que.addFirst(ele);
            que.addFirst(deck[i]);
        }
        int[] ans=new int[n];
        for(int i=0;i<que.size();i++)ans[i]=que.get(i);
        return ans;
    }
}