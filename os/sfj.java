

import java.util.*;

public class sfj {

    static class process {
        int arrivalTime;
        int serviceTime;
        int id;

        process(int arrivalTime, int serviceTime, int id) {
            this.arrivalTime = arrivalTime;
            this.serviceTime = serviceTime;
            this.id = id;
        }
    }
    public static void main(String[] args) {
        Scanner sys = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n = sys.nextInt();
        System.out.println("Enter the time Quantum");
        int tQ = sys.nextInt();

        int[] aT = new int[n];
        int[] sT = new int[n];

        for (int i = 0; i < n; i++) {
            int pid=i+1;
            System.out.println("Enter the arrival time of " + pid + " " + "process");
            aT[i] = sys.nextInt();
            System.out.println("Enter the service time of " + pid + " " + "process");
            sT[i] = sys.nextInt();
        }

        List<process> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++)
            jobs.add(new process(aT[i], sT[i], i));


        PriorityQueue<process> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.serviceTime == b.serviceTime)
                return a.arrivalTime - b.arrivalTime;
            return a.serviceTime - b.serviceTime;
        });

        int[] turn = new int[n];
        int jobNo = 0, time = 0;

        while (jobNo < n || minHeap.size() > 0) {
            while (jobNo < n && jobs.get(jobNo).arrivalTime <= time) {
                minHeap.add(jobs.get(jobNo));
                jobNo++;
            }
            if (minHeap.size() > 0) {
                process p = minHeap.poll();
                if (tQ <= p.serviceTime)
                    time += tQ;
                else
                    time += p.serviceTime;

                int newServiceTime = p.serviceTime - tQ;
                if (newServiceTime > 0)
                    minHeap.add(new process(p.arrivalTime, newServiceTime, p.id));
                else
                    turn[p.id] = time; //saving the time at which this particular process gets completed
            } else {
                time++;
            }
        }
        int[] waitTime = new int[n];
        int totalWaitTime = 0, totalTurnAroundTime = 0;
        for (int i = 0; i < n; i++) {
            waitTime[i] = (turn[i] - aT[i]) - sT[i];
            totalWaitTime += waitTime[i];
            System.out.println(turn[i]);
            totalTurnAroundTime += (turn[i] - aT[i]);
           
        }
        double avgWaitTime = (double) ((double) totalWaitTime) / ((double) n); //average time
        double avgTurnAroundTime = (double) ((double) totalTurnAroundTime) / ((double) n);


        System.out.println("Average Wait Time Calculated is:");
        System.out.println(avgWaitTime);
        System.out.println("Average Turn Around Time Calculated is:");
        System.out.println(avgTurnAroundTime);

    }
}