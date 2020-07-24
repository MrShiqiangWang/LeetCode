package history.pkg202007;

public class MyHashMap {

    private static class Node {

        int key;
        int value;
        Node next;

        public Node(final int key, final int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(final String[] args) {
        final MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2, 1);
        hashMap.get(2);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));

    }

    private final int DEFAULT_MIN_SIZE = 100;
    private int capacity;
    private final float loadFactor = 0.75f;
    int size;

    Node[] table;

    /** Initialize your data structure here. */
    public MyHashMap() {
        // 装填因子
        this.table = new Node[this.DEFAULT_MIN_SIZE];
        this.capacity = this.DEFAULT_MIN_SIZE;
    }

    public int get(final int key) {
        return this.getVal(this.hash(key), key);
    }

    public void put(final int key, final int value) {
        this.putVal(this.hash(key), key, value);
    }

    /**
     * Removes the mapping of the specified value key if this map contains a
     * mapping for the key
     */
    public void remove(final int key) {
        this.removeVal(this.hash(key), key);
    }

    private int getVal(final int hash, final int key) {
        int i;
        if (this.table[i = (hash & (this.capacity - 1))] == null) {
            return -1;
        }
        else if (this.table[i].key == key) {
            return this.table[i].value;
        }
        Node node = this.table[i];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    private int hash(final int key) {
        int h;
        final int hash = (h = Integer.valueOf(key).hashCode()) ^ (h >>> 16);
        return hash;
    }

    private void putVal(final int hash, final int key, final int value) {
        int i;
        if (this.table[i = (hash & (this.capacity - 1))] == null) {
            final Node node = new Node(key, value);
            this.table[i] = node;
        }
        else if (this.table[i].key == key) {
            this.table[i].value = value;
        }
        else if (this.table[i].key != key) {
            Node node2 = this.table[i];
            while (node2.next != null) {
                if (node2.key == key) {
                    node2.value = value;
                    return;
                }
                node2 = node2.next;
            }
            if (node2.key == key) {
                node2.value = value;
            }
            else {
                final Node node = new Node(key, value);
                node2.next = node;
            }
        }
        if (++this.size > this.loadFactor * this.capacity) {
            this.resize();
        }
    }

    private void removeVal(final int hash, final int key) {
        int i;
        if (this.table[i = (hash & (this.capacity - 1))] == null) {
            return;
        }
        if (this.table[i].key == key) {
            this.table[i] = this.table[i].next;
            return;
        }
        Node node = this.table[i];
        while (node.next != null) {
            if (node.next.key == key) {
                final Node tmp = node.next;
                node.next = node.next.next;
                tmp.next = null;
                return;
            }
            node = node.next;
        }
    }

    private void resize() {
        this.capacity = this.capacity << 1;
        final Node[] oldtable = this.table;
        final Node[] newTable = new Node[this.capacity];
        this.table = newTable;
        for (int i = 0; i < oldtable.length; i++) {
            if (oldtable[i] != null) {
                Node node = oldtable[i];
                while (node != null) {
                    this.put(node.key, node.value);
                    node = node.next;
                }
            }
        }

    }

}
