package Computer;

public class Main_lab3 {

    public static void main(String[] args) {
        Shop.Barber barber = new Shop.Barber();
        barber.start();
        int count = 0;
        while(true) {
            count++;
            Client customer = new Client(count);
            customer.start();
            try {
                Thread.sleep(1000); // время между приходом клиентов
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
//        for (int i = 0; i < 10; i++) {
//            Client customer = new Client(i);
//            customer.start();
//            try {
//                Thread.sleep(1000); // время между приходом клиентов
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }


