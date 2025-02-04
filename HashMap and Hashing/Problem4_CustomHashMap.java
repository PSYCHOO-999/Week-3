
import java.util.LinkedList;

class Problem4_CustomHashMap<K, V> {
    private static final int SIZE = 10;
    private LinkedList<Entry<K, V>>[] map;

    public Problem4_CustomHashMap() {
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int index = key.hashCode() % SIZE;
        for (Entry<K, V> entry : map[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        map[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = key.hashCode() % SIZE;
        for (Entry<K, V> entry : map[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = key.hashCode() % SIZE;
        map[index].removeIf(entry -> entry.key.equals(key));
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Problem4_CustomHashMap<String, Integer> map = new Problem4_CustomHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        System.out.println(map.get("A")); // 1
        map.remove("A");
        System.out.println(map.get("A")); // null
    }
}
