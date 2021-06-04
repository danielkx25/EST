/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evaluation1;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Functions { 
    ReadCSV readCSV = new ReadCSV();
    ArrayList<Product> products = readCSV.Read();//loads the csv
    
    public static void main(String args[]){
    }
    
    //Specification 1
    public void FindById(String id){
        int i,found=0;
        ArrayList<Product> products = this.products; 
        for(i=0;i<products.size();i++){
            Product product = products.get(i);
            if(id.equals(this.products.get(i).getId())){
                System.out.println("************************************************************");
                System.out.println("Id:"+product.getId());
                System.out.println("Name:"+product.getName());
                System.out.println("Total Stock:"+product.getTotalStock());
                System.out.println("Max Price: $"+product.getMaxPrice());
                System.out.println("Min Price: $"+product.getMinPrice());
                System.out.println("Condition:"+product.getCondition());
                System.out.println("************************************************************");
                found++;
            }
        }
        if(found==0){
                System.out.println("Product not found");
        }
    }
    public void FindByName(String name){
        int i,found=0;
        ArrayList<Product> products = this.products; 
        for(i=0;i<products.size();i++){
            Product product = products.get(i);
            if(this.products.get(i).getName().contains(name)){
                System.out.println("************************************************************");
                System.out.println("Id:"+product.getId());
                System.out.println("Name:"+product.getName());
                System.out.println("Total Stock:"+product.getTotalStock());
                System.out.println("Max Price: $"+product.getMaxPrice());
                System.out.println("Min Price: $"+product.getMinPrice());
                System.out.println("Condition:"+product.getCondition());
                System.out.println("************************************************************");
                found++;
            }
        }
        if(found==0){
                System.out.println("Product not found");
        }
    }
    
    //Evaluation1
    public void GetPeekEntraceById(String id){
        int i,found=0,j=0;
        ArrayList<Product> products = this.products; 
        for(i=0;i<products.size();i++){
            Product product = products.get(i);
            if(id.equals(this.products.get(i).getId())){
                //Stock stock = new Stock(); 
                System.out.println("************************************************************");
                System.out.println("Id:"+product.getId());
                System.out.println("Name:"+product.getName());
                System.out.println("Total Stock:"+product.getTotalStock());
                Queue<Entrace> entraces = product.getEntraces();
                System.out.println("Peek entrace:");
                System.out.println(entraces.peek().getDate());
                System.out.println(entraces.peek().getQuantity());
                System.out.println("************************************************************");
                found++;
            }
        }
        if(found==0){
                System.out.println("Product not found");
        }
    }
    
    public void RemoveStockById(String id, int quant){
        int i,found=0,j=0,done=0,oldQuant=quant;
        String question;
        ArrayList<Product> products = this.products; 
        for(i=0;i<products.size();i++){
            Product product = products.get(i);
            if(id.equals(this.products.get(i).getId())){
                found++;
                if(quant > product.getTotalStock()){
                    System.out.println("Insuficient stock");
                    while(done==0){
                            System.out.println("Do you want to take all the "
                                + product.getTotalStock()+  " products?");
                            System.out.println("Type YES or NO");
                            question=new Scanner(System.in).nextLine();
                            if(question.equals("YES")){
                                quant=product.getTotalStock();
                                oldQuant=product.getTotalStock();
                                done++;
                            }else{
                                if(question.equals("NO")){
                                    done++;
                                }
                            }
                        }
                }
                
                if(quant <= product.getTotalStock()){
                    Queue<Entrace> entraces = product.getEntraces();
                    System.out.println("Removed entraces:");
                    while(quant>0){
                        if(entraces.peek().getQuantity() <= quant){
                            System.out.println("Date:"+entraces.peek().getDate());
                            System.out.println("Quant:"+entraces.peek().getQuantity());
                            quant = quant - entraces.peek().getQuantity();
                            entraces.remove();
                        }else{
                            System.out.println("Altered entrace:");
                            System.out.println("Date:"+entraces.peek().getDate());
                            System.out.println("Old Quant:"+entraces.peek().getQuantity());
                            entraces.peek().setQuantity(entraces.peek().getQuantity()- quant);
                            System.out.println("New Quant:"+entraces.peek().getQuantity());
                            quant = 0;
                        }
                        
                        
                    }
                    product.setTotalStock(product.getTotalStock()-oldQuant);
                }
            }
        }
        if(found==0){
                System.out.println("Product not found");
        }
    }
    
}
