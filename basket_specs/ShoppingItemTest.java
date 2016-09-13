import static org.junit.Assert.*;
import org.junit.*;
import basket.*;
import java.util.*;

public class ShoppingItemTest {

  ShoppingItem pasta;
  
  @Before 
  public void before(){
    pasta = new ShoppingItem("pasta", 1.50f, false);
  }

  @Test
  public void canGetName(){
    assertEquals("pasta", pasta.getName());
  }

  @Test
  public void canGetBogof(){
    assertEquals(false, pasta.getBogof());
  }

  @Test
  public void canGetValue(){
    assertEquals(1.50f, pasta.getPrice(), 0.005);
  }

}  