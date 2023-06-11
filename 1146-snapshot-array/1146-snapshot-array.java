import java.util.*;

class SnapshotArray {

  int snap_id=0;
  TreeMap<Integer,Integer>[] ds;

  public SnapshotArray(int length) {

    this.ds=new TreeMap[length];

    for(int i=0;i<length;i++){
      ds[i]=new TreeMap<>();
      ds[i].put(0, 0);
    }

  }

  public void set(int index, int val) {
    ds[index].put(snap_id,val);

  }

  public int snap() {
    int val=snap_id;
    snap_id++;
    return val;
  }

  public int get(int index, int snap_id) {
      return ds[index].get(ds[index].floorKey(snap_id));
  }
}