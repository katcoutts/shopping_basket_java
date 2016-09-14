package basket;
import java.util.*;
import java.text.DecimalFormat;

public class ShoppingBasket{

  private ArrayList<ShoppingItem> shoppingItems;
  private boolean loyaltyCard;

  public ShoppingBasket(){
    this.shoppingItems = new ArrayList<ShoppingItem>();
    this.loyaltyCard = false;
  }

  public ArrayList<ShoppingItem> getShoppingItems(){
    ArrayList<ShoppingItem> clone = new ArrayList<ShoppingItem>(this.shoppingItems);
    return clone;
  }

  public boolean getLoyaltyCard(){
    return this.loyaltyCard;
  }

  public void setLoyaltyCard(boolean value){
    this.loyaltyCard = value;
  }

  public void addItemToShopping(ShoppingItem item){
    shoppingItems.add(item);
  }

  public void removeItem(ShoppingItem item){
    shoppingItems.remove(item);
  }

  public void emptyBasket(){
    shoppingItems.clear();
  }

  public float getBasicShoppingCost(){
    float cost = 0.0f;
    for (ShoppingItem item : getShoppingItems()){
      cost += item.getPrice();
    }
    return cost;
  }

  public float getShoppingCostWithBogof(){
    float cost = 0.0f;
    ArrayList<ShoppingItem> bogofItems = new ArrayList<ShoppingItem>();
    for (ShoppingItem item : getShoppingItems()){
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
    if (loyaltyCard == true){
      cost -= (cost / 50);
    }
    return (float)Math.round(cost * 100) / 100;
  }








  public boolean checkForBogofItems(){
    for (ShoppingItem item: getShoppingItems()){
      if (item.getBogof() == true){
        return true;
      }
    }
    return false;
  }


  public ArrayList<ShoppingItem> getBogofItems(){
    ArrayList<ShoppingItem> bogofs = new ArrayList<ShoppingItem>();
    for (ShoppingItem item : getShoppingItems()){
      if (item.getBogof() == true){
        bogofs.add(item);
      }
    }
    return bogofs;
  }


}