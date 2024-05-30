package RAM_Modul;

import Singleton.Characteristics;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RAM {
    private int countRam;
    private RAM_One ramOne = new RAM_One();
    private RAM_Two ramTwo = new RAM_Two();
    private RAM_Tree ramTree = new RAM_Tree();
    private RAM_Four ramFour = new RAM_Four();


    public void CountSlotRam() throws FileNotFoundException {
        Characteristics characteristics = Characteristics.getInstance();
        countRam = characteristics.getCountSlot();

        Scanner RAM = new Scanner(System.in);

        System.out.print("Чаще всего в материнскую плату вставляется, \n" +
                "2 плашки оперативной памяти, либо же 4. Все зависит от того, сколько \n" +
                "слотов у материнской платы. \n" +
                "У вашей материнской платы " + countRam + " слотов \n" +
                "Вы хотите воспользоваться данной стратегией ?! \n" +
                "0 - Нет, хочу сам все сделать. \n" +
                "1 - Да. \n");
        String line = RAM.nextLine();
        int query1 = Integer.parseInt(line);
        if (query1 == 0) {
            System.out.println("Вам доступно " + countRam + " слота для оперативной памяти");

            Scanner query = new Scanner(System.in);
            System.out.print("Сколько хотите плашек добавить: ");
            String line2 = query.nextLine();

            int count2 = Integer.parseInt(line2);

            for(int i = 0; i < count2; i++){
                if (i == 0){
                    System.out.print(i + ": ");
                    ramOne.createRamOne();
                    System.out.println("");
                }
                else if (i == 1){
                    System.out.print(i + ": ");
                    ramTwo.createRamTwo();
                    System.out.println("");
                }
                else if (i == 2){
                    System.out.print(i + ": ");
                    ramTree.createRamTree();
                    System.out.println("");
                }
                else if (i == 3){
                    System.out.print(i + ": ");
                    ramFour.createRamFour();
                    System.out.println("");
                }
            }
        }
        else if (query1 == 1){
            Scanner query2 = new Scanner(System.in);
            String line3;
            if(countRam == 4) {
                System.out.print("Сколько хотите плашек добавить, 2 или 4: ");
                line3 = query2.nextLine();
            }else {
                System.out.print("В вашу материнскую плату вмещается только 2 ");
                line3 = "2";
            }

            int count3 = Integer.parseInt(line3);
            if(count3 == 2){
                ramOne.createRamOne();
                ramTwo.setName(ramOne.getName());
                ramTwo.setCountMemory(ramOne.getCountMemory());
                ramTwo.setDDR(ramOne.getDDR());
            }
            else if (count3 == 4){
                ramOne.createRamOne();
                ramTwo.setName(ramOne.getName());
                ramTwo.setCountMemory(ramOne.getCountMemory());
                ramTwo.setDDR(ramOne.getDDR());

                ramTree.setName(ramOne.getName());
                ramTree.setCountMemory(ramOne.getCountMemory());
                ramTree.setDDR(ramOne.getDDR());

                ramFour.setName(ramOne.getName());
                ramFour.setCountMemory(ramOne.getCountMemory());
                ramFour.setDDR(ramOne.getDDR());
            }
        }
    }

    public void newCreateRAM() {

        System.out.println("Создана ОЗУ");
    }

}
