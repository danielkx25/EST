/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evaluation1;

import java.util.Queue;

/**
 *
 * @author Daniel
 */
public class Product {
    private String Id;
    private String Name;
    private Float MaxPrice;
    private Float MinPrice;
    private String Condition;
    private int TotalStock;
    private Queue<Entrace> Entraces;

    public int getTotalStock() {
        return TotalStock;
    }

    public void setTotalStock(int TotalStock) {
        this.TotalStock = TotalStock;
    }

    
    
    public Queue<Entrace> getEntraces() {
        return Entraces;
    }

    public void setEntraces(Queue<Entrace> Entraces) {
        this.Entraces = Entraces;
    }
    
    

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Float getMaxPrice() {
        return MaxPrice;
    }

    public void setMaxPrice(Float MaxPrice) {
        this.MaxPrice = MaxPrice;
    }

    public Float getMinPrice() {
        return MinPrice;
    }

    public void setMinPrice(Float MinPrice) {
        this.MinPrice = MinPrice;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String Condition) {
        this.Condition = Condition;
    }
    
    
}
