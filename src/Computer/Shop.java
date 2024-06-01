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
    public static final int NUM_Client = 3;

    // Количество рабочих мест(консультантов)
    public static final int NUM_WORKSPACES = 1;

    // Время одной сборки в мс
    public static final int WORK_TIME = 10000;

    // Рабочее место консультанта
    private Client ConsWorkspace;

    private enum ConsState {
        SLEEP, WORK, NOTHING
    }

    // Состояние Консультанта
    ConsState stateFlag;

    // Количетсво обслуженных клиентов
    private int clientCount;

    // Количество необслужанных клиентов
    private int leftClientCount;

    // Консультант
    private Cons consMan;

    // Места в приемной
    private Queue<Client> clientList = new LinkedList<Client>();

    public Shop() {
        clientCount = 0;
        leftClientCount = 0;

        consMan = new Cons();
    }

    //=============================================
    // Методы управления данными
    //=============================================
    public Queue<Client> getCustomerList() {
        return clientList;
    }
    //---------------------------------------------
    public Cons getCons() {
        return consMan;
    }
    //=============================================
    // Методы посетителей
    //=============================================
    // Занять место в приемной посетителем если есть свободные, возвращает true если удалось
    private void sitInWaitingRoom(Client client) {
        if( clientList.size() < NUM_Client ) {
            clientList.add(client);
            System.out.println(client.getClientName() + " занял место в очереди\n");
        } else {
            leftClientCount++;
            System.out.println(client.getClientName() + " ушел из магазина, так как большая очередь, количество необслужанных клиентов: "+ leftClientCount + "\n");
        }
    }
    //---------------------------------------------
    // Разбудить парикмахера и сесть на рабочее место если парикмахер спит
    public synchronized void sitInWorkspace(Client client) {
        if( checkCons(client) == ConsState.SLEEP ) {
            System.out.println(client.getClientName() + " обратился к консультанту за сборкой\n");
            ConsWorkspace = client;
            stateFlag = ConsState.WORK;
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
    public ConsState checkCons(Client client) {
        System.out.print(client.getClientName() + " проверяет занятость консультанта:");

        if( stateFlag == ConsState.SLEEP ){
            System.out.println(" Консультант свободен\n");
        } else {
            System.out.println(" Консультант обслуживает клиента\n");
        }

        return stateFlag;
    }
    //=============================================
    // Методы консультанта
    //=============================================
    // Проверка наличия посетителей со стороны консультанта
    public synchronized boolean checkCustomers() {
        System.out.printf("Консультант проверяет наличие клиентов: В очереди %d из %d\n\n", clientList.size(), NUM_Client);
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
            if( stateFlag != ConsState.WORK)
                stateFlag = ConsState.WORK;

            System.out.printf("Консультант подбирает сборку компьютера клиенту: %s\n\n", ConsWorkspace.getClientName());
            creator.createComputerRandom();
            try {
                wait(WORK_TIME);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Консультант закончил сборку клиенту: %s\n\n", ConsWorkspace.getClientName());
            System.out.println(" ");
            nc.SelectComputer();
            ch.reset();
            nc.reset();
            clientCount++;
            stateFlag = ConsState.NOTHING;
            resetConsWorkspace();
            callCustomer();
        }
    }
    //---------------------------------------------
    public synchronized void sleep() {
        if( stateFlag != ConsState.SLEEP ) {
            stateFlag = ConsState.SLEEP;

            System.out.println("Консультант свободен\n");
        }
    }
    //---------------------------------------------
    private boolean isWorkspaceEmpty() {
        return ConsWorkspace == null;
    }
    //---------------------------------------------
    private void resetConsWorkspace() {
        ConsWorkspace = null;
    }
    //---------------------------------------------
    // Позвать клиента из очереди в приемной если есть, иначе спать, возвращает true если удалось
    private synchronized void callCustomer() {
        if( checkCustomers() ) {
            ConsWorkspace = clientList.poll();
        }
    }
    //---------------------------------------------
    // Класс консультант
    public class Cons implements Runnable {
        public Cons() {
            stateFlag = ConsState.NOTHING;
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
