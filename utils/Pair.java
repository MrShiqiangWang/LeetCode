package utils;

public class Pair<T, K> {

    private T left;

    private K right;

    public T getLeft() {
        return left;
    }

    public K getRight() {
        return right;
    }

    public Pair(T left, K right) {
        this.left = left;
        this.right = right;
    }

    public static <T, K> Pair<T, K> of(T left, K right) {
        Pair<T, K> pair = new Pair<>(left, right);
        return pair;
    }
}
