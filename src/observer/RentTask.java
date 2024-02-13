package observer;

import java.util.*;
import bike.Bike;


public class RentTask extends TimerTask {
    private ControlCenter cc;

    
    /**
     * Constructs a RentTask for the specified control center.
     *
     * @param cc The ControlCenter instance that this task will simulate rentals for.
     */
    public RentTask(ControlCenter cc) {
        this.cc = cc;
    }


    /**
     * The action to be performed by this timer task. This method simulates bike rentals at random stations.
     */
    @Override
    public void run() {
    Random random = new Random(); 

    int nbStations = cc.nbStations();

    if (nbStations <= 0) {
        System.out.println("Aucune station disponible. Fin de l'opération.");
        return;
    }

    int nbLocations = random.nextInt(nbStations);

    for (int i = 0; i < nbLocations; i++) { 
        int stationId = random.nextInt(nbStations);

        if (stationId < 0 || stationId >= cc.nbStations()) {
            continue;
        }

        Station station = cc.getStations().get(stationId);

        if (station.getBikes().isEmpty()) {
            continue;
        }

        int nbrBike = random.nextInt(station.getBikes().size());
        station.rentBike(station.getBikes().get(nbrBike));
        System.out.println("un retrait a eu lieu a la startion "+ station.getId()+" Cett station  a à present  "+station.nbBikes());
    }
}
       
        
}
