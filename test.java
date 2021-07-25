import java.util.ArrayList;

// import javax.swing.text.html.HTMLDocument.Iterator;

public class test {

	public static  int removeDuplicates(ArrayList<Integer> a) {
        int j=0;
        for(int i=1;i<a.size();i++){
            // System.out.println(a.get(j));
            System.out.println(a.get(i));
            if(a.get(i)==a.get(j)){
                //    System.out.println(ra.get(j));
                int x=i;
                while(x<a.size()&&a.get(x)==a.get(j)){
                    // System.out.println(x);
                    a.set(x,-(int)1e9);
                    x++;
                }
                i=x;
                j=x;
            }else{
                j=i;
            }
        }

       java.util.Iterator<Integer> itr = a.iterator();
        while (itr.hasNext())
        {

            int x = (Integer)itr.next();
            // System.out.println(x);
            if (x == -(int)1e9)
                itr.remove();
        }
        return a.size();
	}

   public static void main(String[] args){

     ArrayList<Integer> a=new ArrayList<>();
     a.add(5000);
     a.add(5000);
     a.add(5000);
     removeDuplicates(a);
System.out.println(a);
    //    int[] arr={10,20,30,-2,-3,-4,5,6,7,8,9,22,11,13};
    //    heap h=new heap(arr,true);
    //    h.contstructHeap();
    // while(h.size()!=0){
    //     System.out.println(h.remove());     
    // }
   } 
}
