public class KVBox<K, V> {
    private K key;
    private V value;

    public KVBox(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void showType() {
        System.out.printf("Type of key is %s, key = %s, " + "type of value is %s, value = %s\n",
                key.getClass().getName(), getKey(), value.getClass().getName(), getValue());
    }

    public static void main(String[] args) {
        KVBox<Integer, String> kvb0 = new KVBox<>(1, "Hello!");
        KVBox<String, GBox<String>> kvb1 = new KVBox<>("World", new GBox<>("Java"));
        kvb0.showType();
        // Type of key is java.lang.Integer, key = 1, type of value is java.lang.String, value = Hello!
        kvb1.showType();
        // Type of key is java.lang.String, key = World, type of value is GBox, value = GBox@85ede7b
    }
}

