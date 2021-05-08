public class test {
   public static void main(String[] args){
       int[] arr={10,20,30,-2,-3,-4,5,6,7,8,9,22,11,13};
       heap h=new heap(arr,true);
       h.contstructHeap();
    while(h.size()!=0){
        System.out.println(h.remove());     
    }
   } 
}
