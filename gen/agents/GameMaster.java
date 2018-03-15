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


public class GameMaster extends ASTRAClass {
	public GameMaster() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"agents.GameMaster", new int[] {14,9,14,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {14,27,32,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {15,8,15,22},
						new Predicate("link", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).link(
								);
							}
						}
					),
					new Subgoal(
						"agents.GameMaster", new int[] {17,8,32,5},
						new Goal(
							new Predicate("connectToTournamentArtifact", new Term[] {})
						)
					),
					new Subgoal(
						"agents.GameMaster", new int[] {19,8,32,5},
						new Goal(
							new Predicate("setupScoreBoardArtifact", new Term[] {
								new Variable(new ObjectType(cartago.ArtifactId.class), "scoreBoardArtifact",false)
							})
						)
					),
					new Subgoal(
						"agents.GameMaster", new int[] {20,8,32,5},
						new Goal(
							new Predicate("connectToScoreBoardArtifact", new Term[] {})
						)
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {22,8,22,30},
						new Predicate("createAgents", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {24,8,24,35},
						new Predicate("getNumberOfAgents", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {25,8,25,35},
						new Predicate("getNumberOfRounds", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new Query(
						"agents.GameMaster", new int[] {27,8,27,50},
						new Predicate("numberOfRounds", new Term[] {
							new Variable(Type.INTEGER, "_numberOfRounds",false)
						})
					),
					new Query(
						"agents.GameMaster", new int[] {28,8,28,50},
						new Predicate("numberOfAgents", new Term[] {
							new Variable(Type.INTEGER, "_numberOfAgents",false)
						})
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {30,8,30,77},
						new Predicate("createNewRoundScoreRecorder", new Term[] {
							new Variable(Type.INTEGER, "_numberOfAgents"),
							new Variable(Type.INTEGER, "_numberOfRounds")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {31,8,31,26},
						new Predicate("newRound", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"agents.GameMaster", new int[] {34,9,34,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToTournamentArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {34,41,37,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {35,8,35,67},
						new Predicate("lookupArtifact", new Term[] {
							Primitive.newPrimitive("tournament"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {36,8,36,25},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"agents.GameMaster", new int[] {39,9,39,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("setupScoreBoardArtifact", new Term[] {
						new Variable(new ObjectType(cartago.ArtifactId.class), "scoreBoardArtifact",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {39,74,42,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {40,8,40,117},
						new Predicate("makeArtifact", new Term[] {
							Primitive.newPrimitive("score_board"),
							Primitive.newPrimitive("games.score.ScoreBoardArtifact"),
							new ModuleTerm("cartago", new ObjectType(java.lang.Object[].class),
								new Predicate("params", new Term[] {
									new ListTerm(new Term[] {

									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).params(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Cartago) visitor.agent().getModule("agents.GameMaster","cartago")).params(
											(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new Variable(new ObjectType(cartago.ArtifactId.class), "scoreBoardArtifact")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("console",
						"agents.GameMaster", new int[] {41,8,41,54},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Scoreboard artifact created")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("agents.GameMaster","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"agents.GameMaster", new int[] {44,9,44,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToScoreBoardArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {44,41,47,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {45,8,45,68},
						new Predicate("lookupArtifact", new Term[] {
							Primitive.newPrimitive("score_board"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {46,8,46,25},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"agents.GameMaster", new int[] {49,9,49,66},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("createAgent", new Term[] {
						new Variable(Type.STRING, "agentId",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.GameMaster","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {49,65,53,5},
				new Statement[] {
					new ModuleCall("system",
						"agents.GameMaster", new int[] {50,8,50,52},
						new Predicate("createAgent", new Term[] {
							new Variable(Type.STRING, "agentId"),
							Primitive.newPrimitive("agents.Player")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("agents.GameMaster","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("system",
						"agents.GameMaster", new int[] {51,8,51,39},
						new Predicate("setMainGoal", new Term[] {
							new Variable(Type.STRING, "agentId"),
							new ListTerm(new Term[] {

							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("agents.GameMaster","system")).setMainGoal(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("console",
						"agents.GameMaster", new int[] {52,8,52,52},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("created agent: "),
								new Variable(Type.STRING, "agentId")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("agents.GameMaster","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"agents.GameMaster", new int[] {55,9,55,79},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("storeNumberOfAgents", new Term[] {
						new Variable(Type.INTEGER, "_numberOfAgents",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.GameMaster","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {55,78,57,5},
				new Statement[] {
					new BeliefUpdate('+',
						"agents.GameMaster", new int[] {56,8,57,5},
						new Predicate("numberOfAgents", new Term[] {
							new Variable(Type.INTEGER, "_numberOfAgents")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"agents.GameMaster", new int[] {59,9,59,79},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("storeNumberOfRounds", new Term[] {
						new Variable(Type.INTEGER, "_numberOfRounds",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.GameMaster","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {59,78,61,5},
				new Statement[] {
					new BeliefUpdate('+',
						"agents.GameMaster", new int[] {60,8,61,5},
						new Predicate("numberOfRounds", new Term[] {
							new Variable(Type.INTEGER, "_numberOfRounds")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"agents.GameMaster", new int[] {63,9,63,54},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("startNewRound", new Term[] {})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.GameMaster","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {63,53,73,5},
				new Statement[] {
					new Query(
						"agents.GameMaster", new int[] {65,8,65,50},
						new Predicate("numberOfAgents", new Term[] {
							new Variable(Type.INTEGER, "_numberOfAgents",false)
						})
					),
					new Declaration(
						new Variable(Type.INTEGER, "i"),
						"agents.GameMaster", new int[] {66,8,73,5},
						Primitive.newPrimitive(0)
					),
					new While(
						"agents.GameMaster", new int[] {68,8,73,5},
						new Comparison("<",
							new Variable(Type.INTEGER, "i"),
							new Variable(Type.INTEGER, "_numberOfAgents")
						),
						new Block(
							"agents.GameMaster", new int[] {68,36,72,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.STRING, "idString"),
									"agents.GameMaster", new int[] {69,12,72,9},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "i"),
										Primitive.newPrimitive("")
									)
								),
								new Send("agents.GameMaster", new int[] {70,12,70,60},
									new Performative("request"),
									new Variable(Type.STRING, "idString"),
									new Predicate("playerAgentId", new Term[] {
										new Variable(Type.STRING, "idString")
									})
								),
								new Assignment(
									new Variable(Type.INTEGER, "i"),
									"agents.GameMaster", new int[] {71,12,72,9},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "i"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"agents.GameMaster", new int[] {75,9,75,70},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "id",false),
				new Predicate("playerAgentId", new Term[] {
					new Variable(Type.STRING, "agentId",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {75,69,79,5},
				new Statement[] {
					new Query(
						"agents.GameMaster", new int[] {77,8,77,50},
						new Predicate("numberOfAgents", new Term[] {
							new Variable(Type.INTEGER, "_numberOfAgents",false)
						})
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {78,8,78,50},
						new Predicate("storeCurrentRound", new Term[] {
							new Variable(Type.INTEGER, "_numberOfAgents")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"agents.GameMaster", new int[] {81,9,81,68},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("finishedStoringCurrentRound", new Term[] {})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.GameMaster","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {81,67,88,5},
				new Statement[] {
					new ModuleCall("console",
						"agents.GameMaster", new int[] {82,8,82,58},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Finished storing current round.")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("agents.GameMaster","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Query(
						"agents.GameMaster", new int[] {83,8,83,50},
						new Predicate("numberOfRounds", new Term[] {
							new Variable(Type.INTEGER, "_numberOfRounds",false)
						})
					),
					new Query(
						"agents.GameMaster", new int[] {84,8,84,50},
						new Predicate("numberOfAgents", new Term[] {
							new Variable(Type.INTEGER, "_numberOfAgents",false)
						})
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {86,8,86,77},
						new Predicate("createNewRoundScoreRecorder", new Term[] {
							new Variable(Type.INTEGER, "_numberOfAgents"),
							new Variable(Type.INTEGER, "_numberOfRounds")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {87,8,87,26},
						new Predicate("newRound", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"agents.GameMaster", new int[] {90,9,90,54},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("endTournament", new Term[] {})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.GameMaster","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {90,53,93,5},
				new Statement[] {
					new ModuleCall("console",
						"agents.GameMaster", new int[] {91,8,91,46},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Tournament is over.")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("agents.GameMaster","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {92,8,92,33},
						new Predicate("printTournament", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			astra.core.Agent agent = new GameMaster().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
