package tournament.data;

public class TournamentDataWrapper {
	private TournamentData tournamentData;
	
	public TournamentDataWrapper(TournamentData tournamentData) {
		this.tournamentData = tournamentData;
	}
	
	public TournamentData getTournamentData() {
		return this.tournamentData;
	}
	
	public void setTournamentData(TournamentData tournamentData) {
		this.tournamentData = tournamentData;
	}
}
