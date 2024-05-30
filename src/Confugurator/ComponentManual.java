package Confugurator;

import Components_computer.*;
import RAM_Modul.RAM;

import java.io.FileNotFoundException;

public class ComponentManual implements IComponent {
    public void createBlockPower() throws FileNotFoundException {
        BlockPower blockPower = new BlockPower();
        blockPower.newCreateBlockPower();
    }
    public void createHardDisk(){
        HardDisk hrDisk = new HardDisk();
        hrDisk.newCreateHardDisk();
    }
    public void createMatherBoard() throws FileNotFoundException {
        MatherBoard matherBoard = new MatherBoard();
        matherBoard.newCreateMatherBoard();

    }
    public void createProcessor() throws FileNotFoundException {
        Processor processor = new Processor();
        processor.newCreateProcessor();
    }
    public void createRAM(){
        RAM Ram = new RAM();
        Ram.newCreateRAM();
    }
    public void createVideoCard() throws FileNotFoundException {
        VideoCard videoCard = new VideoCard();
        videoCard.newCreateVideoCard();
    }
}