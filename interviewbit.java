public class Solution {
    class Pair{
        int no;
        int freq;
        Pair(int no,int freq){
            this.no=no;
            this.freq=freq;
        }
    }
    public int[] solve(int[] A, int[] B) {
        Stack<Integer> st=new Stack<>();
        int[] left=new int[A.length];
        int[] right=new int[A.length];
        
        Arrays.fill(left,-1);
        Arrays.fill(right,A.length);
        
        for(int i=0;i<left.length;i++){
            while(st.size()>0&&A[st.peek()]<=A[i])st.pop();
            
            if(st.size()>0){
                left[i]=st.peek();
            }
            
            st.push(i);
        }
        
        
        st.clear();
        for(int i=A.length-1;i>=0;i--){
            while(st.size()>0&&A[st.peek()]<A[i])st.pop();
            if(st.size()>0){
                right[i]=st.peek();
            }
            st.push(i);
        }
    
    
    List<Pair> g=new ArrayList<>();
    
    for(int i=0;i<A.length;i++){
        int l=left[i]+1;
        int r=right[i]-1;
        int totalSub=(i-l+1)*(r-i+1);
            Pair p=new Pair(A[i],totalSub);
            g.add(p);
        
    }
    
   List<Pair> g1=new ArrayList<>();
   
   for(int i=0;i<g.size();i++){
       divisors(g1,g.get(i));
   }
   
   Collections.sort(g1,(a,b)->{
       
       return b.no-a.no;
       });
       
      int[] ans=new int[B.length];
     
      
     
      for(int i=0;i<B.length;i++){
        int f=B[i];
         int index=0;
        for(int j=0;j<g1.size();j++){
             index+=g1.get(j).freq;
             if(index>=f){
                 ans[i]=g1.get(j).no;
                 break;
             }
        }
        
      }
    
    return ans;
    
}

int mod=(int)1e9+7;
public void divisors( List<Pair> g1,Pair p){
    int no=p.no;
    long prod=1;
    for(int i=1;i<=no/2;i++){
        if(no%i==0){
            prod=(prod*i)%mod;
        }
        
    }
    
    prod=(prod*no)%mod;
    int x=(int)(prod%mod);
    
    g1.add(new Pair(x,p.freq));
    
}

// 8 8 2 2 1 0 
// [8, 8, 8, 2, 2, 1]
}
// 0   2    4
// 1,2,5,3,1


// 1,2,5
// 2,5
// 5
// 5,3,1
// 5,3
// 1,2,5,3,1
// 1,2,5,3
// 2,5,3,1
// 2,5,3

// [1,2,4]
// [1, 2, 2, 4, 4, 4]
// 1,2,4
// 1,2,

// // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
// at java.util.Arrays.copyOf(Arrays.java:3210)
// at java.util.Arrays.copyOf(Arrays.java:3181)
// at java.util.ArrayList.grow(ArrayList.java:265)
// at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
// at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
// at java.util.ArrayList.add(ArrayList.java:462)
// at Solution.solve(Solution.java:39)
// at Main.main(Main.java:193)

// You are given an array A having N integers.

// You have to perform the following steps in a given order.

// 1) generate all subarrays of A.

// 2) take the maximum element from each subarray of A and insert it into a new array G.

// 3) replace every element of G with the product of their divisors mod 1e9 + 7.

// 4) sort G in descending order

// You now need to perform Q queries

// In each query, you are given an integer K, where you have to find the Kth element in G.

// NOTE : Your solution will run on multiple test cases so do clear global variables after using them.



// Problem Constraints
// 1 <= N <= 1e5

// 1 <= A[i] <= 1e5

// 1 <= Q <= 1e5

// 1 <= k <= (N * (N + 1))/2



// Input Format
// The first argument given is an Array A, having N integers.

// The second argument given is an Array B, where B[i] is the ith query.



// Output Format
// Return an Array X, where X[i] will have the answer for the ith query.