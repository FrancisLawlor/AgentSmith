package integration;

import agents.AgentSystemInitialiser;
import agents.TournamentRestarter;
import astra.core.ASTRAClassNotFoundException;
import astra.core.AgentCreationException;
import astra.core.Scheduler;
import astra.execution.AdaptiveSchedulerStrategy;
import astra.formula.Goal;
import astra.formula.Predicate;
import astra.term.ListTerm;
import astra.term.Term;

public class AgentSystemIntegrator {
	public static void initialiseAgentSystem(String tournamentDataJSONString, String resultsFileSavePath) {		
		Scheduler.setStrategy(new AdaptiveSchedulerStrategy());

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new AgentSystemInitialiser(tournamentDataJSONString, resultsFileSavePath).newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { new ListTerm() })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};					
	}

	public static void startNextNRounds(int currentPhase) {
		String name = java.lang.System.getProperty("astra.name", "tournament_restarter" + currentPhase);
		try {
			astra.core.Agent agent = new TournamentRestarter().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { new ListTerm() })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};					
	}
}
