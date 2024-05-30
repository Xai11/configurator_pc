package Read_File;

import Singleton.Characteristics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ReadFileMatherBoard {
    private List<String> matherBoard = new ArrayList<String>();

    private int count;

    public ReadFileMatherBoard() throws FileNotFoundException {
        FileReader fileMatherBoard = new FileReader("C:/files/MatherBoard.txt");
        Scanner readBoard = new Scanner(fileMatherBoard);
        String temp_line;
        Characteristics characteristics = Characteristics.getInstance();
        String socket = characteristics.getSocket();
        String temp_socket;
        String DDR = characteristics.getDDR();
        String temp_DDR;
        while(readBoard.hasNextLine()){
            temp_line = readBoard.nextLine();
            temp_socket = temp_line.split(";")[1];
            temp_DDR = temp_line.split(";")[3];
            if(temp_socket.equals(socket) && temp_DDR.equals(DDR)) {
                matherBoard.add(temp_line);
            }
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

    public String RandomInput(){
        count = matherBoard.size();
        Random rand = new Random();
        int randNumb = rand.nextInt(count);
        return matherBoard.get(randNumb);
    }
}
