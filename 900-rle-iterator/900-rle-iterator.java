class RLEIterator {

    class pair {
        int no;
        int freq;

        pair(int no, int freq) {
            this.no = no;
            this.freq = freq;
        }
    }

    Deque<pair> dq;

    public RLEIterator(int[] encoding) {
        this.dq = new ArrayDeque<>();
        for (int i = 0; i < encoding.length; i += 2) {
            if (encoding[i] != 0) dq.add(new pair(encoding[i + 1], encoding[i]));
        }
    }

    public int next(int n) {
       
       while(n>0){
           if(dq.size()==0)return -1;
           pair p=dq.removeFirst();
           if(p.freq>=n){
               if(p.freq-n>0){
                   dq.addFirst(new pair(p.no,p.freq-n));
               }
               return p.no;
           }else{
              n-=p.freq;
           }
               
       }
        return -1;
        
    }
}
/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */
