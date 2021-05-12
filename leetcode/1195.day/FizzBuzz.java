import java.util.concurrent.Semaphore;

// 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：

// 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
// 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
// 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
// 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。

class FizzBuzz {
    private int n;
    private int cur;

    private final Semaphore fizzSemaphore = new Semaphore(0);
    private final Semaphore buzzSemaphore = new Semaphore(0);
    private final Semaphore fizzBuzzSemaphore = new Semaphore(0);
    private final Semaphore otherSemaphore = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
        this.cur = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            fizzSemaphore.acquire();
            if (cur > n) {
                break;
            }
            printFizz.run();
            otherSemaphore.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            buzzSemaphore.acquire();
            if (cur > n) {
                break;
            }
            printBuzz.run();
            otherSemaphore.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            fizzBuzzSemaphore.acquire();
            if (cur > n) {
                break;
            }
            printFizzBuzz.run();
            otherSemaphore.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (cur <= n) {
            if (cur % 3 == 0 && cur % 5 == 0) {
                fizzBuzzSemaphore.release();
            } else if (cur % 3 == 0) {
                fizzSemaphore.release();
            } else if (cur % 5 == 0) {
                buzzSemaphore.release();
            } else {
                printNumber.accept(cur);
                otherSemaphore.release();
            }
            otherSemaphore.acquire();
            cur++;
        }
        fizzBuzzSemaphore.release();
        fizzSemaphore.release();
        buzzSemaphore.release();
    }
}

// class FizzBuzz {
// private int n;
// private Integer curr;
// private final Semaphore isFizz;
// private final Semaphore isBuzz;
// private final Semaphore isFizzBuzz;
// private final Semaphore other;

// public FizzBuzz(int n) {
// this.n = n;
// this.curr = 1;
// this.isBuzz = new Semaphore(0);
// this.isFizz = new Semaphore(0);
// this.isFizzBuzz = new Semaphore(0);
// this.other = new Semaphore(0);
// }

// // printFizz.run() outputs "fizz".
// public void fizz(Runnable printFizz) throws InterruptedException {
// while (true) {
// //System.out.println("isFizz wait" + curr);
// isFizz.acquire();
// if (curr > n) {
// break;
// }
// //System.out.println("isFizz run" + curr);
// printFizz.run();
// other.release();
// }
// }

// // printBuzz.run() outputs "buzz".
// public void buzz(Runnable printBuzz) throws InterruptedException {
// while (true) {
// //System.out.println("isBuzz wait" + curr);
// isBuzz.acquire();
// if (curr > n) {
// break;
// }
// //System.out.println("isBuzz run" + curr);
// printBuzz.run();
// other.release();
// }
// }

// // printFizzBuzz.run() outputs "fizzbuzz".
// public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
// while (true) {
// //System.out.println("isFizzBuzz wait" + curr);
// isFizzBuzz.acquire();
// if (curr > n) {
// break;
// }
// //System.out.println("isFizzBuzz run" + curr);
// printFizzBuzz.run();
// other.release();
// }
// }

// // printNumber.accept(x) outputs "x", where x is an integer.
// public void number(IntConsumer printNumber) throws InterruptedException {
// while (curr <= n) {
// //System.out.println("Number wait" + curr);
// if (curr % 3 == 0 && curr % 5 == 0) {
// //System.out.println("Number -> FizzBuzz" + curr);
// isFizzBuzz.release();
// } else if (curr % 3 == 0) {
// //System.out.println("Number -> Fizz" + curr);
// isFizz.release();
// } else if (curr % 5 == 0) {
// //System.out.println("Number -> Buzz" + curr);
// isBuzz.release();
// } else {
// //System.out.println("Number run" + curr);
// printNumber.accept(curr);
// other.release();
// }
// other.acquire();
// curr++;
// }
// isFizzBuzz.release();
// isFizz.release();
// isBuzz.release();
// }
// }
