package leetcode.easy;

import java.util.concurrent.atomic.AtomicInteger;

public class L_1114 {

    AtomicInteger i = new AtomicInteger(0);


//    public Foo() {
//
//    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.

        for (;;) {
            if (i.compareAndSet(0, 1)) {
                printFirst.run();
                break;
            }
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        for (;;) {
            if (i.compareAndSet(1, 2)) {
                printSecond.run();
                break;
            }
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        for (;;) {
            if (i.compareAndSet(2, 3)) {
                printThird.run();
                break;
            }
        }
    }
}
