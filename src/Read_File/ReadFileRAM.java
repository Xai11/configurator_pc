package Read_File;

import Singleton.Characteristics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileRAM {
    private List<String> RAM = new ArrayList<String>();

    private int count;

    public ReadFileRAM() throws FileNotFoundException {
        FileReader fileRAM = new FileReader("C:/files/RAM.txt");
        Scanner readRAM = new Scanner(fileRAM);
        String temp_line;
        Characteristics characteristics = Characteristics.getInstance();
        String DDR = characteristics.getDDR();
        String temp_DDR;
        while(readRAM.hasNextLine()){
            temp_line = readRAM.nextLine();
            temp_DDR = temp_line.split(";")[2];
            if(temp_DDR.equals(DDR)) {
                RAM.add(temp_line);
            }
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
