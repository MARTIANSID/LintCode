import java.util.ArrayList;

public class heap {
    private ArrayList<Integer> arr;
    private boolean isMaxHeap;

    void defaultvalue(boolean isMaxHeap) {
        this.arr = new ArrayList<>();
        this.isMaxHeap = isMaxHeap;
    }

    void contstructHeap() {
        for (int i = this.arr.size() - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    heap() {
        defaultvalue(true);
    }

    heap(boolean isMaxHeap) {
        defaultvalue(isMaxHeap);
    }

    heap(int[] arr, boolean isMaxHeap) {
        defaultvalue(isMaxHeap);
        for (int ele : arr)
            this.arr.add(ele);
    }

    int size() {
        return this.arr.size();
    }

    boolean isEmpty() {
        return this.arr.size() == 0;
    }

    public void add(int data){
        this.arr.add(data);
        upHeapify(size()-1);
    }

    public int remove() {
        int ele = this.arr.get(0);
        int n = this.size();
        swap(0, n - 1);
        this.arr.remove(n - 1);
        downHeapify(0);

        return ele;

    }

    int top() {
        return this.arr.get(0);
    }

    public void swap(int index1, int index2) {
        int temp = this.arr.get(index1);
        arr.set(index1, this.arr.get(index2));
        arr.set(index2, temp);
    }

   public void downHeapify(int parent){
       int maxIndex=parent; 
       int rightChild=2*parent+2;   
       int leftChild=2*parent+1;

       if(rightChild<this.arr.size()&&this.arr.get(rightChild)>this.arr.get(maxIndex)){
           maxIndex=rightChild;
       }

        if(leftChild<this.arr.size()&&this.arr.get(leftChild)>this.arr.get(maxIndex)){
            maxIndex=leftChild;
        }

    if(maxIndex!=parent){
        swap(maxIndex,parent);
        downHeapify(maxIndex);
    }
   }

    public void upHeapify(int child) {
        int parent = (child - 1) / 2;
        if(parent>=0&&this.arr.get(child)>parent){
            swap(parent,child);
            upHeapify(parent);
        }

    }

}
