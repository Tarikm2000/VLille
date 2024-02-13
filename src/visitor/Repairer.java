package visitor;
import bike.*;
import state.BikeIsNotWorking;
import state.BikeIsWorking;

public class Repairer extends AbstractVisitor {

    private String name;   
    
    /**
    * Constructs a Repairer visitor with a given name.
    *
    * @param name The name of the repairer.
    */
    public Repairer (String name) {
        this.name=name;
    }
    
    /**
     * Initiates the repair process on a bike.
     *
     * @param b The bike to be repaired.
     */
    public void repare(Bike b){
        this.visit(b);
    }

    /**
     * Repairs a DecoratedBike by setting its state to working and resetting its usage count.
     *
    //  * @param decoratedBike The DecoratedBike to be repaired.
     */
    @Override
    public void visit(DecoratedBike decoretedBike) {
        decoretedBike.setState(new BikeIsWorking());
        decoretedBike.setNbused(0);
    }  
    
    /**
    * Repairs a Bike by setting its state to working.
    *
    * @param b The Bike to be repaired.
    */
    @Override
    public void visit(Bike b) {
        b.setState(new BikeIsWorking());
         b.setNbused(b.getNbMaxUsage());

    }
    
    /**
     * Repairs an ElectricalBike by setting its state to working and resetting its usage count.
     *
     * @param electricalBike The ElectricalBike to be repaired.
     */
    @Override
    public void visit(ElectricalBike electricalBike) {
                electricalBike.setNbused(0);
            electricalBike.setState(new BikeIsWorking());
    }
   
    /**
     * Attempts to repair a ClassicBike, but sets its state to not working.
     *
     * @param classicBike The ClassicBike to be "repaired".
     */
    @Override
    public void visit(ClassicBike classicBike) {
        classicBike.setState( new BikeIsNotWorking());
        
    }
}
