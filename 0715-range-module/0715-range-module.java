import java.util.TreeMap;

class RangeModule {
    TreeMap<Integer, Integer> tree;

    public RangeModule() {
        this.tree = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        /* if already covered no need to do any thing  */
        if (queryRange(left, right)) return;
        Integer lL = tree.ceilingKey(left);
        while (lL != null && tree.get(lL) <= right) {
            tree.remove(lL);
            lL = tree.ceilingKey(left);
        }
        Integer sL = tree.floorKey(left);

        if (sL == null && lL == null) {
            tree.put(left, right);
            return;
        }
        int lower = left, upper = right;

        if (sL != null) {
            int sR = tree.get(sL);
            if (sR >= left) {
                tree.remove(sL);
                lower = sL;
                if (sR >= right) {
                    upper = sR;
                } else {
                    upper = right;
                }
            } else {
                upper = right;
                lower = left;
            }
        }

        if (lL != null) {
            int lR = tree.get(lL);
            if (lL <= right) {
                tree.remove(lL);
                if (lR >= right) upper = lR;
            } else {
                upper = right;
            }
        }
        tree.put(lower, upper);
    }

    public boolean queryRange(int left, int right) {
        Integer sL = tree.floorKey(left);
        if (sL == null) return false;
        int rL = tree.get(sL);
        if (rL < right) return false;

        return true;
    }

    public void removeRange(int left, int right) {
        Integer lL = tree.ceilingKey(left);

        while (lL != null && tree.get(lL) <= right) {
            tree.remove(lL);
            lL = tree.ceilingKey(left);
        }
        Integer sL = tree.floorKey(left);

        if (sL == null && lL == null) return;
        if (sL != null) {
            int sR = tree.get(sL);
            if (sR >= left) {
                tree.remove(sL);
                if (sL != left) tree.put(sL, left);
                if (sR > right) tree.put(right, sR);
            }
        }
        if (sL != lL && lL != null) {
            int lR = tree.get(lL);
            if (lL < right) {
                tree.remove(lL);
                if (lR > right) tree.put(right, lR);
            }
        }
        // System.out.println(tree);
    }
}
