import java.util.Iterator;
import java.util.TreeSet;

class ExamRoom {
    TreeSet<Integer> set;
    int n;

    public ExamRoom(int n) {
        this.set = new TreeSet<>();
        this.n = n-1;
    }

    public int seat() {
        if (set.isEmpty()){
            set.add(0);
            return 0;
        }

        Iterator<Integer> itr = set.iterator();
        int dist = 0, pos = -1;

        int lowest = itr.next();
        int currDistance = lowest - 0;
        if (currDistance >= dist) {
            pos = 0;
            dist = currDistance;
        }
        while (itr.hasNext()) {
            int next = itr.next();
            int point = (next + lowest) / 2;
            currDistance = point - lowest;
            if (currDistance > dist) {
                pos = point;
                dist = currDistance;
            }
            lowest = next;
        }
        currDistance = n - lowest;
        if (currDistance > dist) {
            pos = n;

        }
        set.add(pos);
        return pos;
    }

    public void leave(int p) {
        set.remove(p);
    }
}