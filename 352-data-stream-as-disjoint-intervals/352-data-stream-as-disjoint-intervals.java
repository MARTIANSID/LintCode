class SummaryRanges {

    TreeSet<Integer> tree;
    
    public SummaryRanges() {
        this.tree=new TreeSet<>();
    }
    
    public void addNum(int val) {
        tree.add(val);
    }
    
    public int[][] getIntervals() {
        List<Integer> list=new ArrayList<>(tree);
        
        List<List<Integer>> intervals=new ArrayList<>();
        
        for(int i=0;i<list.size();i++){
            
            int start=i;
            int prev=list.get(i++);
            while(i<list.size() && list.get(i)-1==prev)
            {
                prev=list.get(i);
                i++;
            }
            
            List<Integer> interval=new ArrayList<>();
            i--;
            interval.add(list.get(start));
            interval.add(list.get(i));
            intervals.add(interval);
        }
        
        int[][] ans=new int[intervals.size()][2];
        
        for(int i=0;i<intervals.size();i++){
            int[] temp=new int[2];
            temp[0]=intervals.get(i).get(0);
            temp[1]=intervals.get(i).get(1);
            ans[i]=temp;
        }
        
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */