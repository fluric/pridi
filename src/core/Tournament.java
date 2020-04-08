package core;

import java.util.ArrayList;
import java.util.List;
import prisonerdilemma.PlayerPD;
import prisonerdilemma.PlayerPositionPD;
import prisonerdilemma.PrisonersDilemmaRule;
import prisonerdilemma.StrategiesPD;

public enum Tournament {
    ;

    // TODO The tournament should be more generalized and automated
    public static void main(String[] args) {
       	List<Player> players = new ArrayList<Player>();
        players.add(new PlayerPD(StrategiesPD.TIT4TAT_PD.create()));
        players.add(new PlayerPD(StrategiesPD.GREEDY_PD.create()));
        players.add(new PlayerPD(StrategiesPD.FRIENDLY_PD.create()));
        players.add(new PlayerPD(StrategiesPD.RESENTFUL_PD.create()));
        double[][] averageReward = new double[players.size()][players.size()-1]; 
        runTournament(players, averageReward,0, 1);
        evaluateTournament(averageReward);
   	}

   	public static void runTournament(List<Player> players,double[][] averageReward, int iteration,int nrGame){
   		
   		if(players.size()>2){
	   		for (int i = 1; i < players.size(); i++){
	        	Game game = new Game(new PlayerPD(players.get(0).getStrategy(), PlayerPositionPD.PLAYER_A), 
	        						new PlayerPD(players.get(i).getStrategy(), PlayerPositionPD.PLAYER_B),
	        						 new PrisonersDilemmaRule(), 10);       	
	        	System.out.println("Game " + (nrGame));
	        	nrGame++;
	        	game.run();
	        	averageReward[iteration][iteration+i-1]=game.getAverageRewardPlayerA();
	        	averageReward[iteration+i ][iteration]=game.getAverageRewardPlayerB();

	   		}
       		
       		players.remove(0);
       		iteration++;
	       	runTournament(players, averageReward, iteration, nrGame);
	       	

   		}
   		else if(players.size()>1){
   			
        	Game game = new Game(new PlayerPD(players.get(0).getStrategy(), PlayerPositionPD.PLAYER_A), 
        						new PlayerPD(players.get(1).getStrategy(), PlayerPositionPD.PLAYER_B),
        						 new PrisonersDilemmaRule(), 10);       	
        	System.out.println("Game " + (nrGame));
        	nrGame++;
        	game.run();	
        	averageReward[iteration][iteration]=game.getAverageRewardPlayerA();
	        averageReward[iteration+1 ][iteration]=game.getAverageRewardPlayerB();


	   		

   		}
   	}

	public static void evaluateTournament(double[][] averageReward){
		
		double[] resultReward = new double[averageReward.length];
		double sum=0;
		for (int j = 0; j < averageReward.length; j++){

			for (int i = 0; i < averageReward.length-1; i++){
				sum+=averageReward[j][i];
			}
			resultReward[j]=sum/(averageReward.length-1);
			System.out.println("Player " + j + " has a total average of " + resultReward[j]);
			sum=0;
		}

		int winnerPosition=getWinnerPosition(resultReward);

		System.out.println("PLAYER " + winnerPosition + " IS THE WINNER!!! He has a total average of " + resultReward[winnerPosition]);

	}

	public static int getWinnerPosition(double[] resultReward){
		int largest = 0;
		for ( int i = 1; i < resultReward.length; i++ )
		{
		    if ( resultReward[i] > resultReward[largest] ){
		    	largest = i;
		    }
		}
		return largest;	
	}


}
