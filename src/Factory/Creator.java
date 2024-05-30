package Factory;

import Computer.Manual;
import Computer.Random;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Creator implements ICreator {
    public int getRequest(){
        System.out.println("Выберите, какой способ сборки компьютера вам подходит:\n" +
                "0 - Ручной (Каждую деталь нужно выбирать самостоятельно)\n" +
                "1 - Существующий (Вам уже подобрали готовую сборку");
        Scanner request = new Scanner(System.in);
        System.out.print("Введите свой выбор " );
        String line = request.nextLine();
        int count = Integer.parseInt(line);
        return count;
    }
    public void createComputer() throws FileNotFoundException {
        if (getRequest() == 0){
            Manual manual = new Manual();
            manual.createManual();
        }
        else if (getRequest() == 1){
            Random random = new Random();
            random.createRandom();
        }
    }

}
