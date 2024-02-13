package state;

public class BikeIsNotWorking implements BikeState {

    /**
     * Provides the state description of the bike.
     * In this state, the bike is not working and needs to be repaired.
     *
     * @return A string indicating that the bike is not operational and needs repair.
     */
        public String bikeState(){
                    return ("This bike is Not working and need to be repared");
    }    
}
