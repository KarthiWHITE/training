/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task13;

/**
 *
 * @author cb-admin1
 */
public class Hovercraft implements LandVechicle, SeaVessel{

    public void enterLand(){
        System.out.println("drive Mode");
    }
    
    public void enterSea(){
        System.out.println("Lunch mode");
    }
    @Override
    public int numWheels() {
       return 10;
    }

    @Override
    public void drive() {
        System.out.println("You can drive this");
    }

    @Override
    public String name() {
        return "Hovercraft";
    }

    @Override
    public int maxPassenger() {
        return 3;
    }

    @Override
    public int maxSpeed() {
        return 350;
    }

    @Override
    public void dispalcement() {
        System.out.println("UK");
    }

    @Override
    public void lunch() {
        System.out.println("lunch this");
    }

    
}

