class Bitset {
    int[] bits;
    int oneCount;
    int size;
    boolean flip;

    public Bitset(int size) {
        this.size = size;
        this.bits = new int[size];
        this.oneCount = 0;
        this.flip=false;
    }

    public void fix(int idx) {
        int bit = bits[idx];
        if (flip) {
            if (bit == 1) {
                bits[idx] = 0;
                oneCount++;
            }
        } else {
            if (bit == 0) {
                bits[idx] = 1;
                oneCount++;
            }
        }
    }

    public void unfix(int idx) {
        int bit = bits[idx];
        if (flip) {
            if (bit == 0) {
                bits[idx] = 1;
                oneCount--;
            }
        } else {
            if (bit == 1) {
                bits[idx] = 0;
                oneCount--;
            }
        }
    }

    public void flip() {
        oneCount=size-oneCount;
        flip=!flip;
    }

    public boolean all() {
        return oneCount == size ? true : false; 
    }

    public boolean one() {
        return oneCount > 0 ? true : false;
    }

    public int count() {
        return oneCount;
    }

    public String toString() {
      
        StringBuilder sb=new StringBuilder();
        for(int i=size-1;i>=0;i--){
            sb.append(flip?(1-bits[i]):bits[i]);
        }
        return new String(sb.reverse());
    }
}
/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
