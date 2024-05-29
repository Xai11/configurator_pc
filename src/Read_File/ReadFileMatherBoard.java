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
        FileReader fileMatherBoard = new FileReader("C:/files/MotherBoard.txt");
        Scanner readBoard = new Scanner(fileMatherBoard);
        while(readBoard.hasNextLine()){
            matherBoard.add(readBoard.nextLine());
        }
        System.out.println(matherBoard.toString());
    }
    public void ManualInput(){
        int i = 0;
        while(i < matherBoard.size()){
            System.out.println(i + " - " + matherBoard.get(i));
            i++;
        }
        Scanner board = new Scanner(System.in);
        System.out.print("Введите свою хуйню " );
        String line = board.nextLine();
        count = Integer.parseInt(line);
        System.out.println("Вы ввели хуйню: " + line);
    }
}
