package agents.astra;
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
			"agents.astra.Player", new int[] {15,9,15,36},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new ListTerm(new Term[] {
							new Variable(Type.STRING, "strategy",false)
						})
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.astra.Player", new int[] {15,35,18,5},
				new Statement[] {
					new ModuleCall("console",
						"agents.astra.Player", new int[] {16,8,16,33},
						new Predicate("println", new Term[] {
							new Variable(Type.STRING, "strategy")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("agents.astra.Player","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"agents.astra.Player", new int[] {17,8,18,5},
						new Goal(
							new Predicate("setup", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"agents.astra.Player", new int[] {20,9,20,20},
			new GoalEvent('+',
				new Goal(
					new Predicate("setup", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"agents.astra.Player", new int[] {20,19,24,5},
				new Statement[] {
					new ModuleCall("cartago",
						"agents.astra.Player", new int[] {21,8,21,22},
						new Predicate("link", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.astra.Player","cartago")).link(
								);
							}
						}
					),
					new ModuleCall("cartago",
						"agents.astra.Player", new int[] {22,8,22,67},
						new Predicate("lookupArtifact", new Term[] {
							Primitive.newPrimitive("tournament"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.astra.Player","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"agents.astra.Player", new int[] {23,8,23,25},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("agents.astra.Player","cartago")).auto_action(intention,evaluate(intention,predicate));
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
		fragment.addModule("M",astra.lang.Math.class,agent);
		fragment.addModule("P",astra.lang.Prelude.class,agent);
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
