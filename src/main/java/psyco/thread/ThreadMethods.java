package psyco.thread;

/**
 * Created by lipeng on 15/9/10.
 */
public class ThreadMethods {
    static class MyThread extends Thread {
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {  //如果线程没有被中断就继续运行
                    //阻塞代码：sleep,wait等
                    //当其他线程，调用此线程的interrupt()方法时，会给此线程设置一个中断标志
                    //sleep,wait等方法会检测这个标志位，同时会抛出InterruptedException，并清除线程的中断标志
                    //因此在异常段调用Thread.currentThread().isInterrupted()返回为false
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                //由于阻塞库函数，如：Object.wait,Thread.sleep除了抛出异常外，还会清除线程中断状态，因此可能在这里要保留线程的中断状态
//                Thread.currentThread().interrupt();//从新设置线程的中断标志
                System.out.println("finished");
            }
        }

        public void cancel() {
            interrupt();  //中断线程
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        //让它先启动
        Thread.sleep(1000);
        thread.cancel();
    }

}
