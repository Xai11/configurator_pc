package Disk_Modul;

import java.io.FileNotFoundException;

public interface IHard_Disk {
    public void newCreateHardDiskManual() throws FileNotFoundException;
    public void newCreateHardDiskRandom() throws FileNotFoundException;
}
