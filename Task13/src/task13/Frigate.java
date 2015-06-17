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
public class Frigate implements SeaVessel{

    
    public void fireGun(){
        System.out.println("This Frigate have Fire Gun");
    }

    @Override
    public void dispalcement() {
        System.out.println("USA");
    }

    @Override
    public void lunch() {
        System.out.println("Lunch system");
    }

    @Override
    public String name() {
        return "Frigate";
    }

    @Override
    public int maxPassenger() {
        return 2;
    }

    @Override
    public int maxSpeed() {
        return 400;
    }
    
}
