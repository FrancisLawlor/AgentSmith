package gui.scenes;

import gui.panes.TournamentPlayingPane;
import gui.utils.GUIDimensions;
import javafx.scene.Scene;

public class TournamentPlayingScene extends Scene {	
	public TournamentPlayingScene(TournamentPlayingPane tournamentPlayingPane) {
		super(tournamentPlayingPane, GUIDimensions.MAIN_WINDOW_WIDTH, GUIDimensions.MAIN_WINDOW_HEIGHT);
	}
}
