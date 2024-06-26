package RAM_Modul;

import Read_File.ReadFileRAM;

import java.io.FileNotFoundException;

public class RAM_Tree {
    private String name;
    private int countMemory;
    private String DDR;
    public void createRamTreeManual() throws FileNotFoundException {
        ReadFileRAM read = new ReadFileRAM();
        String[] fullName = read.ManualInput().split(";");
        name = fullName[0];
        countMemory = Integer.parseInt(fullName[1].split(" ")[0]);
        DDR = fullName[2];

    }
    public void createRamTreeRandom() throws FileNotFoundException {
        ReadFileRAM read = new ReadFileRAM();
        String[] fullName = read.RandomInput().split(";");
        name = fullName[0];
        countMemory = Integer.parseInt(fullName[1].split(" ")[0]);
        DDR = fullName[2];

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountMemory() {
        return countMemory;
    }

    public void setCountMemory(int countMemory) {
        this.countMemory = countMemory;
    }

    public String getDDR() {
        return DDR;
    }

    public void setDDR(String DDR) {
        this.DDR = DDR;
    }

}
