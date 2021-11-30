class CombinationIterator {

    String str;
    int n;
    List<String> ans =new ArrayList<>();
    int index=0;
    public CombinationIterator(String characters, int combinationLength) {
        this.str=characters;
        this.n=combinationLength;
        solve("",0);
    }
    
    public void solve(String anf,int j){
        
        if(anf.length()==n){
            ans.add(anf);
            return;
        }
        
        for(int i=j;i<str.length();i++){
            solve(anf+str.charAt(i),i+1);
        }
    }
    
    public String next() {
            return ans.get(index++);
    }
    
    public boolean hasNext() {
            return index<ans.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */