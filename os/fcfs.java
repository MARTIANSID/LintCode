
    import java.util.*;

    public class fcfs {
    
                public static void main(String[] args) {
            Scanner sys = new Scanner(System.in);
            System.out.println("Enter the number of processes");
            int n = sys.nextInt();

            int[] aT = new int[n];
            int[] sT = new int[n];

            for (int i = 0; i < n; i++) {
                int z=i+1;
                System.out.println("Enter the arrival time of " + z+ " "+ "process");
                aT[i] = sys.nextInt();
                System.out.println("Enter the service time of " + z + " "+ "process");
                sT[i] = sys.nextInt();
            }

            int[] cT = new int[n];

            double totalWaitTime=0;
            double avgWaitTime=0;

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    cT[i] = aT[i] + sT[i];
                } else {
                    if (aT[i] > cT[i - 1]) {
                        cT[i] = aT[i] + sT[i];
                    } else
                        cT[i] = cT[i - 1] + sT[i];
                }
                
                totalWaitTime+=cT[i]-aT[i];
            }
            avgWaitTime=((double)totalWaitTime/(double)n);

            System.out.println(avgWaitTime);
            
        }
    }