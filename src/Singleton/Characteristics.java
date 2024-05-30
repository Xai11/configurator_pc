package Singleton;

public class Characteristics {
    private static Characteristics instance = null;
    private String socket = "0";
    private String DDR = "0";
    private int powerMax = 0;
    private int countSlot = 0;
    private Characteristics(){}
    public static Characteristics getInstance(){
        if(instance == null){
            instance = new Characteristics();
        }
        return instance;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getDDR() {
        return DDR;
    }

    public void setDDR(String DDR) {
        this.DDR = DDR;
    }

    public int getPowerMax() {
        return powerMax;
    }

    public void setPowerMax(int powerMax) {
        this.powerMax += powerMax;
    }

    public int getCountSlot() {
        return countSlot;
    }

    public void setCountSlot(int countSlot) {
        this.countSlot = countSlot;
    }
}
