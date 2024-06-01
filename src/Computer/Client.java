package Computer;

import static Computer.Shop.*;

public class Client extends Thread {
    int id;

    public Client(int id) {
        this.id = id;
    }

    public void run() {
        try {
            mutex.acquire();
            if (chairs > 0) {
                chairs--;
                customers.release();
                mutex.release();
                barbers.acquire();
                System.out.println("Клиен " + this.id + " взаимодействует с консультантом");
            } else {
                mutex.release();
                System.out.println("Клиент " + this.id + " не нашел свободных мест");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}