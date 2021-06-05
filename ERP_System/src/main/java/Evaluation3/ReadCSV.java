/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evaluation3;

/**
 *
 * @author Daniel
 */

import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ReadCSV {
    public static ArrayList<Product> Read(){
        ArrayList<Product> products = new ArrayList();
        Product product = new Product();
        //Stock stock = new Stock();
        Queue <Entrace> entraces = new LinkedList<>();
        Entrace entrace = new Entrace();
        int i, counter=0, j, k, day=1, totalStock=0,nId=0;
        Random rand = new Random();
        
            try {
    
    
    // create a reader
    Reader reader = Files.newBufferedReader(Paths.get(
            "C:\\Users\\Daniel\\Documents\\GitHub\\EST\\ERP_System\\src\\main\\java\\Evaluation1\\Products_LIMIT100.csv"));

    // create csv reader
    CSVReader csvReader = new CSVReader(reader);

    // read one record at a time
    String[] record;
    String lastId="";
    int repeated=0;
    
    while ((record = csvReader.readNext()) != null) {
        if (counter!=0){
            if(!lastId.equals(record[0]) && counter !=0 && counter !=1){
                //stock = new Stock();
                //stock.setProductId(product.getId());//seting the stock
                
                entraces = new LinkedList<>();//start or restart the entrace queue
                for(j=0;j<rand.nextInt(20)+1;j++){
                    entrace = new Entrace();
                    entrace.setDate(day+"-01-2021");
                    entrace.setQuantity(rand.nextInt(100)+1);
                    totalStock = totalStock + entrace.getQuantity();
                    entraces.add(entrace);
                    day++;
                }
                product.setNumericId(nId);
                product.setTotalStock(totalStock);
                product.setEntraces(entraces);
                
                products.add(product);
                product = new Product();
                repeated=0;
                totalStock=0;
                day=1;
                nId++;
            }else{
                repeated++;
            }
            
            product.setId(record[0]);//ID
            product.setName(record[21]);//Name
            product.setMaxPrice(Float.parseFloat(record[1]));//MaxPrice
            product.setMinPrice(Float.parseFloat(record[2]));//MinPrice
            product.setCondition(record[4]);//Condition
            lastId=record[0];
        }
        counter++;
    }
    if(repeated>0){
        entraces = new LinkedList<>();//start or restart the entrace queue
                for(j=0;j<rand.nextInt(20)+1;j++){
                    entrace = new Entrace();
                    entrace.setDate(day+"-01-2021");
                    entrace.setQuantity(rand.nextInt(100)+1);
                    totalStock = totalStock + entrace.getQuantity();
                    entraces.add(entrace);
                    day++;
                }
                product.setNumericId(nId);
                product.setTotalStock(totalStock);
                product.setEntraces(entraces);
        products.add(product);//add the last product if repeated
    }
    //for(i=0;i<products.size();i++){
    //    System.out.println(products.get(i).getName());
    //}

    // close readers
    csvReader.close();
    reader.close();
    

} catch (IOException ex) {
    ex.printStackTrace();
}
        return products;
       
    }
}
