package bike;

import visitor.*;

public class ClassicBike extends Bike {

     /**
     * Constructor for creating a new instance of ClassicBike.
     *
     * @param nbMaxUsage the maximum number of uses for this classic bike before it needs maintenance.
     * @param rented the rental status of the bike at the time of instantiation.
     */
    public ClassicBike(int nbMaxUsage, boolean rented) {
        super(nbMaxUsage, rented);
    } 
    /**
     * Accepts a visitor that can perform operations on the ClassicBike.
     * This is a part of the Visitor pattern implementation.
     *
     * @param av the AbstractVisitor instance that is performing the action on the ClassicBike.
     */
    public  void accept(AbstractVisitor av){
        av.visit(this);
    }

   
}