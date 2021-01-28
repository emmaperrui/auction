

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class pujaDePrueba.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class pujaDePrueba
{
    private Auction auction1;
    private Person person1;
    private Person person2;

    /**
     * Default constructor for test class pujaDePrueba
     */
    public pujaDePrueba()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        auction1 = new Auction();
        person1 = new Person("Amelia");
        person2 = new Person("Adelaida");
        auction1.enterLot("Vaso");
        auction1.enterLot("mesa");
        auction1.enterLot("silla");
        auction1.enterLot("disco");
        auction1.enterLot("casa");
        auction1.showLots();
        auction1.makeABid(1, person1, 222);
        auction1.makeABid(2, person2, 33);
        auction1.makeABid(2, person1, 36);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
