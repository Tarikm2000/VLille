package bike;

import visitor.AbstractVisitor;

public class ElectricalBike extends Bike {
    /**
     * Constructs a new instance of ElectricalBike with specified parameters.
     *
     * @param nbMaxUsage the maximum number of uses for this electric bike before it needs maintenance.
     * @param rented the rental status of the bike at the time of instantiation.
     */
    public ElectricalBike(int nbMaxUsage, boolean rented) {
        super(nbMaxUsage, rented);
    }


    /**
     * Accepts a visitor that can perform operations on the ElectricalBike.
     * This method is part of the Visitor pattern implementation, allowing different visitor objects
     * to perform actions specific to the ElectricalBike.
     *
     * @param av the AbstractVisitor instance that is performing the action on the ElectricalBike.
     */
     public  void accept(AbstractVisitor av){
        av.visit(this);
    }


}


