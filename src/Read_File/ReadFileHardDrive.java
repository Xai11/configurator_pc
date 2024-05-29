package Read_File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileHardDrive {
    private List<String> hardDrive = new ArrayList<String>();

    private int count;

    public ReadFileHardDrive() throws FileNotFoundException {
        FileReader fileHardDrive = new FileReader("C:/files/HardDisk.txt");
        Scanner readDisk = new Scanner(fileHardDrive);
        while(readDisk.hasNextLine()){
            hardDrive.add(readDisk.nextLine());
        }
        System.out.println(hardDrive.toString());
    }
    public void ManualInput(){
        int i = 0;
        while(i < hardDrive.size()){
            System.out.println(i + " - " + hardDrive.get(i));
            i++;
        }
        Scanner block = new Scanner(System.in);
        System.out.print("Введите свою хуйню " );
        String line = block.nextLine();
        count = Integer.parseInt(line);
        System.out.println("Вы ввели хуйню: " + line);
    }

}
