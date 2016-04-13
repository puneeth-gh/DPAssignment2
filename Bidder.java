
public class Bidder extends Observer {
	int[] temp;
	private int bidderId;
	private int budget;
 
	public Bidder(Player pl,int bid,int b)
	{
		player=pl;
		bidderId=bid;
		budget=b;		
		player.attach(this);

	}
	@Override
	public void updateBidding() {
		
		temp=player.getBidderAndPrice();
		System.out.println(bidderId+" : ["+temp[0]+", "+temp[1]+"]");
		if(bidderId==temp[0])
		{
			budget=budget-10;
		}
		
		
	}
	@Override
	public void updateFinalDeal() 
	{
		temp=player.getBidderAndPrice();
		if(bidderId==temp[0])
		{
			budget=budget-temp[1];
		}
		System.out.println(bidderId+" : ["+budget+", "+temp[0]+"]");
	}

}
