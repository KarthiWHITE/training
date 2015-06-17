

package customerinvoices;


public class Vehicle {
        private final String brand,color;
        
        private final double service_charge;
        
        public Vehicle(String brand, String color,double service_charge){
        
            this.brand=brand;
            this.color=color;
            this.service_charge=service_charge;
        }
        
        public double getServiceCharge(){
            return service_charge;
        }
        
        public void printVehicle(){
        
            System.out.println("----------------------------------");
            System.out.println("Vehile Details :");
            System.out.println("Brand   : "+brand);
            System.out.println("Color   : "+color);
            System.out.println("Service Charage   : "+service_charge);
            System.out.println("----------------------------------");
            
        }
}

