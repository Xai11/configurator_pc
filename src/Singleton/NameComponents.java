package Singleton;

public class NameComponents {
    private static NameComponents instance = null;
    private String nameBlockPower;
    private String nameMatherBoard;
    private String nameProcessor;
    private String nameVideoCard;
    private String[] nameRAM;
    private String[] nameHardDisk;
    public static NameComponents getInstance(){
        if(instance == null){
            instance = new NameComponents();
        }
        return instance;
    }

    public String getNameBlockPower() {
        return nameBlockPower;
    }

    public void setNameBlockPower(String nameBlockPower) {
        this.nameBlockPower = nameBlockPower;
    }

    public String getNameMatherBoard() {
        return nameMatherBoard;
    }

    public void setNameMatherBoard(String nameMatherBoard) {
        this.nameMatherBoard = nameMatherBoard;
    }

    public String getNameProcessor() {
        return nameProcessor;
    }

    public void setNameProcessor(String nameProcessor) {
        this.nameProcessor = nameProcessor;
    }

    public String getNameVideoCard() {
        return nameVideoCard;
    }

    public void setNameVideoCard(String nameVideoCard) {
        this.nameVideoCard = nameVideoCard;
    }

    public String[] getNameRAM() {
        return nameRAM;
    }

    public void setNameRAM(String[] nameRAM) {
        this.nameRAM = nameRAM;
    }

    public String[] getNameHardDisk() {
        return nameHardDisk;


    }

    public void setNameHardDisk(String[] nameHardDisk) {
        this.nameHardDisk = nameHardDisk;

    }

    public void SelectComputer() {
        System.out.println("Процессор: " + this.nameProcessor + "\n" +
                "Материнская плата: " + nameMatherBoard);
        for (int i = 0; i < nameRAM.length; i++) {
            System.out.println("ОЗУ №" + (i + 1) + ": " + nameRAM[i]);
        }
        System.out.println("Видеокарта: " + nameVideoCard + "\n" +
                "Блок питания: " + nameBlockPower);
        for (int i = 0; i < nameHardDisk.length; i++) {
            System.out.println("Жесткий диск №" + (i + 1) + ": " + nameHardDisk[i]);
        }
    }
}
