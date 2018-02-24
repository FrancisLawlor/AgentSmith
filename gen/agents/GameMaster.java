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
			"agents.GameMaster", new int[] {15,9,15,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {15,27,32,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {16,8,16,30},
						new Predicate("startService", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.GameMaster","cartago")).startService(
								);
							}
						}
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {17,8,17,22},
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
						"agents.GameMaster", new int[] {19,8,32,5},
						new Goal(
							new Predicate("setupTournamentArtifact", new Term[] {
								new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentArtifact",false)
							})
						)
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {20,8,20,77},
						new Predicate("lookupArtifact", new Term[] {
							Primitive.newPrimitive("tournament"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentId",false)
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
						"agents.GameMaster", new int[] {21,8,21,35},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentId")
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
					new Subgoal(
						"agents.GameMaster", new int[] {23,8,32,5},
						new Goal(
							new Predicate("setupStrategyArtifact", new Term[] {
								new Variable(new ObjectType(cartago.ArtifactId.class), "strategyArtifact",false)
							})
						)
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {24,8,24,73},
						new Predicate("lookupArtifact", new Term[] {
							Primitive.newPrimitive("strategy"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "strategyId",false)
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
						"agents.GameMaster", new int[] {25,8,25,33},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "strategyId")
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
						"agents.GameMaster", new int[] {27,8,27,89},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentId"),
							new Funct("configureTournament", new Term[] {
								Primitive.newPrimitive("configuration/config.json")
							})
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
						"agents.GameMaster", new int[] {28,8,28,89},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "strategyId"),
							new Funct("populateStrategiesMap", new Term[] {
								Primitive.newPrimitive("configuration/config.json")
							})
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
						"agents.GameMaster", new int[] {29,8,29,30},
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
			"agents.GameMaster", new int[] {34,9,34,58},
			new GoalEvent('+',
				new Goal(
					new Predicate("setupTournamentArtifact", new Term[] {
						new Variable(new ObjectType(cartago.ArtifactId.class), "C",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {34,57,37,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {35,8,35,103},
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
							new Variable(new ObjectType(cartago.ArtifactId.class), "C")
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
						"agents.GameMaster", new int[] {36,8,36,54},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Tournament artifact Created")
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
			"agents.GameMaster", new int[] {39,9,39,73},
			new GoalEvent('+',
				new Goal(
					new Predicate("setupStrategyArtifact", new Term[] {
						new Variable(new ObjectType(cartago.ArtifactId.class), "strategiesArtifact",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {39,72,42,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {40,8,40,118},
						new Predicate("makeArtifact", new Term[] {
							Primitive.newPrimitive("strategy"),
							Primitive.newPrimitive("strategies.core.StrategiesArtifact"),
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
							new Variable(new ObjectType(cartago.ArtifactId.class), "strategiesArtifact")
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
						"agents.GameMaster", new int[] {41,8,41,52},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Strategy artifact Created")
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
			"agents.GameMaster", new int[] {44,9,44,88},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("createAgent", new Term[] {
						new Variable(Type.STRING, "agentId",false),
						new Variable(Type.STRING, "agentStrategy",false)
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
				"agents.GameMaster", new int[] {44,87,48,5},
				new Statement[] {
					new ModuleCall("system",
						"agents.GameMaster", new int[] {45,8,45,52},
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
						"agents.GameMaster", new int[] {46,8,46,52},
						new Predicate("setMainGoal", new Term[] {
							new Variable(Type.STRING, "agentId"),
							new ListTerm(new Term[] {
								new Variable(Type.STRING, "agentStrategy")
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
						"agents.GameMaster", new int[] {47,8,47,52},
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
			"agents.GameMaster", new int[] {50,9,50,92},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("startNewRound", new Term[] {
						new Variable(Type.INTEGER, "numberOfAgents",false),
						new Variable(Type.INTEGER, "numberOfRounds",false)
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
				"agents.GameMaster", new int[] {50,91,60,5},
				new Statement[] {
					new ModuleCall("console",
						"agents.GameMaster", new int[] {52,12,52,70},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Starting round "),
								Operator.newOperator('+',
									new Variable(Type.INTEGER, "numberOfRounds"),
									Primitive.newPrimitive(" !")
								)
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
					),
					new Declaration(
						new Variable(Type.INTEGER, "i"),
						"agents.GameMaster", new int[] {53,8,60,5},
						Primitive.newPrimitive(0)
					),
					new While(
						"agents.GameMaster", new int[] {55,8,60,5},
						new Comparison("<",
							new Variable(Type.INTEGER, "i"),
							new Variable(Type.INTEGER, "numberOfAgents")
						),
						new Block(
							"agents.GameMaster", new int[] {55,35,59,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.STRING, "idString"),
									"agents.GameMaster", new int[] {56,12,59,9},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "i"),
										Primitive.newPrimitive("")
									)
								),
								new Send("agents.GameMaster", new int[] {57,12,57,60},
									new Performative("request"),
									new Variable(Type.STRING, "idString"),
									new Predicate("playerAgentId", new Term[] {
										new Variable(Type.STRING, "idString")
									})
								),
								new Assignment(
									new Variable(Type.INTEGER, "i"),
									"agents.GameMaster", new int[] {58,12,59,9},
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
			"agents.GameMaster", new int[] {62,9,62,70},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "id",false),
				new Predicate("playerAgentId", new Term[] {
					new Variable(Type.STRING, "agentId",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {62,69,65,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {64,8,64,26},
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
			"agents.GameMaster", new int[] {67,9,67,54},
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
				"agents.GameMaster", new int[] {67,53,69,5},
				new Statement[] {
					new ModuleCall("console",
						"agents.GameMaster", new int[] {68,8,68,46},
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
