package Components_computer;

import Confugurator.ComponentManual;
import Read_File.ReadFileProcessor;

import java.io.FileNotFoundException;

public class Processor extends ComponentManual {
    private String name;
    private String socket;
    private int countCore;
    private String DDR;
    private int powerMax;
    public void newCreateProcessor() throws FileNotFoundException {
        ReadFileProcessor read = new ReadFileProcessor();
        String[] fullName = read.ManualInput().split(";");
        name = fullName[0];
        socket = fullName[1];
        countCore = Integer.parseInt(fullName[2].split(" ")[0]);
        DDR = fullName[3];
        powerMax = Integer.parseInt(fullName[4].split(" ")[0]);
        System.out.println("Создан процессор");
    }

}
