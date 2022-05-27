class TopVotedCandidate {
    int[] prefix;
    int[] freq;
    TreeMap<Integer,Integer> tree;
    public TopVotedCandidate(int[] persons, int[] times) {
        int n=persons.length;
        this.prefix=new int[n];
        this.tree=new TreeMap<>();
        this.freq=new int[n];
        int max=0,candidate=-1;
        for(int i=0;i<n;i++){
            freq[persons[i]]++;
            if(freq[persons[i]]>=max){
                max=freq[persons[i]];
                candidate=persons[i];
            }
            tree.put(times[i],candidate);
        }
    }
    
    public int q(int t) {
        return tree.get(tree.floorKey(t));
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */