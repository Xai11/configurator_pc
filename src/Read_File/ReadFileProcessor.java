package Read_File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileProcessor {
    private List<String> proc = new ArrayList<String>();

    private int count;

    public ReadFileProcessor() throws FileNotFoundException {
        FileReader fileProcessor = new FileReader("C:/files/Processor.txt");
        Scanner readProc = new Scanner(fileProcessor);
        while(readProc.hasNextLine()){
            proc.add(readProc.nextLine());
        }
        System.out.println(proc.toString());
    }
    public void ManualInput(){
        int i = 0;
        while(i < proc.size()){
            System.out.println(i + " - " + proc.get(i));
            i++;
        }
        Scanner processor = new Scanner(System.in);
        System.out.print("Введите свою хуйню " );
        String line = processor.nextLine();
        count = Integer.parseInt(line);
        System.out.println("Вы ввели хуйню: " + line);
    }

}
