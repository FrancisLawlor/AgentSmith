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
			"agents.Player", new int[] {14,9,14,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {14,27,18,5},
				new Statement[] {
					new Subgoal(
						"agents.Player", new int[] {15,8,18,5},
						new Goal(
							new Predicate("connectToTournamentArtifact", new Term[] {})
						)
					),
					new Subgoal(
						"agents.Player", new int[] {16,8,18,5},
						new Goal(
							new Predicate("connectToStrategyArtifact", new Term[] {})
						)
					),
					new Subgoal(
						"agents.Player", new int[] {17,8,18,5},
						new Goal(
							new Predicate("connectToScoreBoardArtifact", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"agents.Player", new int[] {20,9,20,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToTournamentArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {20,41,24,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {21,8,21,22},
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
					new ModuleCall("cartago",
						"agents.Player", new int[] {22,8,22,67},
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
						"agents.Player", new int[] {23,8,23,25},
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
			"agents.Player", new int[] {26,9,26,40},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToStrategyArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {26,39,30,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {27,8,27,22},
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
					new ModuleCall("cartago",
						"agents.Player", new int[] {28,8,28,73},
						new Predicate("lookupArtifact", new Term[] {
							Primitive.newPrimitive("strategy"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "strategyId",false)
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
						"agents.Player", new int[] {29,8,29,33},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "strategyId")
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
			"agents.Player", new int[] {32,9,32,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToScoreBoardArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {32,41,36,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {33,8,33,22},
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
					new ModuleCall("cartago",
						"agents.Player", new int[] {34,8,34,78},
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
						"agents.Player", new int[] {35,8,35,35},
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
			"agents.Player", new int[] {38,9,38,70},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "id",false),
				new Predicate("playerAgentId", new Term[] {
					new Variable(Type.STRING, "agentId",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {38,69,41,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {40,8,40,43},
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
			"agents.Player", new int[] {43,9,43,91},
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
				"agents.Player", new int[] {43,90,48,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {44,8,48,5},
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
							"agents.Player", new int[] {44,33,47,9},
							new Statement[] {
								new ModuleCall("cartago",
									"agents.Player", new int[] {46,12,46,55},
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
			"agents.Player", new int[] {50,9,50,80},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("generatedGuess", new Term[] {
						new Variable(Type.STRING, "agentId",false),
						new Variable(Type.INTEGER, "guess",false)
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
				"agents.Player", new int[] {50,79,56,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {51,8,56,5},
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
							"agents.Player", new int[] {51,33,55,9},
							new Statement[] {
								new ModuleCall("console",
									"agents.Player", new int[] {52,12,52,70},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.STRING, "agentId"),
											Operator.newOperator('+',
												Primitive.newPrimitive("\'s generated guess: "),
												new Variable(Type.INTEGER, "guess")
											)
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return false;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("agents.Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new ModuleCall("cartago",
									"agents.Player", new int[] {53,12,53,44},
									new Predicate("playGame", new Term[] {
										new Variable(Type.STRING, "agentId"),
										new Variable(Type.INTEGER, "guess")
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
									"agents.Player", new int[] {54,12,54,45},
									new Predicate("recordBid", new Term[] {
										new Variable(Type.STRING, "agentId"),
										new Variable(Type.INTEGER, "guess")
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
			"agents.Player", new int[] {58,9,58,81},
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
				"agents.Player", new int[] {58,80,64,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {59,8,64,5},
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
							"agents.Player", new int[] {59,33,63,9},
							new Statement[] {
								new ModuleCall("cartago",
									"agents.Player", new int[] {61,12,61,36},
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
								),
								new ModuleCall("cartago",
									"agents.Player", new int[] {62,12,62,49},
									new Predicate("recordPayoff", new Term[] {
										new Variable(Type.STRING, "agentId"),
										new Variable(Type.FLOAT, "payoff")
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
				"agents.Player", new int[] {66,103,69,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {68,8,68,72},
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
			"agents.Player", new int[] {71,9,71,69},
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
				"agents.Player", new int[] {71,68,77,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {72,8,77,5},
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
							"agents.Player", new int[] {72,33,76,9},
							new Statement[] {
								new Send("agents.Player", new int[] {74,12,74,57},
									new Performative("request"),
									Primitive.newPrimitive("main"),
									new Predicate("playerAgentId", new Term[] {
										Primitive.newPrimitive("main")
									})
								),
								new ModuleCall("cartago",
									"agents.Player", new int[] {75,12,75,37},
									new Predicate("testSingleAgent", new Term[] {}),
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
