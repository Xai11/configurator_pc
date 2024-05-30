package Read_File;

import Components_computer.BlockPower;
import Singleton.Characteristics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileBlockPower {
    private List<String> blockPower = new ArrayList<String>();
    private int count;
    public ReadFileBlockPower() throws FileNotFoundException {
        FileReader fileBlockPower = new FileReader("C:/files/BlockPower.txt");
        Scanner readPower = new Scanner(fileBlockPower);
        Characteristics characteristics = Characteristics.getInstance();
        int powerMax = characteristics.getPowerMax();
        int temp_powerMax;
        String temp_line;
        while(readPower.hasNextLine()){
            temp_line = readPower.nextLine();
            temp_powerMax = Integer.parseInt(temp_line.split(";")[1].split(" ")[0]);
            if(temp_powerMax > powerMax) {
                blockPower.add(temp_line);
            }
        }

    }
    public String ManualInput(){
        int i = 0;
        Characteristics characteristics = Characteristics.getInstance();
        int powerMax = characteristics.getPowerMax();
        System.out.println("Ваша система потребляет " + powerMax + " Вт\n"+
                "Берите блок питания с небольшим запасом");
        System.out.println("Блоки питания: " );
        while(i < blockPower.size()){
            System.out.println(i + " - " + blockPower.get(i).replace(";", ", "));
            i++;
        }
        Scanner block = new Scanner(System.in);
        System.out.print("Введите свой выбор " );
        String line = block.nextLine();
        count = Integer.parseInt(line);
        return blockPower.get(count);
    }


}

