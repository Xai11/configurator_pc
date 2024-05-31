package Computer;

import Factory.Creator;
import Singleton.Characteristics;
import Singleton.NameComponents;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

public class Shop {
    Creator creator = new Creator();
    Characteristics ch = Characteristics.getInstance();

    NameComponents nc = NameComponents.getInstance();
    // Количество мест в приемной
    public static final int NUM_CHAIRS = 3;

    // Количество рабочих мест(парикмахеров)
    public static final int NUM_WORKSPACES = 1;

    // Время одной стрижки в мс
    public static final int WORK_TIME = 10000;

    // Рабочее место парикмахера
    private Client barberWorkspace;

    private enum BarberState {
        SLEEP, WORK, NOTHING
    }

    // Состояние парикмахера
    BarberState stateFlag;

    // Количетсво обслуженных клиентов
    private int customersCount;

    // Количество необслужанных клиентов
    private int leftCustomersCount;

    // Парикмахер
    private Barber barberMan;

    // Места в приемной
    private Queue<Client> clientList = new LinkedList<Client>();

    public Shop() {
        customersCount = 0;
        leftCustomersCount = 0;

        barberMan = new Barber();
    }

    //=============================================
    // Методы управления данными
    //=============================================
    public Queue<Client> getCustomerList() {
        return clientList;
    }
    //---------------------------------------------
    public Barber getBarber() {
        return barberMan;
    }
    //=============================================
    // Методы посетителей
    //=============================================
    // Занять место в приемной посетителем если есть свободные, возвращает true если удалось
    private void sitInWaitingRoom(Client client) {
        if( clientList.size() < NUM_CHAIRS ) {
            clientList.add(client);
            System.out.println(client.getCustomerName() + " занял место в очереди\n");
        } else {
            leftCustomersCount++;
            System.out.println(client.getCustomerName() + " ушел из магазина, так как большая очередь, количество необслужанных клиентов: "+ leftCustomersCount + "\n");
        }
    }
    //---------------------------------------------
    // Разбудить парикмахера и сесть на рабочее место если парикмахер спит
    public synchronized void sitInWorkspace(Client client) {
        if( checkBarber(client) == BarberState.SLEEP ) {
            System.out.println(client.getCustomerName() + " обратился к консультанту за сборкой\n");
            barberWorkspace = client;
            stateFlag = BarberState.WORK;
        } else {
            sitInWaitingRoom(client);
        }

        try {
            notify();
            wait();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

    }
    //---------------------------------------------
    // Проверка состояния парикмахера со стороны клиента
    // 0 - sleep
    // 1 - work
    public BarberState checkBarber(Client client) {
        System.out.print(client.getCustomerName() + " проверяет занятость консультанта:");

        if( stateFlag == BarberState.SLEEP ){
            System.out.println(" Консультант свободен\n");
        } else {
            System.out.println(" Консультант обслуживает клиента\n");
        }

        return stateFlag;
    }
    //=============================================
    // Методы парикмахера
    //=============================================
    // Проверка наличия посетителей со стороны парикмахера
    public synchronized boolean checkCustomers() {
        System.out.printf("Консультант проверяет наличие клиентов: В очереди %d из %d\n\n", clientList.size(), NUM_CHAIRS);
        return !clientList.isEmpty();
    }
    //---------------------------------------------
    public synchronized void work() throws FileNotFoundException {
        while( isWorkspaceEmpty() ) {
            try {
                sleep();
                wait();
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        while( !isWorkspaceEmpty() ) {
            if( stateFlag != BarberState.WORK)
                stateFlag = BarberState.WORK;

            System.out.printf("Консультант подбирает сборку компьютера клиенту: %s\n\n", barberWorkspace.getCustomerName());
            creator.createComputerRandom();
            try {
                wait(WORK_TIME);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Консультант закончил сборку клиенту: %s\n\n", barberWorkspace.getCustomerName());
            System.out.println(" ");
            nc.SelectComputer();
            ch.reset();
            nc.reset();
            customersCount++;
            stateFlag = BarberState.NOTHING;
            resetBarberWorkspace();
            callCustomer();
        }
    }
    //---------------------------------------------
    public synchronized void sleep() {
        if( stateFlag != BarberState.SLEEP ) {
            stateFlag = BarberState.SLEEP;

            System.out.println("Консультант свободен\n");
        }
    }
    //---------------------------------------------
    private boolean isWorkspaceEmpty() {
        return barberWorkspace == null;
    }
    //---------------------------------------------
    private void resetBarberWorkspace() {
        barberWorkspace = null;
    }
    //---------------------------------------------
    // Позвать клиента из очереди в приемной если есть, иначе спать, возвращает true если удалось
    private synchronized void callCustomer() {
        if( checkCustomers() ) {
            barberWorkspace = clientList.poll();
        }
    }
    //---------------------------------------------
    // Класс парикмахер
    public class Barber implements Runnable {
        public Barber() {
            stateFlag = BarberState.NOTHING;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    work();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
