import static org.junit.Assert.*;
import org.junit.*;
import basket.*;
import java.util.*;

public class CashierTest {

  ShoppingItem pasta;
  ShoppingBasket shoppingBasket;
  ShoppingItem pizza;
  ShoppingItem chicken;
  Cashier cashier;
  
  @Before 
  public void before(){
    shoppingBasket = new ShoppingBasket();
    pasta = new ShoppingItem("pasta", 1.50f, false);
    pizza = new ShoppingItem("pizza", 4.50f, true);
    chicken = new ShoppingItem("chicken", 6.00f, true);
    cashier = new Cashier(shoppingBasket);
  }

  @Test
  public void canGetBasicBasketCost(){
    shoppingBasket.addItemToShopping(pasta);
    shoppingBasket.addItemToShopping(pizza);
    assertEquals(6.00, cashier.getBasicShoppingCost(), 0.005);
  }

  @Test
  public void canGetShoppingCostWithBogof(){
      shoppingBasket.addItemToShopping(pizza);
      shoppingBasket.addItemToShopping(pizza);
      shoppingBasket.addItemToShopping(chicken);
      shoppingBasket.addItemToShopping(chicken);
      shoppingBasket.addItemToShopping(pasta);
      shoppingBasket.addItemToShopping(pasta);
      shoppingBasket.addItemToShopping(pizza);
      assertEquals(18.00, cashier.getShoppingCostWithBogof(), 0.005);
  }

  @Test
  public void canGetTenPerCentDiscountIfOver20(){
    shoppingBasket.addItemToShopping(pizza);
    shoppingBasket.addItemToShopping(pizza);
    shoppingBasket.addItemToShopping(chicken);
    shoppingBasket.addItemToShopping(chicken);
    shoppingBasket.addItemToShopping(pasta);
    shoppingBasket.addItemToShopping(pasta);
    shoppingBasket.addItemToShopping(pizza);
    shoppingBasket.addItemToShopping(chicken);
    assertEquals(24.00, cashier.getShoppingCostWithBogof(), 0.005);
    float discountedCost = cashier.discountOfTenPerCentIfOver20();
    assertEquals(21.60, discountedCost, 0.005);
  }

  @Test
  public void canGetFinalCostWithAllDiscounts(){
    shoppingBasket.addItemToShopping(pizza);
    shoppingBasket.addItemToShopping(pizza);
    shoppingBasket.addItemToShopping(chicken);
    shoppingBasket.addItemToShopping(chicken);
    shoppingBasket.addItemToShopping(pasta);
    shoppingBasket.addItemToShopping(pasta);
    shoppingBasket.addItemToShopping(pizza);
    shoppingBasket.addItemToShopping(chicken);
    shoppingBasket.setLoyaltyCard(true);
    assertEquals(true, shoppingBasket.getLoyaltyCard());
    float finalCost = cashier.discountOfTenPerCentIfOver20();
    assertEquals(21.60, finalCost, 0.005);
    assertEquals(21.168, cashier.getFinalShoppingCost(), 0.005);
  }

  @Test
  public void canGetFinalCost(){
    shoppingBasket.addItemToShopping(pizza);
    shoppingBasket.addItemToShopping(pizza);
    shoppingBasket.addItemToShopping(chicken);
    shoppingBasket.addItemToShopping(pasta);
    shoppingBasket.addItemToShopping(pasta);
    shoppingBasket.addItemToShopping(pizza);
    shoppingBasket.addItemToShopping(chicken);
    assertEquals(18.00, cashier.getFinalShoppingCost(), 0.005);
    shoppingBasket.setLoyaltyCard(true);
    assertEquals(17.64, cashier.getFinalShoppingCost(), 0.005);
  }

  @Test 
  public void canGetBogofItems(){
    shoppingBasket.addItemToShopping(pasta);
    shoppingBasket.addItemToShopping(pizza);
    shoppingBasket.addItemToShopping(pizza);
    assertEquals(3, cashier.getShoppingBasket().getShoppingItems().size());
    assertEquals(2, cashier.getBogofItems().size());
  }

  @Test 
  public void canGetFalseIfNoBogofItems(){
    shoppingBasket.addItemToShopping(pasta);
    assertEquals(false, cashier.checkForBogofItems());
  }

  @Test
  public void canGetTrueIfThereAreBogofItems(){
    shoppingBasket.addItemToShopping(pizza);
    assertEquals(true, cashier.checkForBogofItems());
  }



}