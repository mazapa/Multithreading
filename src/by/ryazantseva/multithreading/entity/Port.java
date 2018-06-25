package by.ryazantseva.multithreading.entity;

import by.ryazantseva.multithreading.exception.ResourceException;
import by.ryazantseva.multithreading.util.IdGenerator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private static AtomicBoolean instanceCreated = new AtomicBoolean();
    private Semaphore semaphore;
    private Queue<Pier> piers = new LinkedList<>();
    private static Port port;
    private static ReentrantLock lock = new ReentrantLock();

    private Port(int amountOfPiers) {
        semaphore = new Semaphore(amountOfPiers, true);
    }

    public static Port getInstance(int amountOfPiers) {
        if (!instanceCreated.get()) {
            lock.lock();
            try {
                if (port == null) {
                    port = new Port(amountOfPiers);
                    instanceCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return port;
    }

    public void addPier() {
        Pier pier = new Pier(IdGenerator.generatePierId());
        piers.add(pier);
    }

    public Pier getResource() throws ResourceException {
        Pier pier = null;
        if (semaphore.tryAcquire()) {
            pier = piers.poll();
            return pier;
        }
        throw new ResourceException("Resource is not available");
    }

    public void returnResource(Pier pier) {
        piers.offer(pier);
        semaphore.release();
    }

}
