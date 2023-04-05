/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcontract;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author manuel
 */
class ContractModel {
    
    ArrayList<Contract> theContracts;
    public int contractCounter;
    public static final int NUMBER_OF_CONTRACT_ATTRIBUTES = 4;
    public static final int INDEX_OF_CONTRACT_ID = 0;
    public static final int INDEX_OF_ORIGIN_CITY = 1;
    public static final int INDEX_OF_DEST_CITY = 2;
    public static final int INDEX_OF_ORDER_ITEM = 3;
    
    private SortedSet<String> originCityList;
    private ArrayList<Contract> theContractsAll;
    
    
    public ContractModel() throws FileNotFoundException{
        theContracts = new ArrayList<>();
        contractCounter = 0;
        originCityList = new TreeSet<>();
        theContractsAll = new ArrayList<>();
        
        
//        String filename = "/Users/manuel/Desktop/Lab06-copy/myProject/src/selectcontract/contracts.txt";
         String filename = "E:\\Select_Contract7\\src\\selectcontract\\contracts.txt";
        // String filename = "M:\\ICS 125\\Lab06-copy\\myProject\\src\\selectcontract\\contracts.txt";
//        String filename = "E:\\Lab06-copy\\myProject\\src\\selectcontract\\contracts.txt";
//          String filename = "/Users/manuel/Desktop/Select_Contract7/src/selectcontract/contracts.txt";
        
       try (FileReader fileReader = new FileReader(filename);
           BufferedReader br = new BufferedReader(fileReader);) {
           String line;
           
           
           while ((line = br.readLine()) != null){
               String[] tokens = line.split(",", 4);
               if (tokens.length == 4){
                String contractID = tokens[0];
                String originCity = tokens[1];
                String destCity = tokens[2];
                String orderItem = tokens[3];
                
                originCityList.add(originCity);
                
                Contract dataContract = new Contract(
                    contractID, originCity, destCity, orderItem);
                
                theContracts.add(dataContract);
               }
           }
           
           fileReader.close();
           theContractsAll = new ArrayList<>(theContracts);
           originCityList.add("All");
           
//           // export everything in the arraylist
//           for (int i = 0; i < theContractsAll.size(); i++){
//               Contract current = theContractsAll.get(i);
//               System.out.println(current);
//           }
       }
       
       catch(IOException ex) {
           System.out.println(ex.getMessage());
       }
       
//       for (Contract contract: theContractsAll){
//           originCityList.add(contract.getOriginCity());
//       }
//       
//       String selectedCity = "";
//       for (Contract contract : theContractsAll){
//           if (contract.getOriginCity().equals(selectedCity)){
//               theContracts.add(contract);
//           }
//       }
        
    }
    
    public boolean foundContracts(){
        return !theContracts.isEmpty();
    }
    
    public Contract getTheContract(){
        return theContracts.get(contractCounter);
    }
    
    public int getContractCount(){
        return theContracts.size();
    }
    
    public int getCurrentContractNum(){
        return contractCounter;
    }
    
    public void nextContract(){
        if (contractCounter < theContracts.size() - 1)
            contractCounter++;
    }
    
    public void prevContract(){
        if(contractCounter > 0){
            contractCounter--;
        }
    }
    
    public boolean containsId(String id){
       boolean theTruth = false; 
       for(Contract contract: theContracts){
           String searchId = contract.getContractID();
           if(searchId.equals(id)){
               theTruth = true;
               break;
           }
       }
       
       return theTruth;
    }
    
    public String[] getOriginCityList(){
        String[] a;
        a  = originCityList.toArray(new String[originCityList.size()]);
        return a;
    }
    
    public void updateContractList(String city){
        theContracts = new ArrayList<>(theContractsAll);
        if (city != "All"){
            theContracts.removeIf(s -> !s.contains(city));
        }
        contractCounter = 0;
    }
    

    public void bidContract() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
