package Read_File;

import Components_computer.BlockPower;

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
        while(readPower.hasNextLine()){
            blockPower.add(readPower.nextLine());
        }
        System.out.println(blockPower.toString());

    }
    public void ManualInput(){
        int i = 0;
        while(i < blockPower.size()){
            System.out.println(i + " - " + blockPower.get(i));
            i++;
        }
        Scanner block = new Scanner(System.in);
        System.out.print("Введите свою хуйню " );
        String line = block.nextLine();
        count = Integer.parseInt(line);
        System.out.println("Вы ввели хуйню: " + line);
    }


}

