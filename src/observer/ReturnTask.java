package observer;

import java.util.*;
import bike.Bike;


public class ReturnTask extends TimerTask {
    private ControlCenter cc;

    /**
     * Constructs a ReturnTask for the specified control center.
     *
     * @param cc The ControlCenter instance that this task will simulate bike returns for.
     */
    public ReturnTask(ControlCenter cc) {
        this.cc = cc;
    }

    /**
     * The action to be performed by this timer task. This method simulates the return of bikes to various stations.
     */
    @Override
    public void run() {
        Random random = new Random();
        int nbStations = cc.nbStations();
    
        if (nbStations <= 0) {
            System.out.println("Aucune station disponible. Fin de l'opération.");
            return;
        }
    
        int nbDepots = random.nextInt(nbStations);
        for (int i = 0; i < nbDepots; i++) {
            int stationId = random.nextInt(nbStations);
    
            if (stationId < 0 || stationId >= cc.nbStations()) {
                continue;
            }
    
            Station station = cc.getStations().get(stationId);
            List<Bike> rentedBikes = new ArrayList<>(station.getRentedBikes());
    
            if (!rentedBikes.isEmpty()) {
                int nbrBike = random.nextInt(rentedBikes.size());
                Bike bikeToReturn = rentedBikes.get(nbrBike);
                station.returnBike(bikeToReturn);
                // System.out.println("Un depot a eu");
            }
        }
    }
    
}
