package Components_computer;

import Confugurator.ComponentManual;
import Read_File.ReadFileBlockPower;
import Read_File.ReadFileMatherBoard;

import java.io.FileNotFoundException;

public class BlockPower extends ComponentManual {
    private String name;
    private int powerMax;
    public void newCreateBlockPower() throws FileNotFoundException {
        ReadFileBlockPower read = new ReadFileBlockPower();
        String[] fullName = read.ManualInput().split(";");
        name = fullName[0];
        powerMax = Integer.parseInt(fullName[1].split(" ")[0]);
        System.out.println("Создан блок питания");
    }
}
