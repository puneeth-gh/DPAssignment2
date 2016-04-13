import java.io.*;


public class AuctionStage
{
 
	public static void main(String[] args) throws IOException
	{
	
	    try
        {
	   
	    BufferedReader in = new BufferedReader(new FileReader("input.txt"));
	 
         String line;
         line=in.readLine();
     do
     {
    	 
	 	 System.out.println("Bidding starts for player "+line);

         Player player=new Player(line);
     
         line=in.readLine();
         int loopCount = Integer.parseInt(line);
         int lineCount=0;
      
             while((line=in.readLine())!=null && lineCount<loopCount)
             {
            	 String[] values = line.split(",");
            	 int str_int[]=new int[values.length];
            	 for (int i=0;i<values.length;i++)
            	 {
            		 str_int[i] = Integer.parseInt(values[i]);
           		 }
           		 new Bidder(player,str_int[0],str_int[1]);
           		 lineCount++;
              }
          
             int setBidderCount = Integer.parseInt(line);
             int line1Count=0;
      
             while((line=in.readLine())!=null && line1Count<setBidderCount)
             {
            	 String[] values = line.split(",");
            	 int str_int[]=new int[values.length];
         
           		for (int i=0;i<values.length;i++)
           		{
           		 str_int[i] = Integer.parseInt(values[i]);
           		
           		}
           		if(line1Count==setBidderCount-1)
           		{	
           			 System.out.println("Bid Winner");
             		 player.completeDeal(str_int[0], str_int[1]);
             		
             	}	 
           		else
           			player.setBidderAndPrice(str_int[0],str_int[1]);
           		
           		line1Count++;
           		
             }
             System.out.println("\n");
     }while(line!=null);
     in.close();
      
        }
             catch( IOException ioException ) {}        

         
	}
}
