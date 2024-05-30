package Components_computer;

import Confugurator.ComponentManual;
import Read_File.ReadFileVideoCard;
import Singleton.Characteristics;
import Singleton.NameComponents;

import java.io.FileNotFoundException;

public class VideoCard extends ComponentManual {
    private String name;
    private int videoRAM;
    private int powerMax = 0;
    public void newCreateVideoCardManual() throws FileNotFoundException {
        ReadFileVideoCard read = new ReadFileVideoCard();
        String[] fullName = read.ManualInput().split(";");
        name = fullName[0];
        videoRAM = Integer.parseInt(fullName[1].split(" ")[0]);
        powerMax = Integer.parseInt(fullName[2].split(" ")[0]);
        Characteristics characteristics = Characteristics.getInstance();
        characteristics.setPowerMax(powerMax);
        NameComponents nameComponents = NameComponents.getInstance();
        nameComponents.setNameVideoCard(name);
        System.out.println("Создана видеокарта");
    }

    public void newCreateVideoCardRandom() throws FileNotFoundException {
        ReadFileVideoCard read = new ReadFileVideoCard();
        String[] fullName = read.RandomInput().split(";");
        name = fullName[0];
        videoRAM = Integer.parseInt(fullName[1].split(" ")[0]);
        powerMax = Integer.parseInt(fullName[2].split(" ")[0]);
        Characteristics characteristics = Characteristics.getInstance();
        characteristics.setPowerMax(powerMax);
        NameComponents nameComponents = NameComponents.getInstance();
        nameComponents.setNameVideoCard(name);
        System.out.println("Создана видеокарта");
    }

    public String getName() {
        return name;
    }
}
