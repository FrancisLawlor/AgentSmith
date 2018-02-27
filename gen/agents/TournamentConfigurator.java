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


public class TournamentConfigurator extends ASTRAClass {
	public TournamentConfigurator() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"agents.TournamentConfigurator", new int[] {8,9,8,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.TournamentConfigurator", new int[] {8,27,22,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.TournamentConfigurator", new int[] {9,8,9,30},
						new Predicate("startService", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.TournamentConfigurator","cartago")).startService(
								);
							}
						}
					),
					new ModuleCall("cartago",
						"agents.TournamentConfigurator", new int[] {10,8,10,22},
						new Predicate("link", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.TournamentConfigurator","cartago")).link(
								);
							}
						}
					),
					new Subgoal(
						"agents.TournamentConfigurator", new int[] {12,8,22,5},
						new Goal(
							new Predicate("setupTournamentLoaderArtifact", new Term[] {
								new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentLoaderArtifact",false)
							})
						)
					),
					new Subgoal(
						"agents.TournamentConfigurator", new int[] {13,8,22,5},
						new Goal(
							new Predicate("connectToTournamentLoaderArtifact", new Term[] {})
						)
					),
					new Subgoal(
						"agents.TournamentConfigurator", new int[] {15,8,22,5},
						new Goal(
							new Predicate("setupTournamentArtifact", new Term[] {
								new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentArtifact",false)
							})
						)
					),
					new Subgoal(
						"agents.TournamentConfigurator", new int[] {16,8,22,5},
						new Goal(
							new Predicate("connectToTournamentArtifact", new Term[] {})
						)
					),
					new ModuleCall("cartago",
						"agents.TournamentConfigurator", new int[] {18,8,18,59},
						new Predicate("loadTournament", new Term[] {
							Primitive.newPrimitive("configuration/config.json")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.TournamentConfigurator","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("system",
						"agents.TournamentConfigurator", new int[] {19,8,19,62},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("game_master"),
							Primitive.newPrimitive("agents.GameMaster")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("agents.TournamentConfigurator","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("system",
						"agents.TournamentConfigurator", new int[] {20,8,20,45},
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
								return ((astra.lang.System) intention.getModule("agents.TournamentConfigurator","system")).setMainGoal(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("console",
						"agents.TournamentConfigurator", new int[] {21,8,21,53},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("created agent: game_master")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("agents.TournamentConfigurator","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"agents.TournamentConfigurator", new int[] {24,9,24,87},
			new GoalEvent('+',
				new Goal(
					new Predicate("setupTournamentLoaderArtifact", new Term[] {
						new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentLoaderArtifact",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.TournamentConfigurator", new int[] {24,86,27,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.TournamentConfigurator", new int[] {25,8,25,139},
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
										return ((astra.lang.Cartago) intention.getModule("agents.TournamentConfigurator","cartago")).params(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Cartago) visitor.agent().getModule("agents.TournamentConfigurator","cartago")).params(
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
								return ((astra.lang.Cartago) intention.getModule("agents.TournamentConfigurator","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("console",
						"agents.TournamentConfigurator", new int[] {26,8,26,61},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Tournament loader artifact created")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("agents.TournamentConfigurator","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"agents.TournamentConfigurator", new int[] {29,9,29,48},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToTournamentLoaderArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.TournamentConfigurator", new int[] {29,47,32,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.TournamentConfigurator", new int[] {30,8,30,74},
						new Predicate("lookupArtifact", new Term[] {
							Primitive.newPrimitive("tournament_loader"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.TournamentConfigurator","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"agents.TournamentConfigurator", new int[] {31,8,31,25},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.TournamentConfigurator","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"agents.TournamentConfigurator", new int[] {34,9,34,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("setupTournamentArtifact", new Term[] {
						new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentArtifact",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.TournamentConfigurator", new int[] {34,74,37,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.TournamentConfigurator", new int[] {35,8,35,120},
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
										return ((astra.lang.Cartago) intention.getModule("agents.TournamentConfigurator","cartago")).params(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Cartago) visitor.agent().getModule("agents.TournamentConfigurator","cartago")).params(
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
								return ((astra.lang.Cartago) intention.getModule("agents.TournamentConfigurator","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("console",
						"agents.TournamentConfigurator", new int[] {36,8,36,54},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Tournament artifact created")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("agents.TournamentConfigurator","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"agents.TournamentConfigurator", new int[] {39,9,39,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToTournamentArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.TournamentConfigurator", new int[] {39,41,42,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.TournamentConfigurator", new int[] {40,8,40,67},
						new Predicate("lookupArtifact", new Term[] {
							Primitive.newPrimitive("tournament"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.TournamentConfigurator","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"agents.TournamentConfigurator", new int[] {41,8,41,25},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.TournamentConfigurator","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"agents.TournamentConfigurator", new int[] {44,9,44,98},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("sendTournamentDataAsJsonString", new Term[] {
						new Variable(Type.STRING, "tournamentJsonString",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.TournamentConfigurator","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.TournamentConfigurator", new int[] {44,97,46,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.TournamentConfigurator", new int[] {45,8,45,54},
						new Predicate("createTournament", new Term[] {
							new Variable(Type.STRING, "tournamentJsonString")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.TournamentConfigurator","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"agents.TournamentConfigurator", new int[] {48,9,48,60},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("printTournamentData", new Term[] {})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.TournamentConfigurator","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.TournamentConfigurator", new int[] {48,59,50,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.TournamentConfigurator", new int[] {49,8,49,33},
						new Predicate("printTournament", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.TournamentConfigurator","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			astra.core.Agent agent = new TournamentConfigurator().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
