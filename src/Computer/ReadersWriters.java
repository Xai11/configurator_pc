package Computer;

import Confugurator.ComponentRandom;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadersWriters {
    private int score = 0;
    private String name;
    private int pos;
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private Lock readLock = rwLock.readLock();
    private Lock writeLock = rwLock.writeLock();


//    public void read(ComponentRandom i){
//        readLock.lock();
//        if(score == 0){
//            try{
//                System.out.println("+");
//                score++;
//
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            }finally{
//                readLock.unlock();
//            }
//        }else{
//            readLock.unlock();
//        }
//    }

    public void endRead() throws InterruptedException {
        // Завершение чтения
    }

//    public void startWrite() throws InterruptedException {
//        writers++;
//        if (writers == 1) {
//            rw_mutex.acquire();
//        }
//
//        // Запись
//
//        writers--;
//        if (writers == 0) {
//            rw_mutex.release();
//        }
//    }

    public void endWrite() {
        // Завершение записи
    }
}
