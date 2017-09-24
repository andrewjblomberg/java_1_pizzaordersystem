/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_1_pizzaordersystem;

/**
 *
 * @author Andrew
 */
import java.util.*;
public class Pizza{
  
  //instance variables
  public double TOPPING_COST=1.75;
  public int MAX_TOPPINGS=10;
  public int SMALL=1;
  public int MEDIUM=2;
  public int LARGE=3;
  public double SMALL_COST=8.0;
  public double MED_COST=10.0;
  public double LARGE_COST=12.0;
  private int size=0;
  private int toppings=0;
  
  //default constructor
  public Pizza(){}
  
  //accessor method
  public int getSize(){
    return this.size;
  }
  
  //mutator method 
  public void setSize(int size){
    if (size > 3 || size < 1){
      throw new IllegalArgumentException();
    } 
    this.size = size;
  }
  
  //accessor method
  public int getToppings(){
    return this.toppings;
  }
  
  //mutator method
  public void setToppings(int toppings){
    if (toppings > MAX_TOPPINGS || toppings < 1){
      throw new IllegalArgumentException();
    } 
    this.toppings=toppings;
  }
  
  //method to calculate and return the price of the pizza object
  public double calcPrice(){
    if(size == 1)
      return toppings * TOPPING_COST + SMALL_COST;
    else if(size == 2)
      return toppings * TOPPING_COST + MED_COST;
    else
      return toppings * TOPPING_COST + LARGE_COST;
  }
  
  //method that returns the pizza object as formatted string
  public String toString(){
    if(size == 1){
      return String.format("Small Pizza\n%d Toppings\nTotal Price: $%.2f\n\n",toppings,calcPrice());
    }else if(size == 2){
      return String.format("Medium Pizza\n%d Toppings\nTotal Price: $%.2f\n\n",toppings,calcPrice());
    }else{
      return String.format("Large Pizza\n%d Toppings\nTotal Price: $%.2f\n\n",toppings,calcPrice());
    }
  }
}
    