package Components_computer;

import Confugurator.ComponentManual;
import Read_File.ReadFileBlockPower;
import Read_File.ReadFileMatherBoard;
import Singleton.NameComponents;

import java.io.FileNotFoundException;

public class BlockPower extends ComponentManual {
    private String name;
    private int powerMax;
    public void newCreateBlockPowerManual() throws FileNotFoundException {
        ReadFileBlockPower read = new ReadFileBlockPower();
        String[] fullName = read.ManualInput().split(";");
        name = fullName[0];
        powerMax = Integer.parseInt(fullName[1].split(" ")[0]);
        NameComponents nameComponents = NameComponents.getInstance();
        nameComponents.setNameBlockPower(name);
        System.out.println("Создан блок питания");
    }
    public void newCreateBlockPowerRandom() throws FileNotFoundException {
        ReadFileBlockPower read = new ReadFileBlockPower();
        String[] fullName = read.RandomInput().split(";");
        name = fullName[0];
        powerMax = Integer.parseInt(fullName[1].split(" ")[0]);
        NameComponents nameComponents = NameComponents.getInstance();
        nameComponents.setNameBlockPower(name);
        System.out.println("Создан блок питания");
    }

    public String getName() {
        return name;
    }
}
