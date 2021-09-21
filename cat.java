import java.util.*;
import java.io.*;

public class cat {

    class Solution {
        public int furthestBuilding(int[] height, int bricks, int ladders) {
            // u want to use ladder to cover the max height

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                return b - a;
            });

            for (int i = 0; i < height.length - 1; i++) {
                if (height[i + 1] <= height[i])
                
                    continue;
                if (height[i + 1] > height[i]) {
                    if (bricks >= (height[i + 1] - height[i])) {
                        bricks -= (height[i + 1] - height[i]);
                        pq.add(height[i + 1] - height[i]);
                    }
                } else {
                    if (ladders == 0) {
                        return i;
                    } else {
                        if (pq.size() > 0) {
                            if (pq.peek() < (height[i + 1] - height[i])) {
                                ladders--;
                            } else {
                                bricks += pq.peek();
                                ladders--;
                                bricks -= (height[i + 1] - height[i]);
                                pq.add(height[i + 1] - height[i]);
                            }
                        } else
                            ladders--;
                    }
                }
            }
            return height.length;
        }

    }

    public static void main(String[] args) throws IOException {

        Scanner sys = new Scanner(System.in);

    }
}