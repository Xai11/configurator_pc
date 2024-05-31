package Computer;

public class Client implements Runnable {
    // Номер посетителя
    private static int id = 1;

    // Имя посетителя
    private String customerName;

    // Парикмахерская
    private Shop shop;

    public Client(Shop bShop, String name) {
        customerName = name + id;
        shop = bShop;
        id++;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void run() {
        shop.sitInWorkspace(this);
    }
}