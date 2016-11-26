package org.gardler.biglittlechallenge.olympics.tournament.event;

import java.util.ArrayList;
import java.util.List;

import org.gardler.biglittlechallenge.olympics.model.Character;
import org.gardler.biglittlechallenge.olympics.model.Player;
import org.gardler.biglittlechallenge.olympics.tournament.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Track100m extends Event {
	
	private static Logger logger = LoggerFactory.getLogger(Track100m.class);
	
	/**
	 * Create a new event involving the players provided.
	 * @param players
	 */
	public Track100m(List<Player> players) {
		super("100m Sprint", players);
	}
	
    /**
     * Play the 100M sprint with the supplied players.
     * 
     * @param players
     */
	public void playHand() {
		List <Character> characters = new ArrayList<Character>();
		List <Integer> ratings = new ArrayList<Integer>();
		
		int numOfPlayers = players.size();
		for (int i = 0; i < numOfPlayers; i++) {
			Character character = players.get(i).playCharacter();
			characters.add(character);
			Integer rating = character.getSpeed() + character.getReactions();
			ratings.add(rating);
		}
		    	
		Player winner = null;
    	Integer highestRating = 0;
    	for (int i = 0; i < numOfPlayers; i++ ) {
    		if (highestRating < ratings.get(i)) {
    			highestRating = ratings.get(i);
    			winner = players.get(i);
    		}
    	}
    	
    	recordWinner(winner);
	}
}
