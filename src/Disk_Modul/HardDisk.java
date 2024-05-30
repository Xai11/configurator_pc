package Disk_Modul;

import Singleton.NameComponents;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class HardDisk {
    private Hard_Disk_One diskOne;
    private Hard_Disk_Two diskTwo;
    private Hard_Disk_Tree diskTree;
    private int count;
    public void newCreateHardDiskManual() throws FileNotFoundException {
        System.out.println("Сколько дисков вы хотите добавить(1, 2, 3): ");
        Scanner inputCon = new Scanner(System.in);
        String StringCount = inputCon.nextLine();
        count = Integer.parseInt(StringCount);
        NameComponents nameComponents = NameComponents.getInstance();
        if(count == 1){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDiskManual();
            String[] temp1 = {diskOne.getName()};
            nameComponents.setNameHardDisk(temp1);
        } else if(count == 2){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDiskManual();
            diskTwo = new Hard_Disk_Two();
            diskTwo.newCreateHardDiskManual();
            String[] temp1 = {diskOne.getName(), diskTwo.getName()};
            nameComponents.setNameHardDisk(temp1);
        }else if(count == 3){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDiskManual();
            diskTwo = new Hard_Disk_Two();
            diskTwo.newCreateHardDiskManual();
            diskTree = new Hard_Disk_Tree();
            diskTree.newCreateHardDiskManual();
            String[] temp1 = {diskOne.getName(), diskTwo.getName(), diskTree.getName()};
            nameComponents.setNameHardDisk(temp1);
        }

    }
    public void newCreateHardDiskRandom() throws FileNotFoundException {
        Random rand = new Random();
        int randNumb = rand.nextInt(2) + 1;
        count = randNumb;
        NameComponents nameComponents = NameComponents.getInstance();
        if(count == 1){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDiskRandom();
            String[] temp1 = {diskOne.getName()};
            nameComponents.setNameHardDisk(temp1);
        } else if(count == 2){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDiskRandom();
            diskTwo = new Hard_Disk_Two();
            diskTwo.newCreateHardDiskRandom();
            String[] temp1 = {diskOne.getName(), diskTwo.getName()};
            nameComponents.setNameHardDisk(temp1);
        }else if(count == 3){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDiskRandom();
            diskTwo = new Hard_Disk_Two();
            diskTwo.newCreateHardDiskRandom();
            diskTree = new Hard_Disk_Tree();
            diskTree.newCreateHardDiskRandom();
            String[] temp1 = {diskOne.getName(), diskTwo.getName(), diskTree.getName()};
            nameComponents.setNameHardDisk(temp1);
        }

    }
}
