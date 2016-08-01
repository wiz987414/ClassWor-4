import java.util.HashMap;
import java.util.Map;

public class CountMapPrototype<T> implements CountMap<T> {

    private Map<T, Integer> internalMap = new HashMap<T, Integer>();

    @Override
    public void add(T value) {
        if (value != null && this.internalMap.containsKey(value)) {
            this.internalMap.put(value, this.internalMap.get(value) + 1);
        } else this.internalMap.put(value, 1);
    }

    @Override
    public int getCount(T value) {
        return this.internalMap.get(value);
    }

    @Override
    public int remove(T value) {
        int status = 0;
        if (value != null && this.internalMap.containsKey(value)) {
            status = this.getCount(value);
            this.internalMap.remove(value);
        }
        return status;
    }

    @Override
    public int size() {
        return this.internalMap.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        Map<T, Integer> hm = new HashMap<>();
        source.toMap(hm);
        for (Map.Entry<T, Integer> element : hm.entrySet()) {
            if (this.internalMap.containsKey(element.getKey()))
                this.internalMap.put(element.getKey(), this.internalMap.get(element.getKey()) + element.getValue());
            else this.internalMap.put(element.getKey(), element.getValue());
        }
    }


    @Override
    public void toMap(Map<? super T, Integer> destination) {
        for (Map.Entry<T, Integer> element : this.internalMap.entrySet()) {
            destination.put(element.getKey(), element.getValue());
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        Map<T, Integer> resultMap = this.internalMap;
        return resultMap;
    }

    void valueOut(T value) {
        if (value != null && this.internalMap.containsKey(value))
            System.out.println(value + " added in map " + this.getCount(value) + " times");
        else System.out.println();
    }

    void showMap() {
        for (Map.Entry element : this.internalMap.entrySet())
            System.out.println(element.getKey() + " - " + element.getValue());
    }
}
