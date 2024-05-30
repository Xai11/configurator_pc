package Confugurator;

import Components_computer.BlockPower;
import Components_computer.MatherBoard;
import Components_computer.Processor;
import Components_computer.VideoCard;
import Disk_Modul.HardDisk;
import RAM_Modul.RAM;

import java.io.FileNotFoundException;

public class ComponentRandom {

    public void createBlockPower() throws FileNotFoundException {
        BlockPower blockPower = new BlockPower();
        blockPower.newCreateBlockPowerRandom();
    }
    public void createHardDisk() throws FileNotFoundException {
        HardDisk hrDisk = new HardDisk();
        hrDisk.newCreateHardDiskRandom();

    }
    public void createMatherBoard() throws FileNotFoundException {
        MatherBoard matherBoard = new MatherBoard();
        matherBoard.newCreateMatherBoardRandom();

    }
    public void createProcessor() throws FileNotFoundException {
        Processor processor = new Processor();
        processor.newCreateProcessorRandom();
    }
    public void createRAM() throws FileNotFoundException {
        RAM ram = new RAM();
        ram.CountSlotRamRandom();
    }
    public void createVideoCard() throws FileNotFoundException {
        VideoCard videoCard = new VideoCard();
        videoCard.newCreateVideoCardRandom();
    }

}
