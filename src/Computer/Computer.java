package Computer;

import Confugurator.ComponentManual;

import java.io.FileNotFoundException;

public class Computer {

    public void createComputer() throws FileNotFoundException {
        ComponentManual component = new ComponentManual();
        component.createProcessor();
        component.createMatherBoard();
        //component.createRAM();
        component.createVideoCard();
        component.createBlockPower();
        component.createHardDisk();
    }
}
