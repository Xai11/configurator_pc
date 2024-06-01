package Computer;

import Factory.Creator;
import Singleton.Characteristics;
import Singleton.NameComponents;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Shop {

    private Characteristics characteristics = Characteristics.getInstance();
    private NameComponents nameComponents = NameComponents.getInstance();
    static final Semaphore customers = new Semaphore(0);
    static final Semaphore barbers = new Semaphore(0);
    static final Semaphore mutex = new Semaphore(1);

    static int chairs = 5; // количество стульев в очереди

    static class Barber extends Thread {
        public void run() {
            while (true) {
                try {
                    customers.acquire();
                    mutex.acquire();
                    chairs++;
                    barbers.release();
                    mutex.release();
                    System.out.println("Консультант начал сборку");

                    Thread.sleep(5000); // время на стрижку
                    System.out.println("Консультант закончил сборку");
                    Creator creator = new Creator();
                    creator.createComputerRandom();
                    Characteristics characteristics = Characteristics.getInstance();
                    NameComponents nameComponents = NameComponents.getInstance();
                    nameComponents.SelectComputer();
                    characteristics.reset();
                    nameComponents.reset();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
