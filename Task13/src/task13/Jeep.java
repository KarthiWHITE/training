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
public class Jeep implements LandVechicle{

    
    public void soundHorn(){
        System.out.println("This vechicle has sound horn.");
    }

    @Override
    public int numWheels() {
        return 4;
    }

    @Override
    public void drive() {
        System.out.println("Start Driving");
    }

    @Override
    public String name() {
        return "Jeep";
    }

    @Override
    public int maxPassenger() {
        return 4;
    }

    @Override
    public int maxSpeed() {
        return 120;
    }
    
}
