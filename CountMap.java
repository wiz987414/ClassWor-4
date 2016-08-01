import java.util.Map;

public interface CountMap<E> {
    void add(E value);

    int getCount(E value);

    int remove(E value);

    int size();

    void addAll(CountMap<? extends E> source);

    void toMap(Map<? super E, Integer> destination);

    Map toMap();
}
