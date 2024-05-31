package Computer;

public class Main_lab3 {

    public static void main(String args[]) {
        // Создаем парикмахерскую с парикмахером
        Shop shopSim = new Shop();

        Thread barberThread = new Thread(shopSim.getBarber());
        barberThread.start();

        while(true) {
            Thread customerThread = new Thread(new Client(shopSim, "Посетитель "));
            customerThread.start();

            try {
                Thread.sleep( (int)(Math.random()*10000) );
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
