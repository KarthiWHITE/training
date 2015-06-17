/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cb-admin1
 */
class Parrot extends Bird implements Vegetarian,Flying{

    String name="Parrot";

    @Override
    public String getName() {
        return name;
    }
    
    
}
