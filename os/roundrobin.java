package os;

import java.util.*;

public class roundrobin {

    static class process {
        int arrivalTime;
        int serviceTime;
        int id;
        int entryTime;

        process(int arrival, int serviceTime, int id, int entryTime) {
            this.arrivalTime = arrival;
            this.serviceTime = serviceTime;
            this.id = id;
            this.entryTime = entryTime;
        }
    }
    //round robin premptive 
    // Round Robin is the preemptive approach to FCFS
    public static void main(String[] args) {
        Scanner sys = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n = sys.nextInt();

        // int n = 4;

        int[] arrivalTimes = new int[n];
        int[] serviceTimes = new int[n];

        for (int i = 0; i < n; i++) {
            int a=i+1;
            System.out.println("Enter the arrival time of " + a + " " + "process");
            arrivalTimes[i] = sys.nextInt();
            System.out.println("Enter the service time of " + a + " " + "process");
            serviceTimes[i] = sys.nextInt();
        }
        System.out.println("Enter The Time Quantum");
        int timeQuantum = sys.nextInt();
        // int timeQuantum=2;

        PriorityQueue<process> pq = new PriorityQueue<>((a, b) -> {
            if (a.arrivalTime == b.arrivalTime)
                return a.entryTime - b.entryTime;
            return a.arrivalTime - b.arrivalTime;
        });
        int entryTime = 1;
        for (int i = 0; i < n; i++) {
            pq.add(new process(arrivalTimes[i], serviceTimes[i], i, entryTime));
            entryTime++;
        }

        int[] turn = new int[n];
        int[] waitTime = new int[n];

        int time = 0;
        while (pq.size() != 0) {
            process p = pq.poll();
            if (p.arrivalTime > time) {
                time = p.arrivalTime;
            }
            if (p.serviceTime >= timeQuantum) {
                time += timeQuantum;
            } else {
                time += p.serviceTime;
            }

            int newServiceTime = p.serviceTime - timeQuantum;
            if (newServiceTime > 0)
                pq.add(new process(time, newServiceTime, p.id, entryTime));
            if (newServiceTime <= 0) {

                turn[p.id] = time;
            }
            entryTime++;

        }
        int totalWaitTime = 0, totalTurnAroundTime = 0;
        for (int i = 0; i < n; i++) {
            waitTime[i] = (turn[i] - arrivalTimes[i]) - serviceTimes[i];
            totalWaitTime += waitTime[i];
            totalTurnAroundTime += (turn[i] - arrivalTimes[i]);
            System.out.println(waitTime[i]);
        }

        double avgWaitTime = (double) ((double) totalWaitTime) / ((double) n);
        double avgTurnAroundTime = (double) ((double) totalTurnAroundTime) / ((double) n);
        
        System.out.println("Average Wait Time");
        System.out.println(avgWaitTime);

        System.out.println(" Turn Around Time");
        System.out.println(avgTurnAroundTime);

    }

}
