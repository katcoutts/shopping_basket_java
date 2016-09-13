package basket;
import java.util.*;

public class ShoppingItem{

  private String name;
  private float price;
  private boolean bogof;

  public ShoppingItem(String name, float price, boolean bogof){
    this.name = name;
    this.price = price;
    this.bogof = bogof;
  }

  public String getName(){
    return this.name;
  }

  public boolean getBogof(){
    return this.bogof;
  }

  public float getPrice(){
    return this.price;
  }

}