package Read_File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileHardDisk {
    private List<String> hardDisk = new ArrayList<String>();

    private int count;

    public ReadFileHardDisk() throws FileNotFoundException {
        FileReader fileHardDisk = new FileReader("C:/files/HardDisk.txt");
        Scanner readDisk = new Scanner(fileHardDisk);
        while(readDisk.hasNextLine()){
            hardDisk.add(readDisk.nextLine());
        }
        System.out.println(hardDisk.toString());
    }
    public void ManualInput(){
        int i = 0;
        while(i < hardDisk.size()){
            System.out.println(i + " - " + hardDisk.get(i));
            i++;
        }
        Scanner disk = new Scanner(System.in);
        System.out.print("Введите свою хуйню " );
        String line = disk.nextLine();
        count = Integer.parseInt(line);
        System.out.println("Вы ввели хуйню: " + line);
    }

}
