package by.ryazantseva.multithreading.entity;
import by.ryazantseva.multithreading.exception.ResourceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ship extends Thread {
    private static Logger logger = LogManager.getLogger();
    private int loadCargo;
    private int unloadCargo;
    private Port port;
    private long shipId;

    public Ship(int loadCargo, int unloadCargo, long shipId, Port port) {
        this.shipId = shipId;
        this.loadCargo = loadCargo;
        this.unloadCargo = unloadCargo;
        this.port = port;
    }

    public void run() {
        Pier pier = null;
        try {
            pier = port.getResource();
            pier.doAction(loadCargo, unloadCargo);
            logger.log(Level.INFO, "Ship#" + shipId+ " is being in the pier#" + pier.getIdPier()+" NOW");
        } catch (ResourceException e) {
            logger.log(Level.INFO, "ALL PIERS ARE NOT AVAILABLE ");
        } finally {
            if (pier != null) {
                logger.log(Level.INFO, "Ship#" + shipId+ " left the pier#" + pier.getIdPier());
                port.returnResource(pier);
            }
        }
    }
}
