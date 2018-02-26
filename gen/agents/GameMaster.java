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
				"agents.GameMaster", new int[] {14,27,39,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {15,8,15,30},
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
						"agents.GameMaster", new int[] {16,8,16,22},
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
						"agents.GameMaster", new int[] {18,8,39,5},
						new Goal(
							new Predicate("setupTournamentArtifact", new Term[] {
								new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentArtifact",false)
							})
						)
					),
					new Subgoal(
						"agents.GameMaster", new int[] {19,8,39,5},
						new Goal(
							new Predicate("connectToTournamentArtifact", new Term[] {})
						)
					),
					new Subgoal(
						"agents.GameMaster", new int[] {21,8,39,5},
						new Goal(
							new Predicate("setupStrategyArtifact", new Term[] {
								new Variable(new ObjectType(cartago.ArtifactId.class), "strategyArtifact",false)
							})
						)
					),
					new Subgoal(
						"agents.GameMaster", new int[] {22,8,39,5},
						new Goal(
							new Predicate("connectToStrategyArtifact", new Term[] {})
						)
					),
					new Subgoal(
						"agents.GameMaster", new int[] {24,8,39,5},
						new Goal(
							new Predicate("setupScoreBoardArtifact", new Term[] {
								new Variable(new ObjectType(cartago.ArtifactId.class), "scoreBoardArtifact",false)
							})
						)
					),
					new Subgoal(
						"agents.GameMaster", new int[] {25,8,39,5},
						new Goal(
							new Predicate("connectToScoreBoardArtifact", new Term[] {})
						)
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {27,8,27,64},
						new Predicate("configureTournament", new Term[] {
							Primitive.newPrimitive("configuration/config.json")
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
						"agents.GameMaster", new int[] {28,8,28,66},
						new Predicate("populateStrategiesMap", new Term[] {
							Primitive.newPrimitive("configuration/config.json")
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
						"agents.GameMaster", new int[] {31,8,31,35},
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
						"agents.GameMaster", new int[] {32,8,32,35},
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
						"agents.GameMaster", new int[] {34,8,34,50},
						new Predicate("numberOfRounds", new Term[] {
							new Variable(Type.INTEGER, "_numberOfRounds",false)
						})
					),
					new Query(
						"agents.GameMaster", new int[] {35,8,35,50},
						new Predicate("numberOfAgents", new Term[] {
							new Variable(Type.INTEGER, "_numberOfAgents",false)
						})
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {37,8,37,77},
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
						"agents.GameMaster", new int[] {38,8,38,26},
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
			"agents.GameMaster", new int[] {41,9,41,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("setupTournamentArtifact", new Term[] {
						new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentArtifact",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {41,74,44,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {42,8,42,120},
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
							new Variable(new ObjectType(cartago.ArtifactId.class), "tournamentArtifact")
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
						"agents.GameMaster", new int[] {43,8,43,54},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Tournament artifact created")
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
			"agents.GameMaster", new int[] {46,9,46,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToTournamentArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {46,41,49,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {47,8,47,67},
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
						"agents.GameMaster", new int[] {48,8,48,25},
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
			"agents.GameMaster", new int[] {51,9,51,73},
			new GoalEvent('+',
				new Goal(
					new Predicate("setupStrategyArtifact", new Term[] {
						new Variable(new ObjectType(cartago.ArtifactId.class), "strategiesArtifact",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {51,72,54,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {52,8,52,118},
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
						"agents.GameMaster", new int[] {53,8,53,52},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Strategy artifact created")
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
			"agents.GameMaster", new int[] {56,9,56,40},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToStrategyArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {56,39,59,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {57,8,57,65},
						new Predicate("lookupArtifact", new Term[] {
							Primitive.newPrimitive("strategy"),
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
						"agents.GameMaster", new int[] {58,8,58,25},
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
			"agents.GameMaster", new int[] {61,9,61,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("setupScoreBoardArtifact", new Term[] {
						new Variable(new ObjectType(cartago.ArtifactId.class), "scoreBoardArtifact",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {61,74,64,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {62,8,62,117},
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
						"agents.GameMaster", new int[] {63,8,63,54},
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
			"agents.GameMaster", new int[] {66,9,66,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToScoreBoardArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {66,41,69,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {67,8,67,68},
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
						"agents.GameMaster", new int[] {68,8,68,25},
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
			"agents.GameMaster", new int[] {71,9,71,66},
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
				"agents.GameMaster", new int[] {71,65,75,5},
				new Statement[] {
					new ModuleCall("system",
						"agents.GameMaster", new int[] {72,8,72,52},
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
						"agents.GameMaster", new int[] {73,8,73,39},
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
						"agents.GameMaster", new int[] {74,8,74,52},
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
			"agents.GameMaster", new int[] {77,9,77,79},
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
				"agents.GameMaster", new int[] {77,78,79,5},
				new Statement[] {
					new BeliefUpdate('+',
						"agents.GameMaster", new int[] {78,8,79,5},
						new Predicate("numberOfAgents", new Term[] {
							new Variable(Type.INTEGER, "_numberOfAgents")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"agents.GameMaster", new int[] {81,9,81,79},
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
				"agents.GameMaster", new int[] {81,78,83,5},
				new Statement[] {
					new BeliefUpdate('+',
						"agents.GameMaster", new int[] {82,8,83,5},
						new Predicate("numberOfRounds", new Term[] {
							new Variable(Type.INTEGER, "_numberOfRounds")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"agents.GameMaster", new int[] {89,9,89,54},
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
				"agents.GameMaster", new int[] {89,53,99,5},
				new Statement[] {
					new Query(
						"agents.GameMaster", new int[] {91,8,91,50},
						new Predicate("numberOfAgents", new Term[] {
							new Variable(Type.INTEGER, "_numberOfAgents",false)
						})
					),
					new Declaration(
						new Variable(Type.INTEGER, "i"),
						"agents.GameMaster", new int[] {92,8,99,5},
						Primitive.newPrimitive(0)
					),
					new While(
						"agents.GameMaster", new int[] {94,8,99,5},
						new Comparison("<",
							new Variable(Type.INTEGER, "i"),
							new Variable(Type.INTEGER, "_numberOfAgents")
						),
						new Block(
							"agents.GameMaster", new int[] {94,36,98,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.STRING, "idString"),
									"agents.GameMaster", new int[] {95,12,98,9},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "i"),
										Primitive.newPrimitive("")
									)
								),
								new Send("agents.GameMaster", new int[] {96,12,96,60},
									new Performative("request"),
									new Variable(Type.STRING, "idString"),
									new Predicate("playerAgentId", new Term[] {
										new Variable(Type.STRING, "idString")
									})
								),
								new Assignment(
									new Variable(Type.INTEGER, "i"),
									"agents.GameMaster", new int[] {97,12,98,9},
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
			"agents.GameMaster", new int[] {101,9,101,70},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "id",false),
				new Predicate("playerAgentId", new Term[] {
					new Variable(Type.STRING, "agentId",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"agents.GameMaster", new int[] {101,69,109,5},
				new Statement[] {
					new Query(
						"agents.GameMaster", new int[] {103,8,103,50},
						new Predicate("numberOfRounds", new Term[] {
							new Variable(Type.INTEGER, "_numberOfRounds",false)
						})
					),
					new Query(
						"agents.GameMaster", new int[] {104,8,104,50},
						new Predicate("numberOfAgents", new Term[] {
							new Variable(Type.INTEGER, "_numberOfAgents",false)
						})
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {106,8,106,50},
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
					),
					new ModuleCall("cartago",
						"agents.GameMaster", new int[] {107,8,107,77},
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
						"agents.GameMaster", new int[] {108,8,108,26},
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
			"agents.GameMaster", new int[] {111,9,111,54},
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
				"agents.GameMaster", new int[] {111,53,114,5},
				new Statement[] {
					new ModuleCall("console",
						"agents.GameMaster", new int[] {112,8,112,46},
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
						"agents.GameMaster", new int[] {113,8,113,33},
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
