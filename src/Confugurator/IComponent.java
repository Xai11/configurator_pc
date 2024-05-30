package Confugurator;

import java.io.FileNotFoundException;

public interface IComponent {
    public void createBlockPower() throws FileNotFoundException;
    public void createHardDisk() throws FileNotFoundException;
    public void createMatherBoard() throws FileNotFoundException;
    public void createProcessor() throws FileNotFoundException;
    public void createRAM() throws FileNotFoundException;
    public void createVideoCard() throws FileNotFoundException;
}
