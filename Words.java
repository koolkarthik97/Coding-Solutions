import java.util.Arrays;
import java.util.HashMap;

public class Words {
    HashMap<Integer, String> map;

    public Words() {
        map = new HashMap<>();
        map.put(1, "One Pence");
        map.put(2, "Two Pence");
        map.put(5, "Five Pence");
        map.put(10, "Ten Pence");
        map.put(20, "Twenty Pence");
        map.put(50, "Fifty Pence");
        map.put(100, "One Pound");
        map.put(200, "Two Pounds");
        map.put(500, "Five Pounds");
        map.put(1000, "Ten Pounds");
        map.put(2000, "Twenty Pounds");
        map.put(5000, "Fifty Pounds");
    }

    public void printWords(int[] denominations) {
        Arrays.sort(denominations);
        for (int i = denominations.length - 1; i >= 0; i--) {
            System.out.print(map.get(denominations[i]));
            if (i != 0)
                System.out.print(", ");
        }
    }
}
