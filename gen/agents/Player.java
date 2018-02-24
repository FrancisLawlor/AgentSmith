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
				"agents.Player", new int[] {14,27,17,5},
				new Statement[] {
					new Subgoal(
						"agents.Player", new int[] {15,8,17,5},
						new Goal(
							new Predicate("connectToTournamentArtifact", new Term[] {})
						)
					),
					new Subgoal(
						"agents.Player", new int[] {16,8,17,5},
						new Goal(
							new Predicate("connectToStrategyArtifact", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"agents.Player", new int[] {19,9,19,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToTournamentArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {19,41,23,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {20,8,20,22},
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
						"agents.Player", new int[] {21,8,21,67},
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
						"agents.Player", new int[] {22,8,22,25},
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
			"agents.Player", new int[] {25,9,25,40},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToStrategyArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {25,39,29,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {26,8,26,22},
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
						"agents.Player", new int[] {27,8,27,73},
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
						"agents.Player", new int[] {28,8,28,33},
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
			"agents.Player", new int[] {31,9,31,70},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "id",false),
				new Predicate("playerAgentId", new Term[] {
					new Variable(Type.STRING, "agentId",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {31,69,34,5},
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
				"agents.Player", new int[] {36,90,41,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {37,8,41,5},
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
							"agents.Player", new int[] {37,33,40,9},
							new Statement[] {
								new ModuleCall("cartago",
									"agents.Player", new int[] {39,12,39,55},
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
			"agents.Player", new int[] {43,9,43,80},
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
				"agents.Player", new int[] {43,79,48,5},
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
									"agents.Player", new int[] {46,12,46,44},
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
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"agents.Player", new int[] {50,9,50,81},
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
				"agents.Player", new int[] {50,80,55,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {51,8,55,5},
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
							"agents.Player", new int[] {51,33,54,9},
							new Statement[] {
								new ModuleCall("cartago",
									"agents.Player", new int[] {53,12,53,36},
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
					)
				}
			)
		));
		addRule(new Rule(
			"agents.Player", new int[] {57,9,57,104},
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
				"agents.Player", new int[] {57,103,60,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {59,8,59,72},
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
			"agents.Player", new int[] {62,9,62,69},
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
				"agents.Player", new int[] {62,68,67,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {63,8,67,5},
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
							"agents.Player", new int[] {63,33,66,9},
							new Statement[] {
								new Send("agents.Player", new int[] {65,12,65,57},
									new Performative("request"),
									Primitive.newPrimitive("main"),
									new Predicate("playerAgentId", new Term[] {
										Primitive.newPrimitive("main")
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
