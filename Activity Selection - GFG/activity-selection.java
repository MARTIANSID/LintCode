// { Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        
        List<int[]> activities=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            activities.add(new int[]{start[i],end[i]});
        }
        
        Collections.sort(activities,(a,b)->{
            return a[0]-b[0];
        });
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        int max=0,om=0;
        for(int[] act:activities){
            while(pq.size()>0 && pq.peek()[1]<act[0]){
                max=Math.max(max,pq.peek()[2]);
                pq.poll();
            }
            pq.add(new int[]{act[0],act[1],max+1});
            om=Math.max(om,max+1);
            
        }
    
    
        return om;
    }
}