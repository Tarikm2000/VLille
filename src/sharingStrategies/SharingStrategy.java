package sharingStrategies;
import bike.Bike;
import observer.*;
import java.util.*;


public interface SharingStrategy {
    /**
     * Distributes a list of bikes across a list of stations according to a specific strategy.
     * Implementing classes will define the exact logic for the distribution.
     *
     * @param stations A list of Station objects where bikes need to be distributed.
     * @param bikes A list of Bike objects to be distributed among the stations.
     * @return The list of stations after the bikes have been distributed according to the implemented strategy.
     */
    public List<Station> shareBikes( List<Station> stations ,List<Bike> bikes);
        
}
