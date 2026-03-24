
class X {
    public X() {
    }

    @Override
    public String toString() {
        return "I'm X";
    }
}

class Y extends X {
    public Y() {
        super();
    }

    @Override
    public String toString() {
        return "I'm Y";
    }
}

class A {
    public A() {
    }

    public void foo(X a) {
        System.out.println(
                "A -> foo(X): " + a);
    }

    public void foo(Y a) {
        System.out.println(
                "A -> foo(Y): " + a);
    }
}

class B extends A {
    public B() {
        super();
    }

    @Override
    public void foo(X a) {
        System.out.println(
                "B -> foo(X): " + a);
    }

    @Override
    public void foo(Y a) {
        System.out.println(
                "B -> foo(Y): " + a);
    }
}

class Test {
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        X z = new Y(); // !!

        A a = new A();
        B b = new B();
        A c = new B(); // !!

        a.foo(x);
        a.foo(y);
        a.foo(z);

        b.foo(x);
        b.foo(y);
        b.foo(z);

        c.foo(x);
        c.foo(y);
        c.foo(z);
    }

}

