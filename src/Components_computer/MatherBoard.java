package Components_computer;

import Confugurator.ComponentManual;
import Read_File.ReadFileMatherBoard;
import Read_File.ReadFileProcessor;
import Singleton.Characteristics;
import Singleton.NameComponents;

import java.io.FileNotFoundException;

public class MatherBoard extends ComponentManual {
    private String name;
    private String socket;
    private int countSlot;
    private String DDR;
    public void newCreateMatherBoardManual() throws FileNotFoundException {
        ReadFileMatherBoard read = new ReadFileMatherBoard();
        String[] fullName = read.ManualInput().split(";");
        name = fullName[0];
        socket = fullName[1];
        countSlot = Integer.parseInt(fullName[2].split(" ")[0]);
        DDR = fullName[3];
        Characteristics characteristics = Characteristics.getInstance();
        characteristics.setCountSlot(countSlot);
        NameComponents nameComponents = NameComponents.getInstance();
        nameComponents.setNameMatherBoard(name);
        System.out.println("Создана материнская плата");
    }
    public void newCreateMatherBoardRandom() throws FileNotFoundException {
        ReadFileMatherBoard read = new ReadFileMatherBoard();
        String[] fullName = read.RandomInput().split(";");
        name = fullName[0];
        socket = fullName[1];
        countSlot = Integer.parseInt(fullName[2].split(" ")[0]);
        DDR = fullName[3];
        Characteristics characteristics = Characteristics.getInstance();
        characteristics.setCountSlot(countSlot);
        NameComponents nameComponents = NameComponents.getInstance();
        nameComponents.setNameMatherBoard(name);
        System.out.println("Создана материнская плата");
    }

    public String getName() {
        return name;
    }
}
