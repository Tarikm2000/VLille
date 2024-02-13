package bike;
import state.*;
import visitor.AbstractVisitor;


public abstract class Bike {
        protected int nbMaxUsage;
        protected boolean rented;
        protected BikeState bikeState;
        protected int nbUsed;
    
        /**
         * Constructor for creating a new Bike instance.
         *
         * @param nbMaxUsage the maximum number of uses for this bike before it needs maintenance.
         * @param rented the rental status of the bike at the time of instantiation.
         */
            public Bike(int nbMaxUsage, boolean rented ) {
            this.nbMaxUsage = nbMaxUsage;
            this.rented = rented;
            this.nbUsed=0;
            this.bikeState= new BikeIsWorking();
        }   

        /**
         * Gets the maximum number of uses for the bike.
         *
         * @return the maximum number of uses.
         */
        public int getNbMaxUsage() {
            return nbMaxUsage;
        }

        /**
         * Gets the number of times the bike has been used.
         *
         * @return the number of uses.
         */
        public int getNbused() {
            return this.nbUsed;
        }

        /**
         * Gets the rental status of the bike.
         *
         * @return true if the bike is rented, false otherwise.
         */
        public boolean getRented() {
            return this.rented;
        }
        
        /**
         * Sets the number of times the bike has been used.
         *
         * @param nbUsed the new number of uses.
         */
        public void setNbused(int nbUsed) {
            this.nbUsed=nbUsed;
        }

        /**
         * Gets the current state of the bike.
         *
         * @return the current state as a BikeState object.
         */
        public BikeState getBikeState(){
            return this.bikeState;
        }

        /**
         * Sets the state of the bike.
         *
         * @param bikeState the new state of the bike.
         */
        public void setState(BikeState bikeState) {
            this.bikeState =bikeState;

        }

        /**
         * Sets the maximum number of uses for the bike.
         *
         * @param nbMaxUsage the new maximum number of uses.
         */
        public void setNbMaxUsage(int nbMaxUsage) {
            this.nbMaxUsage = nbMaxUsage;
        }

        /**
         * Checks if the bike is currently rented.
         *
         * @return true if the bike is rented, false otherwise.
         */
        public boolean isRented() {
            return rented;
        }
        
        /**
         * Sets the rental status of the bike.
         *
         * @param rented the new rental status.
         */
        public void setRented(boolean rented) {
            this.rented = rented;
        }

        /**
         * Abstract method to be implemented by subclasses for accepting visitors.
         * This is part of the Visitor pattern and allows different visitor objects
         * to perform actions on the bike.
         *
         * @param av the AbstractVisitor instance that is performing the action.
         */
        public abstract void  accept(AbstractVisitor av);

        }
        
