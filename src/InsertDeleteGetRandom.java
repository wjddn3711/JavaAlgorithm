import java.util.*;

class RandomizedSet {
    Random random;
    Map<Integer, Integer> map;
    ArrayList<Integer> nums;
    int size;
    public RandomizedSet(){
        random = new Random();
        map = new HashMap<>(); // key-숫자, value-인덱스
        nums = new ArrayList<>();
        size = 0;
    }

    public boolean insert(int val){
        // inserts an item val into the set if not present
        // returns true if the item was present, else false
        if (map.containsKey(val)){
            return false;
        }
        else{
            nums.add(val); // add to array
            map.put(val, ++size); // add current size
            return true;
        }
    }

    public boolean remove (int val){
        // removes an item val from the set if present. returns true if the item was present, else false
        if (map.containsKey(val)){
            int idx = map.get(val); // 현재 인덱스
            map.remove(val); // map 에서 제거해준다

            if(idx != val){
                int swap = nums.get(size-1);
                nums.set(idx,swap);
                map.put(swap,idx);
            }
            nums.remove(--size); // nums 에서 현재 인덱스를 제거해준다
            return true;
        }
        else{
            return false;
        }
    }

    public int getRandom(){
        // returns a random element
        int idx = random.nextInt(size);
        return nums.get(idx);
    }
}

public class InsertDeleteGetRandom {

}
