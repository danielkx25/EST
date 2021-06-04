/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evaluation1;

/**
 *
 * @author Daniel
 */
//product id example AVpgnnzJilAPnD_xu_7Q
import java.util.Scanner;

public class Evaluation1 {
    public static void main (String args[]){
        int done=0, option, quantity;
        String search;
        
        System.out.println("Welcome to my ERP System for Data Structures");
        System.out.println("This is the Evaluation 1, type an option:");
        
        Functions func = new Functions();//loads specification1
        
        while(done == 0){
            System.out.println("1-Search Product by Id");
            System.out.println("2-Search Product by Name");
            System.out.println("3-Remove Product by Id");
            System.out.println("4-End Evaluation");
            option = new Scanner(System.in).nextInt();
            switch(option){
                case 1:
                    System.out.println("Type the product Id:");
                    search = new Scanner(System.in).nextLine();
                    func.FindById(search);
                break;
                case 2:
                    System.out.println("Type the product Name:");
                    search = new Scanner(System.in).nextLine();
                    func.FindByName(search);
                break;
                case 3:
                    System.out.println("Type the product ID you want to remove:");
                    search = new Scanner(System.in).nextLine();
                    System.out.println("Type the quantity you want to remove:");
                    quantity = new Scanner(System.in).nextInt();
                    func.FindById(search);
                    func.RemoveStockById(search,quantity);
                break;
                default:
                    System.out.println("Program ended!");
                    done++;
                break;
            }
            System.out.println("Process done!");
        }
        
    }
}
