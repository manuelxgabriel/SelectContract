/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcontract;

/**
 *
 * @author manuel
 */
public class Contract {
    
    private final String contractID;
    private final String originCity;
    private final String destCity;
    private final String orderItem;
    
    
    public Contract(String contractID, String originCity, String destCity, String orderItem){
        this.contractID = contractID;
        this.originCity = originCity;
        this.destCity = destCity;
        this.orderItem = orderItem;
        
    }
    
    public String getContractID(){
        return contractID;
    }
    
    public String getOriginCity(){
        return originCity;
    }
    
    public String getDestCity(){
        return destCity;
    }
    
    public String getOrderItem(){
        return orderItem;
    }

    public boolean contains(String city) {
        return city.equals(originCity);
    }
            
    
}
