package Components_computer;

import Confugurator.Component;

public class Processor extends Component {
    private String name;
    private String socket;
    private int countCore;
    private String DDR;
    private int powerMax;
    public void newCreateProcessor(){
        System.out.println("Создан процессор");
    }

}
