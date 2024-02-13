package sharingStrategies;

import observer.Station;
import bike.Bike;

// import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSharing implements SharingStrategy {
    /**
     * Distributes bikes across a list of stations randomly.
     * Each bike is assigned to a random station, provided there is remaining capacity.
     *
     * @param stations The list of stations to distribute bikes to.
     * @param bikes    The list of bikes to be distributed.
     * @return The list of stations after the bikes have been distributed.
     */
    @Override
    public List<Station> shareBikes(List<Station> stations, List<Bike> bikes) {
        if (bikes.isEmpty() || stations.isEmpty()) {
            return stations;
        }

        int numStations = stations.size();
        Random random = new Random();

        for (Bike bike : bikes) {
            int randomIndex = random.nextInt(numStations);
            Station selectedStation = stations.get(randomIndex);
            int remainingCapacity = selectedStation.getmaxCapacity() - selectedStation.nbBikes();
            if (remainingCapacity > 0) {
                selectedStation.addBike(bike);
            }
        }

        return stations;
    }
}
