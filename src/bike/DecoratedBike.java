package bike;

import visitor.AbstractVisitor;

public class DecoratedBike extends Bike{ 

    private Bike bike ; 
    private Custom item;

    /**
     * Constructor for creating a new instance of DecoratedBike.
     *
     * @param bike The original Bike object that is being decorated.
     * @param item The Custom item that adds a new feature to the Bike.
     */
    public DecoratedBike (Bike bike, Custom item ) {
        super(bike.getNbMaxUsage(), bike.getRented());
        this.bike=bike;
        this.item=item;
    }

    /**
     * Accepts a visitor that can perform operations on the DecoratedBike.
     * This method allows actions from the Visitor pattern to be performed specifically on a DecoratedBike instance.
     *
     * @param av the AbstractVisitor instance that is performing the action on the DecoratedBike.
     */
     public  void accept(AbstractVisitor av){
        av.visit(this);
    }

    
}
