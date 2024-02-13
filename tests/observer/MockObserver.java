package tests.observer;

import observer.*;


public class MockObserver implements Observer {

    private int cpt; 

    public MockObserver (int cpt) {
        this.cpt=cpt;
    }

    public void update (Station station) {
        this.cpt++;
    }

    public int getNbCalled() {
        return this.cpt;
    }
    
}
