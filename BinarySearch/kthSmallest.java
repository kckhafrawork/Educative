
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class kthSmallest {
    public int kthSmallest(int[] arr, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        Set<Integer> sortedKeys = map.keySet();
        List<Integer> list = new ArrayList<>(sortedKeys);
        System.out.println(sortedKeys);
        return list.get(k - 1);
    }
}
