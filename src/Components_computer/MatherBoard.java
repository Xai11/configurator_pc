package Components_computer;

import Confugurator.ComponentManual;
import Read_File.ReadFileMatherBoard;
import Read_File.ReadFileProcessor;

import java.io.FileNotFoundException;

public class MatherBoard extends ComponentManual {
    private String name;
    private String socket;
    private int countSlot;
    private String DDR;
    public void newCreateMatherBoard() throws FileNotFoundException {
        ReadFileMatherBoard read = new ReadFileMatherBoard();
        String[] fullName = read.ManualInput().split(";");
        name = fullName[0];
        socket = fullName[1];
        countSlot = Integer.parseInt(fullName[2].split(" ")[0]);
        DDR = fullName[3];
        System.out.println("Создана материнская плата");
    }
}
