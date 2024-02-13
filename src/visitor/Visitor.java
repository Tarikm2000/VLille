package visitor;
import bike.*;

public interface Visitor { 
   
    /**
     * Visits a general Bike object.
     * Implementing this method allows the visitor to define specific actions for general bikes.
     *
     * @param b The Bike object being visited.
     */
    public void visit (Bike b); 

    /**
     * Visits a DecoratedBike object.
     * Implementing this method allows the visitor to define specific actions for decorated bikes.
     *
     * @param decoratedBike The DecoratedBike object being visited.
     */
    public void visit (DecoratedBike decoretedBike); 
    
    
    /**
     * Visits an ElectricalBike object.
     * Implementing this method allows the visitor to define specific actions for electrical bikes.
     *
     * @param electricalBike The ElectricalBike object being visited.
     */
    public void visit (ElectricalBike electricalBike);

    /**
     * Visits a ClassicBike object.
     * Implementing this method allows the visitor to define specific actions for classic bikes.
     *
     * @param classicBike The ClassicBike object being visited.
     */
    public void visit (ClassicBike ClassicalBike);
    
}
