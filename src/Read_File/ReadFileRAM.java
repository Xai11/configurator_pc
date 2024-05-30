package Read_File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileRAM {
    private List<String> RAM = new ArrayList<String>();

    private int count;

    public ReadFileRAM() throws FileNotFoundException {
        FileReader fileRAM = new FileReader("C:/files/Processor.txt");
        Scanner readRAM = new Scanner(fileRAM);
        while(readRAM.hasNextLine()){
            RAM.add(readRAM.nextLine());
        }
    }
    public String ManualInput(){
        int i = 0;
        System.out.println("ОЗУ: " );
        while(i < RAM.size()){
            System.out.println(i + " - " + RAM.get(i).replace(";", ", "));
            i++;
        }
        Scanner processor = new Scanner(System.in);
        System.out.print("Введите свой вариант " );
        String line = processor.nextLine();
        count = Integer.parseInt(line);
        return RAM.get(count);
    }
}
