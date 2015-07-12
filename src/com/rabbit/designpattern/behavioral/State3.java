package com.rabbit.designpattern.behavioral;

import java.util.HashMap;
import java.util.Map;

public class State3 {

	public static void main(String[] args) {
		Profile profile = new Profile();
		profile.setState(Profile.STATE.INIT);
		Profile.getStateMachine().transitTo(profile, Profile.EVENT.SUBMIT);
		Profile.getStateMachine().transitTo(profile, Profile.EVENT.REJECT);
		Profile.getStateMachine().transitTo(profile, Profile.EVENT.DISMISS);
		Profile.getStateMachine().transitTo(profile, Profile.EVENT.SUBMIT);
		Profile.getStateMachine().transitTo(profile, Profile.EVENT.AGREE);
		Profile.getStateMachine().transitTo(profile, Profile.EVENT.SUBMIT);
	}

	private static class StateMachine {

		private Map<Profile.STATE, StateEntry> entry = new HashMap<Profile.STATE, StateEntry>();

		private StateEntry initState;

		public StateMachine() {
			this.initState = new StateEntry(null);
		}

		public boolean transitTo(Profile profile, Profile.EVENT event) {
			Profile.STATE currentState = profile.getState();
			StateEntry temp = null;
			if (currentState == null) {
				temp = initState;
			} else {
				temp = entry.get(currentState);

			}
			if (temp != null) {
				Transition trans = temp.nextStates.get(event);
				if (trans == null) {
					System.out.println("XXXX--can not transit from State ["
							+ profile.getState() + "] via event ["
							+ event.name() + "]");
					return false;
				}
				Profile.STATE nextState = trans.getNextState();
				if (nextState != null) {
					Profile.STATE prevState = profile.getState();
					profile.setState(nextState);
					System.out.println("transit from State [" + prevState
							+ "] to State [" + nextState + "] via event ["
							+ event.name() + "]");
					return true;
				} else {
					System.out.println("XXXX--can not transit from State ["
							+ profile.getState() + "] via event ["
							+ event.name() + "]");
					return false;
				}
			} else {
				System.out.println("XXXX--can not transit from State ["
						+ profile.getState() + "] via event ["
						+ event.name() + "]");
				return false;
			}

		}

		public void addTransition(Profile.STATE currentState,
				Profile.EVENT event, Profile.STATE nextState) {
			Transition trans = new Transition(currentState, event, nextState);
			StateEntry temp = null;
			if (currentState == null) {
				temp = initState;
			} else {
				temp = entry.get(currentState);
				if (temp == null) {
					temp = new StateEntry(currentState);
					entry.put(currentState, temp);
				}
			}
			temp.addTransition(event, trans);

		}

		public static class Transition {

			private Profile.EVENT event;

			private Profile.STATE currentState;

			private Profile.STATE nextState;

			public Transition(Profile.STATE currentState, Profile.EVENT event,
					Profile.STATE nextState) {
				this.event = event;
				this.currentState = currentState;
				this.nextState = nextState;
			}

			public Profile.STATE getNextState() {
				return nextState;
			}

			public Profile.STATE getCurrentState() {
				return currentState;
			}

			public Profile.EVENT getEvent() {
				return event;
			}

		}

		public static class StateEntry {
			private Map<Profile.EVENT, Transition> nextStates;
			private Profile.STATE state;

			public StateEntry(Profile.STATE state) {
				this.state = state;
				nextStates = new HashMap<Profile.EVENT, Transition>();
			}

			private void addTransition(Profile.EVENT event,
					Transition transition) {
				if (nextStates.containsKey(event)) {
					Transition exist = nextStates.get(event);
					throw new RuntimeException(
							"States already contains a transition from ["
									+ exist.getCurrentState() + "] to ["
									+ exist.getNextState() + "] via event ["
									+ exist.getEvent().name()
									+ "], \n conflict with transition from ["
									+ transition.getCurrentState() + "] to ["
									+ transition.getNextState()
									+ "] via event ["
									+ transition.getEvent().name() + "]");
				} else {
					nextStates.put(event, transition);
				}
			}
		}

	}

	private static class Profile {
		public enum STATE {
			INIT, SUBMITTED, FINISH
		}

		public enum EVENT {
			SUBMIT, DISMISS, REJECT, AGREE
		}

		private static StateMachine stateMachine = new StateMachine();

		public static StateMachine getStateMachine() {
			return stateMachine;
		}

		static {
			stateMachine.addTransition(STATE.INIT, 		EVENT.SUBMIT,	STATE.SUBMITTED);
			stateMachine.addTransition(STATE.SUBMITTED, EVENT.DISMISS,	STATE.FINISH);
			stateMachine.addTransition(STATE.SUBMITTED, EVENT.REJECT,	STATE.INIT);
			stateMachine.addTransition(STATE.SUBMITTED, EVENT.AGREE,	STATE.FINISH);
		}

		private STATE state;

		public STATE getState() {
			return state;
		}

		public void setState(STATE state) {
			this.state = state;
		}

	}

}
