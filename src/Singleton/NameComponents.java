package Singleton;

import java.util.ArrayList;
import java.util.List;

public class NameComponents {
    private static NameComponents instance = null;
    private List<Observer> observers = new ArrayList<Observer>();
    private String nameBlockPower;
    private String nameMatherBoard;
    private String nameProcessor;
    private String nameVideoCard;
    private String[] nameRAM;
    private List<String> nameHardDisk = new ArrayList<String>();
    public static NameComponents getInstance(){
        if(instance == null){
            instance = new NameComponents();
        }
        return instance;
    }
    public void notifyObservers(){
        for(Observer observer: observers){
            observer.event(nameHardDisk);
        }
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    public void addObserver(Observer observer){
        observers.add(observer);
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

//    public String[] getNameHardDisk() {
//        return nameHardDisk;
//    }

    public void addHardDisk(String name) {
        nameHardDisk.add(name);
        notifyObservers();
    }
    public void SelectComputer() {
        System.out.println("Процессор: " + this.nameProcessor + "\n" +
                "Материнская плата: " + nameMatherBoard);
        for (int i = 0; i < nameRAM.length; i++) {
            System.out.println("ОЗУ №" + (i + 1) + ": " + nameRAM[i]);
        }
        System.out.println("Видеокарта: " + nameVideoCard + "\n" +
                "Блок питания: " + nameBlockPower);
        for (int i = 0; i < nameHardDisk.size(); i++) {
            System.out.println("Жесткий диск №" + (i + 1) + ": " + nameHardDisk.get(i));
        }
    }
}
