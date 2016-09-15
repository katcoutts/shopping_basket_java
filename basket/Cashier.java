package basket;
import java.util.*;
import java.text.DecimalFormat;

public class Cashier{

  private ShoppingBasket shoppingBasket;

  public Cashier(ShoppingBasket shoppingBasket){
    this.shoppingBasket = shoppingBasket;
  }

  public ShoppingBasket getShoppingBasket(){
    return this.shoppingBasket;
  }

  public float getBasicShoppingCost(){
    float cost = 0.0f;
    for (ShoppingItem item : getShoppingBasket().getShoppingItems()){
      cost += item.getPrice();
    }
    return cost;
  }

  public float getShoppingCostWithBogof(){
    float cost = 0.0f;
    ArrayList<ShoppingItem> bogofItems = new ArrayList<ShoppingItem>();
    for (ShoppingItem item : getShoppingBasket().getShoppingItems()){
      if ((item.getBogof() == true) && (bogofItems.contains(item))){
        bogofItems.remove(item);
      }
      else if (item.getBogof() == true){
        cost += item.getPrice();
        bogofItems.add(item);
      }
      else if (item.getBogof() == false){
        cost += item.getPrice();
      }
    }
    for (ShoppingItem item : bogofItems){
      System.out.println("You can get another " + item.getName() + " for free as it's on Buy-One-Get-One-Free");
    }
    return cost;
  }

  public float discountOfTenPerCentIfOver20(){
    float cost = getShoppingCostWithBogof();
    if (cost > 20.00){
      cost -= (cost / 10);
    }
    return cost;
  }


  public float getFinalShoppingCost(){
    float cost = discountOfTenPerCentIfOver20();
    if (getShoppingBasket().getLoyaltyCard() == true){
      cost -= (cost / 50);
    }
    return (float)Math.round(cost * 100) / 100;
  }


  public boolean checkForBogofItems(){
    for (ShoppingItem item: getShoppingBasket().getShoppingItems()){
      if (item.getBogof() == true){
        return true;
      }
    }
    return false;
  }


  public ArrayList<ShoppingItem> getBogofItems(){
    ArrayList<ShoppingItem> bogofs = new ArrayList<ShoppingItem>();
    for (ShoppingItem item : getShoppingBasket().getShoppingItems()){
      if (item.getBogof() == true){
        bogofs.add(item);
      }
    }
    return bogofs;
  }

}