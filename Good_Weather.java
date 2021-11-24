
import java.util.*;

public class Good_Weather {

    public static void main(String[] args) {
        Scanner sys = new Scanner(System.in);

        int t = 0;
        if (sys.hasNext()) {
            t = sys.nextInt();
        }

        while (t-- > 0) {
            int[] days = new int[7];

            for (int i = 0; i < 7; i++) {
                days[i] = sys.nextInt();
            }
            int sunny = 0, rainy = 0;

            for (int i = 0; i < 7; i++) {
                if (days[i] == 1)
                    sunny++;
                else
                    rainy++;
            }

            if (sunny > rainy)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }

}