package visitor;

import bike.Bike;
import bike.ClassicBike;
import bike.DecoratedBike;
import bike.ElectricalBike;
import state.BikeIsNotWorking;
import state.BikeIsWorking;
import observer.*;



public class Thief extends AbstractVisitor { 
    private Station station;
     
    /**
     * Constructs a Thief visitor associated with a specific station.
     *
     * @param station The station from which the thief can steal bikes.
     */
    public Thief (Station station) {
        this.station=station;
    }

    /**
     * Initiates the theft process on a bike.
     *
     * @param b The bike to be stolen.
     */
    public void steal(Bike b){
        this.visit(b);
    }

    /**
     * Steals a DecoratedBike from the station by removing it from the station's list of bikes.
     *
    //  * @param decoretedBike The DecoratedBike to be stolen.
     */
    @Override
    public void visit(DecoratedBike decoretedBike) {    
        this.station.removeBike(decoretedBike);
        

    }

    /**
     * Steals an ElectricalBike from the station by removing it from the station's list of bikes.
     *
     * @param electricalBike The ElectricalBike to be stolen.
     */
    @Override
    public void visit(ElectricalBike electricalBike) {
        this.station.removeBike(electricalBike);
        
    }
    
    /**
     * Steals a ClassicBike from the station by removing it from the station's list of bikes.
     *
     * @param classicBike The ClassicBike to be stolen.
     */
    @Override
    public void visit(ClassicBike classicBike) {
        this.station.removeBike(classicBike);
        
        
    }

    
}
