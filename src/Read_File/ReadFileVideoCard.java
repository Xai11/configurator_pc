package Read_File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileVideoCard {
    private List<String> videoCard = new ArrayList<String>();
    private int count;
    public ReadFileVideoCard() throws FileNotFoundException {
        FileReader fileVideoCard = new FileReader("C:/files/VideoCard.txt");
        Scanner readVideo = new Scanner(fileVideoCard);
        while(readVideo.hasNextLine()){
            videoCard.add(readVideo.nextLine());
        }
        System.out.println(videoCard.toString());

    }
    public void ManualInput(){
        int i = 0;
        while(i < videoCard.size()){
            System.out.println(i + " - " + videoCard.get(i));
            i++;
        }
        Scanner video= new Scanner(System.in);
        System.out.print("Введите свою хуйню " );
        String line = video.nextLine();
        count = Integer.parseInt(line);
        System.out.println("Вы ввели хуйню: " + line);
    }
    public void IDocument(){
        int i = 0;
        System.out.println("Hello, World");

    }
    public int getCount(){
        return count;
    }


}
