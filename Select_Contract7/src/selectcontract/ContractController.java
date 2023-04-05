/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcontract;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.NumberFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author manuel
 */
class ContractController {
    private ContractView theView;
    private ContractModel theModel;
    public ConfirmBid cb;
    
    
    public ContractController(ContractView theView, ContractModel theModel){
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addPrevListener(new PrevButtonListener());
        this.theView.addBidListener(new BidButtonListener());
        this.theView.addNextListener(new NextButtonListener());
        this.theView.addcomboBoxListener(new ComboListener());
        
        //theView.addSaveListener(new BidButtonListener());
        this.theView.addContractListener(new NewContractButtonListener());
        
        this.theView.setOriginCityList(this.theModel.getOriginCityList());
        
        setUpDisplay();
        
    }  
    private void setUpDisplay(){
    
        try {
            
            // Control how the buttons appear
            if (theModel.getCurrentContractNum() == 0) {
                theView.getPrevButton().setEnabled(false);
            } else {
                theView.getPrevButton().setEnabled(true);
            }
            
            if (theModel.getCurrentContractNum() == theModel.getContractCount() - 1) {
                theView.getNextButton().setEnabled(false);
            } else {
                theView.getNextButton().setEnabled(true);
            }
            
            
            if (theModel.foundContracts()){
                Contract c = theModel.getTheContract();
                theView.setContractID(c.getContractID());
                theView.setDestCity(c.getDestCity());
                theView.setOriginCity(c.getOriginCity());
                theView.setOrderItem(c.getOrderItem());
            } else {
                theView.setContractID("?");
                theView.setDestCity("?");
                theView.setOriginCity("?");
                theView.setOrderItem("?");
            }
            
            int currentCountNum = theModel.getCurrentContractNum();
            int contractCount = theModel.getContractCount();
            theView.updateContractViewPanel(currentCountNum, contractCount);
            
        } catch (Error ex){
            System.out.println(ex);
            theView.displayErrorMessage(
                    "Error: there was a problem setting the contract.\n"
            );
        }
    }
        
    class PrevButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                theModel.prevContract();
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Error!: There is a problem setting a previous contract.");
            }

            setUpDisplay();
        }
    }
    
    class NextButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                
                theModel.nextContract();
                
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Error!: There is a problem setting a previous contract.");
            }

            setUpDisplay();
        }
    }
    
    class ComboListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e){
            System.out.println(e.getItem().toString());
            if (e.getStateChange() == ItemEvent.SELECTED){
                String selectedCity = e.getItem().toString();
               
                    System.out.println(selectedCity);
                    theModel.updateContractList(selectedCity);
                    setUpDisplay();
       
            }
            
        }
    }
    
    class BidButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                
                    cb = new ConfirmBid(theView, true, theModel.getTheContract());
                    cb.setLocationRelativeTo(null);
                    cb.setVisible(true);
                              
                
                } catch (Exception ex) {
                    System.out.println(ex);
                    theView.displayErrorMessage(
                            "Error: the numbers entered must be integers.");
                    }
        }
    
    }
    
    class NewContractButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
      
            try {
                
                System.out.println("New button is working");
                
                NewContract nc;
                nc = new NewContract(theView, true, theModel);
                nc.setVisible(true);
                
                
            
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Something when wrong with the new contract.");
            
            }
            
        
        }
    } 
    
}
    

