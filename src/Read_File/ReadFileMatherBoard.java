package Read_File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileMatherBoard {
    private List<String> matherBoard = new ArrayList<String>();

    private int count;

    public ReadFileMatherBoard() throws FileNotFoundException {
        FileReader fileMatherBoard = new FileReader("C:/files/MatherBoard.txt");
        Scanner readBoard = new Scanner(fileMatherBoard);
        while(readBoard.hasNextLine()){
            matherBoard.add(readBoard.nextLine());
        }
    }
    public String ManualInput(){
        int i = 0;
        System.out.println("Материнские платы: " );
        while(i < matherBoard.size()){
            System.out.println(i + " - " + matherBoard.get(i).replace(";", ", "));
            i++;
        }
        Scanner board = new Scanner(System.in);
        System.out.print("Введите свой выбор " );
        String line = board.nextLine();
        count = Integer.parseInt(line);
        return matherBoard.get(count);
    }
}
