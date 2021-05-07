public class FooBar {
    private int n;
    private volatile boolean finish = false;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(finish){
                Thread.yield();
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            finish = true;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(!finish){
                Thread.yield();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            finish = false;
        }
    }
}
