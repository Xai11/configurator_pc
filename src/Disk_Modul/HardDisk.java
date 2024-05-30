package Disk_Modul;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class HardDisk {
    private IHard_Disk diskOne;
    private IHard_Disk diskTwo;
    private IHard_Disk diskTree;
    private int count;
    public void newCreateHardDisk() throws FileNotFoundException {
        System.out.println("Сколько дисков вы хотите добавить(1, 2, 3): ");
        Scanner inputCon = new Scanner(System.in);
        String StringCount = inputCon.nextLine();
        count = Integer.parseInt(StringCount);
        if(count == 1){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDisk();
        } else if(count == 2){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDisk();
            diskTwo = new Hard_Disk_Two();
            diskTwo.newCreateHardDisk();
        }else if(count == 3){
            diskOne = new Hard_Disk_One();
            diskOne.newCreateHardDisk();
            diskTwo = new Hard_Disk_Two();
            diskTwo.newCreateHardDisk();
            diskTree = new Hard_Disk_Tree();
            diskTree.newCreateHardDisk();
        }

    }
}
