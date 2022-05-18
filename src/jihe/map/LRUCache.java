package jihe.map;

import java.util.Map;
import java.util.LinkedHashMap;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int DEFAULT_NODE_NUM = 11; //默认缓存值
    private int capacityLimit; //缓存限定值

    public LRUCache() {
        this(DEFAULT_NODE_NUM);
    }

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); //依次：初始容量、负载因子、采用访问排序
        this.capacityLimit = capacity;
    }

    public V putKV(K key, V val) {
        return put(key, val);
    }

    public V getValue(K key) {
        return get(key);
    }

    public boolean exists(K key) {
        return containsKey(key);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacityLimit;  //如果LinkedHashMap的长度到达缓存容量，进行清除
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache();
        for (int i = 0; i < 11; i++) {
            cache.putKV(i, i);
        }
        System.out.println(cache);
        cache.getValue(7);
        System.out.println(cache);
        cache.getValue(5);
        System.out.println(cache);
        cache.putKV(10, 9);  //覆盖掉原来的(10,10),此时缓存容量依旧够用
        System.out.println(cache);
        //再多增加一个节点
        cache.putKV(11, 11);
        System.out.println(cache);  //此时缓存中数据已经发生变化，移除掉了链表的头结点
    }
}