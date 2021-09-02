class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
		Arrays.sort(rooms, (x, y) -> y[1] - x[1]); // sort based on size DESC
		int qn = queries.length;
		for (int i = 0; i < qn; i++) {
			queries[i] = new int[] { i, queries[i][0], queries[i][1] }; // add idx to query
		}
		Arrays.sort(queries, (x, y) -> y[2] - x[2]); // sort based on size DESC
		int[] res = new int[qn];
		TreeSet<Integer> ts = new TreeSet<>();
		int ri = 0;  // room index
		for (int[] e : queries) {
			int qi = e[0]; // query index
			int qid = e[1]; // query id
			int qmize = e[2]; // query min size
			while (ri < rooms.length && rooms[ri][1] >= qmize) { // find all rooms that meet the min size
				ts.add(rooms[ri][0]);
				ri++;
			}
			if (ts.isEmpty()) { // no room meet the min size
				res[qi] = -1;
			} else { // has rooms, find absolute difference <=1 use floor and ceiling
				int lower = -1000000000;
				int higher = 1000000000;
				if (ts.floor(qid) != null) lower = ts.floor(qid);
				if (ts.ceiling(qid) != null) higher = ts.ceiling(qid);
				/*
				// improve to 72ms use Integer to check null directly, no need to do twice floor ceiling
				Integer lower = ts.floor(qid);
				Integer higher = ts.ceiling(qid);
				if (lower == null) lower = -1000000000;
				if (higher == null) higher = 1000000000;
				*/
				if (qid - lower <= higher - qid) { // pick up less absolute difference (closer)
					res[qi] = lower;
				} else {
					res[qi] = higher;
				}
			}
		}
		return res;
	}
}