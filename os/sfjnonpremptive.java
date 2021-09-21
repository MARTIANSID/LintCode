package os;

import java.util.*;

public class sfjnonpremptive {
    static class process {
        int id;
        int serviceTime;
        int arrivalTime;

        process(int id, int serviceTime, int arrivalTime) {
            this.id = id;
            this.serviceTime = serviceTime;
            this.arrivalTime = arrivalTime;
        }
    }

    public static void main(String[] args) {
        Scanner sys = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n = sys.nextInt();
        // System.out.println("Enter the time Quantum");
        // int timeQuantum = sys.nextInt();

        int[] arrivalTimes = new int[n];
        int[] serviceTimes = new int[n];

        for (int i = 0; i < n; i++) {
            int a = i + 1;
            System.out.println("Enter the arrival time of " + a + " " + "process");
            arrivalTimes[i] = sys.nextInt();
            System.out.println("Enter the service time of " + a + " " + "process");
            serviceTimes[i] = sys.nextInt();
        }
        List<process> jobs = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            jobs.add(new process(i, serviceTimes[i], arrivalTimes[i]));
        }

        Collections.sort(jobs,(a,b)->{
            return a.arrivalTime-b.arrivalTime;
        });


        PriorityQueue<process> pq = new PriorityQueue<>((a, b) -> {
            return a.serviceTime - b.serviceTime;
        });

        int[] turn = new int[n];
        int time = 0, index = 0;

        while (index<n||pq.size()!=0) {
            while (index < n && jobs.get(index).arrivalTime <= time) {
                pq.add(jobs.get(index));
                index++;
            }

            if (pq.size() > 0) {
                process p = pq.poll();
                time += p.serviceTime;
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
            // System.out.println(turn[i]);
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
