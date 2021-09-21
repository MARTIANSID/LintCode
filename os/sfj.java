package os;

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

    // shortest job means lowest burst/service time
    // this is premptive algo
    public static void main(String[] args) {
        Scanner sys = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n = sys.nextInt();
        System.out.println("Enter the time Quantum");
        int timeQuantum = sys.nextInt();

        int[] arrivalTimes = new int[n];
        int[] serviceTimes = new int[n];

        for (int i = 0; i < n; i++) {
            int pid=i+1;
            System.out.println("Enter the arrival time of " + pid + " " + "process");
            arrivalTimes[i] = sys.nextInt();
            System.out.println("Enter the service time of " + pid + " " + "process");
            serviceTimes[i] = sys.nextInt();
        }

        List<process> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++)
            jobs.add(new process(arrivalTimes[i], serviceTimes[i], i));

        // Collections.sort(jobs, (a, b) -> {
        //     return a.arrivalTime - b.arrivalTime;
        // });

        PriorityQueue<process> pq = new PriorityQueue<>((a, b) -> {
            if (a.serviceTime == b.serviceTime)
                return a.arrivalTime - b.arrivalTime;
            return a.serviceTime - b.serviceTime;
        });

        int[] turn = new int[n];
        int index = 0, time = 0;

        while (index < n || pq.size() > 0) {
            while (index < n && jobs.get(index).arrivalTime <= time) {
                pq.add(jobs.get(index));
                index++;
            }
            if (pq.size() > 0) {
                process p = pq.poll();
                if (timeQuantum <= p.serviceTime)
                    time += timeQuantum;
                else
                    time += p.serviceTime;

                int newServiceTime = p.serviceTime - timeQuantum;
                if (newServiceTime > 0)
                    pq.add(new process(p.arrivalTime, newServiceTime, p.id));
                else
                    turn[p.id] = time;

            } else {
                time++;
            }
        }
        int[] waitTime = new int[n];
        int totalWaitTime = 0, totalTurnAroundTime = 0;
        for (int i = 0; i < n; i++) {
            waitTime[i] = (turn[i] - arrivalTimes[i]) - serviceTimes[i];
            totalWaitTime += waitTime[i];
            System.out.println(turn[i]);
            totalTurnAroundTime += (turn[i] - arrivalTimes[i]);
            // System.out.println(waitTime[i]);
        }

        double avgWaitTime = (double) ((double) totalWaitTime) / ((double) n);
        double avgTurnAroundTime = (double) ((double) totalTurnAroundTime) / ((double) n);


        System.out.println("Average Wait Time");
        System.out.println(avgWaitTime);

        System.out.println("Average Turn Around Time");

        System.out.println(avgTurnAroundTime);

    }
}