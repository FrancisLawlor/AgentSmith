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


public class Player extends ASTRAClass {
	public Player() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"agents.Player", new int[] {16,9,16,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {16,27,20,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {17,8,17,22},
						new Predicate("link", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.Player","cartago")).link(
								);
							}
						}
					),
					new Subgoal(
						"agents.Player", new int[] {18,8,20,5},
						new Goal(
							new Predicate("connectToTournamentArtifact", new Term[] {})
						)
					),
					new Subgoal(
						"agents.Player", new int[] {19,8,20,5},
						new Goal(
							new Predicate("connectToScoreBoardArtifact", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"agents.Player", new int[] {22,9,22,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToTournamentArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {22,41,25,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {23,8,23,67},
						new Predicate("lookupArtifact", new Term[] {
							Primitive.newPrimitive("tournament"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.Player","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"agents.Player", new int[] {24,8,24,25},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.Player","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"agents.Player", new int[] {27,9,27,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToScoreBoardArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {27,41,30,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {28,8,28,78},
						new Predicate("lookupArtifact", new Term[] {
							Primitive.newPrimitive("score_board"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "scoreBoardId",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.Player","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"agents.Player", new int[] {29,8,29,35},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "scoreBoardId")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.Player","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"agents.Player", new int[] {32,9,32,70},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "id",false),
				new Predicate("playerAgentId", new Term[] {
					new Variable(Type.STRING, "agentId",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {32,69,34,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {33,8,33,43},
						new Predicate("getNumberOfOptions", new Term[] {
							new Variable(Type.STRING, "agentId")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.Player","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"agents.Player", new int[] {36,9,36,91},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("numberOfOptions", new Term[] {
						new Variable(Type.STRING, "agentId",false),
						new Variable(Type.INTEGER, "amountOfOptions",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.Player","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {36,90,40,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {37,8,40,5},
						new Comparison("==",
							new Variable(Type.STRING, "agentId"),
							new ModuleTerm("S", Type.STRING,
								new Predicate("name", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.System) intention.getModule("agents.Player","S")).name(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.System) visitor.agent().getModule("agents.Player","S")).name(
										);
									}
								}
							)
						),
						new Block(
							"agents.Player", new int[] {37,33,39,9},
							new Statement[] {
								new ModuleCall("cartago",
									"agents.Player", new int[] {38,12,38,55},
									new Predicate("getGuess", new Term[] {
										new ModuleTerm("S", Type.STRING,
											new Predicate("name", new Term[] {}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((astra.lang.System) intention.getModule("agents.Player","S")).name(
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.System) visitor.agent().getModule("agents.Player","S")).name(
													);
												}
											}
										),
										new Variable(Type.INTEGER, "amountOfOptions")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Cartago) intention.getModule("agents.Player","cartago")).auto_action(intention,evaluate(intention,predicate));
										}
										public boolean suppressNotification() {
											return true;
										}
									}
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"agents.Player", new int[] {42,9,42,100},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("generatedGuess", new Term[] {
						new Variable(Type.STRING, "agentId",false),
						new Variable(Type.INTEGER, "guess",false),
						new Variable(Type.INTEGER, "numberOfAgents",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.Player","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {42,99,47,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {43,8,47,5},
						new Comparison("==",
							new Variable(Type.STRING, "agentId"),
							new ModuleTerm("S", Type.STRING,
								new Predicate("name", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.System) intention.getModule("agents.Player","S")).name(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.System) visitor.agent().getModule("agents.Player","S")).name(
										);
									}
								}
							)
						),
						new Block(
							"agents.Player", new int[] {43,33,46,9},
							new Statement[] {
								new BeliefUpdate('+',
									"agents.Player", new int[] {44,12,46,9},
									new Predicate("numberOfAgents", new Term[] {
										new Variable(Type.INTEGER, "numberOfAgents")
									})
								),
								new ModuleCall("cartago",
									"agents.Player", new int[] {45,12,45,61},
									new Predicate("recordBid", new Term[] {
										new Variable(Type.STRING, "agentId"),
										new Variable(Type.INTEGER, "guess"),
										new Variable(Type.INTEGER, "numberOfAgents")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Cartago) intention.getModule("agents.Player","cartago")).auto_action(intention,evaluate(intention,predicate));
										}
										public boolean suppressNotification() {
											return true;
										}
									}
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"agents.Player", new int[] {49,9,49,82},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("bidReceived", new Term[] {
						new Variable(Type.STRING, "agentId",false),
						new Variable(Type.INTEGER, "currentBid",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.Player","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {49,81,53,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {50,8,53,5},
						new Comparison("==",
							new Variable(Type.STRING, "agentId"),
							new ModuleTerm("S", Type.STRING,
								new Predicate("name", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.System) intention.getModule("agents.Player","S")).name(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.System) visitor.agent().getModule("agents.Player","S")).name(
										);
									}
								}
							)
						),
						new Block(
							"agents.Player", new int[] {50,33,52,9},
							new Statement[] {
								new ModuleCall("cartago",
									"agents.Player", new int[] {51,12,51,50},
									new Predicate("playGame", new Term[] {
										new ModuleTerm("S", Type.STRING,
											new Predicate("name", new Term[] {}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((astra.lang.System) intention.getModule("agents.Player","S")).name(
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.System) visitor.agent().getModule("agents.Player","S")).name(
													);
												}
											}
										),
										new Variable(Type.INTEGER, "currentBid")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Cartago) intention.getModule("agents.Player","cartago")).auto_action(intention,evaluate(intention,predicate));
										}
										public boolean suppressNotification() {
											return true;
										}
									}
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"agents.Player", new int[] {55,9,55,81},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("gameFinished", new Term[] {
						new Variable(Type.STRING, "agentId",false),
						new Variable(Type.FLOAT, "payoff",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.Player","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {55,80,60,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {56,8,60,5},
						new Comparison("==",
							new Variable(Type.STRING, "agentId"),
							new ModuleTerm("S", Type.STRING,
								new Predicate("name", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.System) intention.getModule("agents.Player","S")).name(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.System) visitor.agent().getModule("agents.Player","S")).name(
										);
									}
								}
							)
						),
						new Block(
							"agents.Player", new int[] {56,33,59,9},
							new Statement[] {
								new Query(
									"agents.Player", new int[] {57,12,57,54},
									new Predicate("numberOfAgents", new Term[] {
										new Variable(Type.INTEGER, "_numberOfAgents",false)
									})
								),
								new ModuleCall("cartago",
									"agents.Player", new int[] {58,12,58,66},
									new Predicate("recordPayoff", new Term[] {
										new Variable(Type.STRING, "agentId"),
										new Variable(Type.FLOAT, "payoff"),
										new Variable(Type.INTEGER, "_numberOfAgents")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Cartago) intention.getModule("agents.Player","cartago")).auto_action(intention,evaluate(intention,predicate));
										}
										public boolean suppressNotification() {
											return true;
										}
									}
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"agents.Player", new int[] {62,9,62,59},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("allPayoffsRecorded", new Term[] {})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.Player","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {62,58,64,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {63,8,63,32},
						new Predicate("receivedPayoff", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.Player","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"agents.Player", new int[] {66,9,66,104},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("sendUpdateKeyValuePair", new Term[] {
						new Variable(Type.STRING, "updateDataKey",false),
						new Variable(Type.INTEGER, "updateDataValue",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.Player","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {66,103,68,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {67,8,67,72},
						new Predicate("updateStrategy", new Term[] {
							new ModuleTerm("S", Type.STRING,
								new Predicate("name", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.System) intention.getModule("agents.Player","S")).name(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.System) visitor.agent().getModule("agents.Player","S")).name(
										);
									}
								}
							),
							new Variable(Type.STRING, "updateDataKey"),
							new Variable(Type.INTEGER, "updateDataValue")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.Player","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"agents.Player", new int[] {70,9,70,69},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("updateReceived", new Term[] {
						new Variable(Type.STRING, "agentId",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("agents.Player","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {70,68,74,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {71,8,74,5},
						new Comparison("==",
							new Variable(Type.STRING, "agentId"),
							new ModuleTerm("S", Type.STRING,
								new Predicate("name", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.System) intention.getModule("agents.Player","S")).name(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.System) visitor.agent().getModule("agents.Player","S")).name(
										);
									}
								}
							)
						),
						new Block(
							"agents.Player", new int[] {71,33,73,9},
							new Statement[] {
								new Send("agents.Player", new int[] {72,12,72,71},
									new Performative("request"),
									Primitive.newPrimitive("game_master"),
									new Predicate("playerAgentId", new Term[] {
										Primitive.newPrimitive("game_master")
									})
								)
							}
						)
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
		fragment.addModule("S",astra.lang.System.class,agent);
		fragment.addModule("console",astra.lang.Console.class,agent);
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
			astra.core.Agent agent = new Player().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
