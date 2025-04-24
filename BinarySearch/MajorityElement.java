
import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int arr[]) {
        // your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.get(arr[i]) != null ? map.get(arr[i]) + 1 : 1);
            if (map.get(arr[i]) > arr.length / 2) {
                return arr[i];
            }
        }

        return -1;
    }
}
