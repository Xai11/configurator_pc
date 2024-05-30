package Disk_Modul;

import Singleton.Director;
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
        Director director = new Director();
        if(count == 1){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDiskManual();
            nameComponents.addObserver(director);
            nameComponents.addHardDisk(diskOne.getName());

        } else if(count == 2){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDiskManual();
            diskTwo = new Hard_Disk_Two();
            diskTwo.newCreateHardDiskManual();
            nameComponents.addHardDisk(diskOne.getName());
            nameComponents.addObserver(director);
            nameComponents.addHardDisk(diskTwo.getName());
        }else if(count == 3){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDiskManual();
            diskTwo = new Hard_Disk_Two();
            diskTwo.newCreateHardDiskManual();
            diskTree = new Hard_Disk_Tree();
            diskTree.newCreateHardDiskManual();
            nameComponents.addHardDisk(diskOne.getName());

            nameComponents.addHardDisk(diskTwo.getName());
            nameComponents.addObserver(director);
            nameComponents.addHardDisk(diskTree.getName());
        }

    }
    public void newCreateHardDiskRandom() throws FileNotFoundException {
        Random rand = new Random();
        int randNumb = rand.nextInt(3) + 1;
        count = randNumb;
        NameComponents nameComponents = NameComponents.getInstance();
        Director director = new Director();
        if(count == 1){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDiskRandom();
            nameComponents.addObserver(director);
            nameComponents.addHardDisk(diskOne.getName());
        } else if(count == 2){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDiskRandom();
            diskTwo = new Hard_Disk_Two();
            diskTwo.newCreateHardDiskRandom();

            nameComponents.addHardDisk(diskOne.getName());
            nameComponents.addObserver(director);
            nameComponents.addHardDisk(diskTwo.getName());
        }else if(count == 3){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDiskRandom();
            diskTwo = new Hard_Disk_Two();
            diskTwo.newCreateHardDiskRandom();
            diskTree = new Hard_Disk_Tree();
            diskTree.newCreateHardDiskRandom();
            nameComponents.addHardDisk(diskOne.getName());
            nameComponents.addHardDisk(diskTwo.getName());
            nameComponents.addObserver(director);
            nameComponents.addHardDisk(diskTree.getName());
        }

    }
}
