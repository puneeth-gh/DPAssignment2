import java.util.*;

public class Player {
	@SuppressWarnings("unused")
	private String PlayerName;
	private LinkedHashMap<Integer,Integer> BidderIdAndPrice=new LinkedHashMap<Integer,Integer>();
    int []temp=new int[2];
	private int bidderCount=0;
	private Observer[] bidders = new Observer[9];
	 public Player(String playerName)
	 {
		 PlayerName=playerName;
	 }
	 public void attach(Observer o)
		{
		 bidders[bidderCount++]= o;
		}
	 public int[] getBidderAndPrice()
	 {
		 temp[0]=new ArrayList<>(BidderIdAndPrice.keySet()).get(BidderIdAndPrice.size() - 1);
		 temp[1]=BidderIdAndPrice.get(temp[0]);
		 return temp;

	 }
	 public void setBidderAndPrice(int bidderid, int biddingprice)
	 {
		 BidderIdAndPrice.put(bidderid, biddingprice);
		 notifyBidding();
	 }
	 public void completeDeal(int bidderid, int biddingprice)
	 {
		 BidderIdAndPrice.put(bidderid, biddingprice);
		 notifyDeal();
	 }
	 private void notifyBidding()
	 {
		 		
				for(int i=0;i<bidderCount;i++)
				{
					
					bidders[i].updateBidding();
				}
				System.out.println("\n");
	 }
	 private void notifyDeal(){
		 for(int i=0;i<bidderCount;i++)
			{
			 bidders[i].updateFinalDeal();
			}
		 
	 }
}
