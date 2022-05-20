package Test.bingfa;

public class SequoiadbPrinter {
    public void sequoia() {
        for (int i = 0; i < 10; i++){
            System.out.print("Sequoia");
        }
    }
    public void db() {
        for (int i = 0; i < 10; i++) {
            System.out.println("DB");
        }
    }

// // 测试代码如下，请勿修改
// public static void main(String[] args) throws InterruptedException {
// SequoiadbPrinter sdb = new SequoiadbPrinter();
// Thread t1 = new Thread(sdb::sequoia);
// Thread t2 = new Thread(sdb::db);
// t1.start(); t2.start();
// t1.join(); t2.join();
// }
}