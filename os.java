import java.util.*;

public class os {

    public static void main(String[] args) {
        Scanner sys = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n = sys.nextInt();

        int[] arrivalTimes = new int[n];
        int[] serviceTimes = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the arrival time of " + i + 1 + " "+ "process");
            arrivalTimes[i] = sys.nextInt();
            System.out.println("Enter the service time of " + i + 1 + " "+ "process");
            serviceTimes[i] = sys.nextInt();
        }

        int[] completionTime = new int[n];

        double avgWaitTime=0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                completionTime[i] = arrivalTimes[i] + serviceTimes[i];
            } else {
                if (arrivalTimes[i] > completionTime[i - 1]) {
                    completionTime[i] = arrivalTimes[i] + serviceTimes[i];
                } else
                    completionTime[i] = completionTime[i - 1] + serviceTimes[i];
            }
            
            avgWaitTime+=completionTime[i]-arrivalTimes[i];
        }
        avgWaitTime=((double)avgWaitTime/(double)n);

        System.out.println(avgWaitTime);
        
    }
}