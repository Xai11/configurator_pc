package Confugurator;

import Components_computer.*;
import Disk_Modul.HardDisk;
import RAM_Modul.RAM;

import java.io.FileNotFoundException;

public class ComponentManual implements IComponent {
    public void createBlockPower() throws FileNotFoundException {
        BlockPower blockPower = new BlockPower();
        blockPower.newCreateBlockPowerManual();
    }
    public void createHardDisk() throws FileNotFoundException {
        HardDisk hrDisk = new HardDisk();
        hrDisk.newCreateHardDiskManual();
    }
    public void createMatherBoard() throws FileNotFoundException {
        MatherBoard matherBoard = new MatherBoard();
        matherBoard.newCreateMatherBoardManual();

    }
    public void createProcessor() throws FileNotFoundException {
        Processor processor = new Processor();
        processor.newCreateProcessorManual();
    }
    public void createRAM() throws FileNotFoundException {
        RAM ram = new RAM();
        ram.CountSlotRamManual();
    }
    public void createVideoCard() throws FileNotFoundException {
        VideoCard videoCard = new VideoCard();
        videoCard.newCreateVideoCardManual();
    }
}