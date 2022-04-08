class Solution {

    class pair {
        int load;
        int id;

        pair(int load, int id) {
            this.load = load;
            this.id = id;
        }
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        List<Integer> busiestServer = new ArrayList<>();

        int n = arrival.length;

        int[] servers = new int[k];

        TreeSet<Integer> availableServers = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }

        PriorityQueue<pair> busyServers = new PriorityQueue<>(
            (a, b) -> {
                return a.load - b.load;
            }
        );

        int i = 0;
        int time = 0;

        while (i < n) {
            
             time = arrival[i];
            
            while (busyServers.size() > 0 && busyServers.peek().load <= time) availableServers.add(busyServers.poll().id);

            Integer val = availableServers.ceiling((i) % k);
            
            if(val == null){
                if(availableServers.size()>0)
                val=availableServers.first();
            }

            if (val != null) {
                servers[val]++;
                availableServers.remove(val);
                busyServers.add(new pair(time+load[i], val));
            }
            i++;
        }

        int max = 0;

        for (int ele : servers) {
            max = Math.max(max, ele);
        }

        int index = 0;

        for (int ele : servers) {
            if (max == ele) busiestServer.add(index);
            index++;
        }

        return busiestServer;
    }
}
