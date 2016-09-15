import static org.junit.Assert.*;
import org.junit.*;
import basket.*;
import java.util.*;

public class ShoppingBasketTest {

  ShoppingItem pasta;
  ShoppingBasket shoppingBasket;
  ShoppingItem pizza;
  ShoppingItem chicken;
  
  @Before 
  public void before(){
    shoppingBasket = new ShoppingBasket();
    pasta = new ShoppingItem("pasta", 1.50f, false);
    pizza = new ShoppingItem("pizza", 4.50f, true);
    chicken = new ShoppingItem("chicken", 6.00f, true);
  }

  @Test
  public void canGetLoyaltyCardValue(){
    assertEquals(false, shoppingBasket.getLoyaltyCard());
  }

  @Test
  public void canSetLoyaltyCardValue(){
    shoppingBasket.setLoyaltyCard(true);
    assertEquals(true, shoppingBasket.getLoyaltyCard());
  }

  @Test
  public void canRemoveAnItem(){
    shoppingBasket.addItemToShopping(pasta);
    shoppingBasket.addItemToShopping(pizza);
    shoppingBasket.removeItem(pizza);
    assertEquals(1, shoppingBasket.getShoppingItems().size());
  }

  @Test
  public void canEmptyBasket(){
    shoppingBasket.addItemToShopping(pasta);
    shoppingBasket.addItemToShopping(pizza);
    shoppingBasket.emptyBasket();
    assertEquals(0, shoppingBasket.getShoppingItems().size());
  }

  @Test
  public void canAddItemToBasket(){
    shoppingBasket.addItemToShopping(pasta);
    assertEquals(1, shoppingBasket.getShoppingItems().size());
    shoppingBasket.addItemToShopping(pizza);
    assertEquals(2, shoppingBasket.getShoppingItems().size());
  }


  // @Test 
  // public void canGetBogofItems(){
  //   shoppingBasket.addItemToShopping(pasta);
  //   shoppingBasket.addItemToShopping(pizza);
  //   shoppingBasket.addItemToShopping(pizza);
  //   assertEquals(3, shoppingBasket.getShoppingItems().size());
  //   assertEquals(2, shoppingBasket.getBogofItems().size());
  // }

  // @Test 
  // public void canGetFalseIfNoBogofItems(){
  //   shoppingBasket.addItemToShopping(pasta);
  //   assertEquals(false, shoppingBasket.checkForBogofItems());
  // }

  // @Test
  // public void canGetTrueIfThereAreBogofItems(){
  //   shoppingBasket.addItemToShopping(pizza);
  //   assertEquals(true, shoppingBasket.checkForBogofItems());
  // }



}