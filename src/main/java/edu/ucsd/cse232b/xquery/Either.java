package edu.ucsd.cse232b.xquery;

public class Either<T1,T2> {
    public T1 left;
    public T2 right;

    public Either() {
    }

    public Either(T1 left, T2 right) {
        this.left = left;
        this.right = right;
    }
}
