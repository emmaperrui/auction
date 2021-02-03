import java.util.ArrayList;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }

    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            boolean successful = selectedLot.bidFor((new Bid(bidder, value)));
            if(successful) {
                System.out.println("The bid for lot number " +
                    lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                    " already has a bid of: " +
                    selectedLot.getHighestBid().getValue());
            }
        }
    }

    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber)
    {
        Lot selectedLot = null;
        boolean loteEncontrado = false;
        int index = 0;
        while(!loteEncontrado && index < lots.size()){
            if(lots.get(index).getNumber() == lotNumber){
                loteEncontrado = true;
                selectedLot = lots.get(index);
                System.out.println("El numero seleccionado corresponde al lote " + selectedLot);
            }else{
                index++; 
            }
        }
        return selectedLot;
    }

    /**
     * 
     */
    public Lot removeLot(int number){
        Lot loteBorrado = null;
        if((number >= 1)) {
            loteBorrado = getLot(number);
        }
        if(loteBorrado != null) {
            lots.remove(loteBorrado);
        }
        return loteBorrado;
    }

    public void close(){
        for(Lot lot : lots){
            System.out.print("N�: " + lot.getNumber());
            System.out.print(" - Descripci�n: " + lot.getDescription());
            if(null != lot.getHighestBid() && lot.getHighestBid().getValue() > 0){
                Person bidder = lot.getHighestBid().getBidder();
                String bidderName = "";
                if(bidder != null){
                    bidderName = bidder.getName();
                }
                System.out.print(" - Puja de " + lot.getHighestBid().getValue() + " por " + bidderName);
            }else{
                System.out.print(" - Sin pujas!!");
            }
            System.out.println("");
        }
    }

    public ArrayList<Lot> getUnsold(){
        ArrayList<Lot> unsold = new ArrayList<Lot>();
        for(Lot lot : lots){
            if(lot.getHighestBid() == null || lot.getHighestBid().getValue() <= 0){
                //System.out.println("No hay pujas");
                unsold.add(lot);
            }
        }
        return unsold;
    }
}
