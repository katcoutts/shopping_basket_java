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


  // public boolean checkForBogofItems(){
  //   for (ShoppingItem item: getShoppingItems()){
  //     if (item.getBogof() == true){
  //       return true;
  //     }
  //   }
  //   return false;
  // }


  // public ArrayList<ShoppingItem> getBogofItems(){
  //   ArrayList<ShoppingItem> bogofs = new ArrayList<ShoppingItem>();
  //   for (ShoppingItem item : getShoppingItems()){
  //     if (item.getBogof() == true){
  //       bogofs.add(item);
  //     }
  //   }
  //   return bogofs;
  // }


}