package Disk_Modul;

import Read_File.ReadFileBlockPower;
import Read_File.ReadFileHardDisk;

import java.io.FileNotFoundException;

public class Hard_Disk_One implements IHard_Disk {
    private String name;
    private int memory;

    public void newCreateHardDisk() throws FileNotFoundException {
        ReadFileHardDisk read = new ReadFileHardDisk();
        String[] fullName = read.ManualInput().split(";");
        name = fullName[0];
        memory = Integer.parseInt(fullName[1].split(" ")[0]);
        System.out.println("Создан жесткий диск");
    }
}
