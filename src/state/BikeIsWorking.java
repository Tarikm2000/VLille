package state;

public class BikeIsWorking  implements BikeState{ 
    
    /**
     * Provides the state description of the bike.
     * In this state, the bike is working and available for use.
     *
     * @return A string indicating that the bike is operational and can be used.
     */
    public String bikeState() {
        return ("This bike is working and can be used ");

    }
    
}
