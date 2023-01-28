import java.util.Set;
import java.util.TreeMap;

class SummaryRanges {

  TreeMap<Integer,Integer> tree;

  public SummaryRanges() {
      tree=new TreeMap<>();
  }

  public void addNum(int value) {
     Integer lower=tree.floorKey(value);
     Integer upper=tree.ceilingKey(value);
     if(lower==null && upper==null){
      tree.put(value,value);
     }else if(lower ==null){
        int val=tree.get(upper);
        if(value+1==upper){
          tree.remove(upper);
          tree.put(value,val);
        }else{
          tree.put(value,value);
        }
     }else if(upper==null){
        int val=tree.get(lower);
        if(val+1==value){
          tree.put(lower,value);
        }else if(value > val){
          tree.put(value,value);
        }
     }else{
          int lowerVal=tree.get(lower);
          int upperVal=tree.get(upper);
          if(lowerVal+1 ==value && value+1==upper){
            tree.put(lower,upperVal);
            tree.remove(upper);
            return;
          }

        if(lowerVal+1==value){
          tree.put(lower,value);
          return;
        }

        if(value+1==upper){
          tree.remove(upper);
          tree.put(value,upperVal);
          return;
        }
          if(value > lowerVal && value < upper){
            tree.put(value,value);
          }
     }
  }

  public int[][] getIntervals() {
    int[][] ans=new int[tree.size()][2];

    Set<Integer> set=tree.keySet();
    int index=0;
    for(int key:set){
      ans[index][0]=key;
      ans[index++][1]=tree.get(key);
    }
    return ans;
  }
}