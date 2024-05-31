package Computer;

public class BarbaerShopTest {

    public static void main(String args[]) {
        // Создаем парикмахерскую с парикмахером
        BarberShop barberShopSim = new BarberShop();

        Thread barberThread = new Thread(barberShopSim.getBarber());
        barberThread.start();

        while(true) {
            Thread customerThread = new Thread(new Client(barberShopSim, "Посетитель "));
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
