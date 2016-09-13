package basket;
import java.util.*;

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
    return cost;
  }


  // COULD ADD SOME KIND OF FEEDBACK TO THE CUSTOMER IF THEY HAVE GOT AN ODD NUMBER OF ANY BOGOF ITEM THAT THEY CAN GET ANOTHER FOR FREE - WOULD NEED TO DO SOMETHING THAT DOES SIMILAR TO ABOVE BUT RETURNS THE ARRAYLIST OF BOGOFF ITEMS AND IF THERE'S ANYTHING IN THERE THAT MEANS THEY CAN GET ANOTHER ONE OF THAT FOR FREE.

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