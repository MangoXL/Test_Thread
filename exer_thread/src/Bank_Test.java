//线程安全的懒汉式
public class Bank_Test {
    public static void main(String[] args) {

    }
}

class Bank{
    private Bank(){

    }
    private static Bank bank = null;
    public static Bank getInstance(){
        if(bank == null){
            synchronized(Bank.class){
                if(bank == null){
                    bank = new Bank();
                }
            }
        }
        return bank;
    }

    /*将此方法声明为一个同步方法，此时的监视器是Bank.class，但是该方法效率上差一些
    public synchronized static Bank getInstance(){
        if(bank == null){
           bank = new Bank();
        }
        return bank;
    }*/
}
