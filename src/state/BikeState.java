package state;

public interface BikeState {  
     /**
     * Provides the current state description of a bike.
     * Implementing classes will define the specific state description, such as whether the bike is working or not working.
     *
     * @return A string describing the current state of the bike.
     */
     public String  bikeState();   
}
