package Confugurator;

import Components_computer.*;
import RAM_Modul.RAM;

public class Component implements IComponent {
    public void createBlockPower(){
        BlockPower blockPower = new BlockPower();
        blockPower.newCreateBlockPower();
    }
    public void createHardDisk(){
        HardDisk hrDisk = new HardDisk();
        hrDisk.newCreateHardDisk();
    }
    public void createMatherBoard(){
        MatherBoard matherBoard = new MatherBoard();
        matherBoard.newCreateMatherBoard();

    }
    public void createProcessor(){
        Processor processor = new Processor();
        processor.newCreateProcessor();
    }
    public void createRAM(){
        RAM Ram = new RAM();
        Ram.newCreateRAM();
    }
    public void createVideoCard(){
        VideoCard videoCard = new VideoCard();
        videoCard.newCreateVideoCard();
    }
}