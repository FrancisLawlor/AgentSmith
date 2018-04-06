package gui.scenes;

import java.util.Map;

import gui.panes.TournamentPhasePane;
import gui.utils.GUIDimensions;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class TournamentPhaseScene extends Scene {	
	private TournamentPhasePane tournamentPhasePane;

	public TournamentPhaseScene(TournamentPhasePane tournamentPhasePane) {
		super(tournamentPhasePane, GUIDimensions.MAIN_WINDOW_WIDTH, GUIDimensions.MAIN_WINDOW_HEIGHT);
		this.tournamentPhasePane = tournamentPhasePane;
	}
	
	public Text getPhaseDataText() {
		return this.tournamentPhasePane.getPhaseDataText();
	}
	
	public Button getContinueButton() {
		return this.tournamentPhasePane.getContinueButton();
	}

	public void updateRoundData(Map<String, Float> displayData) {
		this.tournamentPhasePane.updateRoundData(displayData);	
	}
}
