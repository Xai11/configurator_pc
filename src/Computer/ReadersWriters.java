package Computer;

import java.util.concurrent.Semaphore;

public class ReadersWriters {
    private int readers = 0;
    private int writers = 0;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore rw_mutex = new Semaphore(1);

    public void startRead() throws InterruptedException {
        mutex.acquire();
        readers++;
        if (readers == 1) {
            rw_mutex.acquire();
        }
        mutex.release();

        // Чтение

        mutex.acquire();
        readers--;
        if (readers == 0) {
            rw_mutex.release();
        }
        mutex.release();
    }

    public void endRead() throws InterruptedException {
        // Завершение чтения
    }

    public void startWrite() throws InterruptedException {
        writers++;
        if (writers == 1) {
            rw_mutex.acquire();
        }

        // Запись

        writers--;
        if (writers == 0) {
            rw_mutex.release();
        }
    }

    public void endWrite() {
        // Завершение записи
    }
}
