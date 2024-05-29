package Computer;

import Confugurator.Component;

public class Computer {

    public void createComputer(){
        Component component = new Component();
        component.createProcessor();
        component.createBlockPower();
        component.createHardDisk();
        component.createRAM();
        component.createVideoCard();
    }
}
