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
			"agents.Player", new int[] {14,9,14,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToTournamentArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {14,41,18,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {15,8,15,22},
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
						"agents.Player", new int[] {16,8,16,67},
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
						"agents.Player", new int[] {17,8,17,25},
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
			"agents.Player", new int[] {20,9,20,40},
			new GoalEvent('+',
				new Goal(
					new Predicate("connectToStrategyArtifact", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {20,39,25,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.Player", new int[] {22,8,22,22},
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
						"agents.Player", new int[] {23,8,23,73},
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
						"agents.Player", new int[] {24,8,24,33},
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
			"agents.Player", new int[] {27,9,27,65},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "id",false),
				new Predicate("playerAgentId", new Term[] {
					new Variable(Type.STRING, "Id",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"agents.Player", new int[] {27,64,31,5},
				new Statement[] {
					new Send("agents.Player", new int[] {28,8,28,43},
						new Performative("agree"),
						new Variable(Type.STRING, "id"),
						new Predicate("playerAgentId", new Term[] {
							new Variable(Type.STRING, "Id")
						})
					),
					new Subgoal(
						"agents.Player", new int[] {29,8,31,5},
						new Goal(
							new Predicate("connectToTournamentArtifact", new Term[] {})
						)
					),
					new ModuleCall("cartago",
						"agents.Player", new int[] {30,8,30,38},
						new Predicate("getNumberOfOptions", new Term[] {
							new Variable(Type.STRING, "Id")
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
			"agents.Player", new int[] {33,9,33,79},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Funct("numberOfOptions", new Term[] {
						new Variable(Type.STRING, "agentId",false),
						new Variable(Type.INTEGER, "num",false)
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
				"agents.Player", new int[] {33,78,38,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {34,8,38,5},
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
							"agents.Player", new int[] {34,33,37,9},
							new Statement[] {
								new Subgoal(
									"agents.Player", new int[] {35,12,37,9},
									new Goal(
										new Predicate("connectToStrategyArtifact", new Term[] {})
									)
								),
								new ModuleCall("cartago",
									"agents.Player", new int[] {36,12,36,43},
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
										new Variable(Type.INTEGER, "num")
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
			"agents.Player", new int[] {40,9,40,80},
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
				"agents.Player", new int[] {40,79,45,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {41,8,45,5},
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
							"agents.Player", new int[] {41,33,44,9},
							new Statement[] {
								new ModuleCall("console",
									"agents.Player", new int[] {42,12,42,58},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.STRING, "agentId"),
											Operator.newOperator('+',
												Primitive.newPrimitive(": guess: "),
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
									"agents.Player", new int[] {43,12,43,44},
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
			"agents.Player", new int[] {47,9,47,81},
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
				"agents.Player", new int[] {47,80,52,5},
				new Statement[] {
					new If(
						"agents.Player", new int[] {48,8,52,5},
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
							"agents.Player", new int[] {48,33,51,9},
							new Statement[] {
								new ModuleCall("console",
									"agents.Player", new int[] {49,12,49,72},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.STRING, "id"),
											Operator.newOperator('+',
												Primitive.newPrimitive(" "),
												Operator.newOperator('+',
													new Variable(Type.STRING, "agentId"),
													Operator.newOperator('+',
														Primitive.newPrimitive(": payoff - "),
														new Variable(Type.FLOAT, "payoff")
													)
												)
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
									"agents.Player", new int[] {50,12,50,36},
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
			"agents.Player", new int[] {54,9,54,104},
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
				"agents.Player", new int[] {54,103,58,5},
				new Statement[] {
					new ModuleCall("console",
						"agents.Player", new int[] {55,8,55,74},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								new Variable(Type.STRING, "id"),
								Operator.newOperator('+',
									Primitive.newPrimitive(" "),
									Operator.newOperator('+',
										new Variable(Type.STRING, "updateDataKey"),
										Operator.newOperator('+',
											Primitive.newPrimitive(": "),
											new Variable(Type.INTEGER, "updateDataValue")
										)
									)
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
					new Subgoal(
						"agents.Player", new int[] {56,8,58,5},
						new Goal(
							new Predicate("connectToStrategyArtifact", new Term[] {})
						)
					),
					new ModuleCall("cartago",
						"agents.Player", new int[] {57,8,57,72},
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
