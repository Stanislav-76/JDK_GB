package Interfaces;

public class Ox implements Bull{

    @Override
    public void walk() {
        System.out.println("Walks on hooves");
        throw new UnsupportedOperationException("Unimplemented method 'walk'");
    }

    @Override
    public void talk() {
        System.out.println("MooOooOoooDDoo");
    }    
}
