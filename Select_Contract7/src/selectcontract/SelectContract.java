/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selectcontract;

import java.io.FileNotFoundException;

/**
 *
 * @author manuel
 */
public class SelectContract {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        ContractView theView = new ContractView();
        ContractModel theModel = new ContractModel();
        ContractController theController = new ContractController(theView, theModel);
        theView.setVisible(true);
    }
    
}
