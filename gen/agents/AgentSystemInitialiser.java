package agents;
/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.core.*;
import astra.execution.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.reasoner.util.*;


public class AgentSystemInitialiser extends ASTRAClass {
	public AgentSystemInitialiser(String tournamentJSONString, String resultsFilePath) {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"agents.AgentSystemInitialiser", new int[] {12,9,12,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.AgentSystemInitialiser", new int[] {12,27,26,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.AgentSystemInitialiser", new int[] {13,8,13,30},
						new Predicate("startService", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.AgentSystemInitialiser","cartago")).startService(
								);
							}
						}
					),
					new ModuleCall("cartago",
						"agents.AgentSystemInitialiser", new int[] {14,8,14,22},
						new Predicate("link", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.AgentSystemInitialiser","cartago")).link(
								);
							}
						}
					),
					new Subgoal(
						"agents.AgentSystemInitialiser", new int[] {16,8,26,5},
						new Goal(
							new Predicate("setupTournamentLoaderArtifact", new Term[] {
								new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentLoaderArtifact",false)
							})
						)
					),
					new Subgoal(
						"agents.AgentSystemInitialiser", new int[] {17,8,26,5},
						new Goal(
							new Predicate("connectToTournamentLoaderArtifact", new Term[] {})
						)
					),
					new Subgoal(
						"agents.AgentSystemInitialiser", new int[] {19,8,26,5},
						new Goal(
							new Predicate("setupTournamentArtifact", new Term[] {
								new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentArtifact",false)
							})
						)
					),
					new Subgoal(
						"agents.AgentSystemInitialiser", new int[] {20,8,26,5},
						new Goal(
							new Predicate("connectToTournamentArtifact", new Term[] {})
						)
					),
					new ModuleCall("cartago",
						"agents.AgentSystemInitialiser", new int[] {22,8,22,41},
						new Predicate("createTournament", new Term[] {
							Primitive.newPrimitive(tournamentJSONString)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.AgentSystemInitialiser","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("system",
						"agents.AgentSystemInitialiser", new int[] {23,8,23,62},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("game_master"),
							Primitive.newPrimitive("agents.GameMaster")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("agents.AgentSystemInitialiser","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("system",
						"agents.AgentSystemInitialiser", new int[] {24,8,24,45},
						new Predicate("setMainGoal", new Term[] {
							Primitive.newPrimitive("game_master"),
							new ListTerm(new Term[] {

							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("agents.AgentSystemInitialiser","system")).setMainGoal(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("console",
						"agents.AgentSystemInitialiser", new int[] {25,8,25,53},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("created agent: game_master")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("agents.AgentSystemInitialiser","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"agents.AgentSystemInitialiser", new int[] {28,9,28,87},
			new GoalEvent('+',
				new Goal(
					new Predicate("setupTournamentLoaderArtifact", new Term[] {
						new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentLoaderArtifact",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.AgentSystemInitialiser", new int[] {28,86,31,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.AgentSystemInitialiser", new int[] {29,8,29,139},
						new Predicate("makeArtifact", new Term[] {
							Primitive.newPrimitive("tournament_loader"),
							Primitive.newPrimitive("tournament.core.TournamentLoaderArtifact"),
							new ModuleTerm("cartago", new ObjectType(java.lang.Object[].class),
								new Predicate("params", new Term[] {
									new ListTerm(new Term[] {

									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Cartago) intention.getModule("agents.AgentSystemInitialiser","cartago")).params(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Cartago) visitor.agent().getModule("agents.AgentSystemInitialiser","cartago")).params(
											(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentLoaderArtifact")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.AgentSystemInitialiser","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("console",
						"agents.AgentSystemInitialiser", new int[] {30,8,30,61},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Tournament loader artifact created")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("agents.AgentSystemInitialiser","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"agents.AgentSystemInitialiser", new int[] {33,9,33,48},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToTournamentLoaderArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.AgentSystemInitialiser", new int[] {33,47,36,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.AgentSystemInitialiser", new int[] {34,8,34,74},
						new Predicate("lookupArtifact", new Term[] {
							Primitive.newPrimitive("tournament_loader"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.AgentSystemInitialiser","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"agents.AgentSystemInitialiser", new int[] {35,8,35,25},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.AgentSystemInitialiser","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"agents.AgentSystemInitialiser", new int[] {38,9,38,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("setupTournamentArtifact", new Term[] {
						new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentArtifact",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.AgentSystemInitialiser", new int[] {38,74,41,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.AgentSystemInitialiser", new int[] {39,8,39,120},
						new Predicate("makeArtifact", new Term[] {
							Primitive.newPrimitive("tournament"),
							Primitive.newPrimitive("tournament.core.TournamentArtifact"),
							new ModuleTerm("cartago", new ObjectType(java.lang.Object[].class),
								new Predicate("params", new Term[] {
									new ListTerm(new Term[] {

									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Cartago) intention.getModule("agents.AgentSystemInitialiser","cartago")).params(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Cartago) visitor.agent().getModule("agents.AgentSystemInitialiser","cartago")).params(
											(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentArtifact")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.AgentSystemInitialiser","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("console",
						"agents.AgentSystemInitialiser", new int[] {40,8,40,54},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Tournament artifact created")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("agents.AgentSystemInitialiser","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"agents.AgentSystemInitialiser", new int[] {43,9,43,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToTournamentArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.AgentSystemInitialiser", new int[] {43,41,46,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.AgentSystemInitialiser", new int[] {44,8,44,67},
						new Predicate("lookupArtifact", new Term[] {
							Primitive.newPrimitive("tournament"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.AgentSystemInitialiser","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"agents.AgentSystemInitialiser", new int[] {45,8,45,25},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.AgentSystemInitialiser","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"agents.AgentSystemInitialiser", new int[] {48,9,48,70},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "id",false),
				new Predicate("playerAgentId", new Term[] {
					new Variable(Type.STRING, "agentId",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"agents.AgentSystemInitialiser", new int[] {48,69,50,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.AgentSystemInitialiser", new int[] {49,8,49,35},
						new Predicate("saveResults", new Term[] {
							Primitive.newPrimitive(resultsFilePath)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.AgentSystemInitialiser","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("cartago",astra.lang.Cartago.class,agent);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
		return fragment;
	}

	public static void main(String[] args) {
		Scheduler.setStrategy(new AdaptiveSchedulerStrategy());
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new AgentSystemInitialiser(args[0], args[1]).newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
