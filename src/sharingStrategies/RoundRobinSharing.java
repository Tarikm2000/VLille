package sharingStrategies;

import observer.Station;
import bike.Bike;

import java.util.List;


public class RoundRobinSharing implements SharingStrategy {
    private int currentStationIndex = 0;
    
    /**
     * Distributes bikes across a list of stations using a round-robin approach.
     * Each bike is assigned to stations in a sequential and cyclic order.
     *
     * @param stations The list of stations to distribute bikes to.
     * @param bikes    The list of bikes to be distributed.
     * @return The list of stations after the bikes have been distributed.
     */
    @Override
    
    public List<Station> shareBikes( List<Station> stations ,List<Bike> bikes) {
        if (bikes.isEmpty() || stations.isEmpty()) {
            return stations;
        }

        for (Bike bike : bikes) {
            Station currentStation = stations.get(currentStationIndex);
            int remainingCapacity = currentStation.getmaxCapacity() - currentStation.nbBikes();

            if (remainingCapacity > 0) {
                currentStation.addBike(bike);
            }
            currentStationIndex = (currentStationIndex + 1) % stations.size();
        }

        return stations;
    }
}
