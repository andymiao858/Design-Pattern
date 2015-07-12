package com.rabbit.designpattern.behavioral;

public class State1 {

	public static void main(String[] args) {
		Profile profile = new Profile();
		profile.setState(Profile.STATE.INIT);
		StateMachine fsm = new StateMachine();
		fsm.operation(profile, Profile.EVENT.SUBMIT);
		fsm.operation(profile, Profile.EVENT.REJECT);
		fsm.operation(profile, Profile.EVENT.DISMISS);
		fsm.operation(profile, Profile.EVENT.SUBMIT);
		fsm.operation(profile, Profile.EVENT.AGREE);
	}

	public static class StateMachine {
		private StateObject stateObject;

		public void operation(Profile profile, Profile.EVENT event) {
			if (Profile.EVENT.SUBMIT.equals(event)
					&& Profile.STATE.INIT.equals(profile.state)) {
				stateObject = new SubmittedState();
			} else if (Profile.EVENT.AGREE.equals(event)
					&& Profile.STATE.SUBMITTED.equals(profile.state)) {
				stateObject = new FinishState();
			} else if (Profile.EVENT.DISMISS.equals(event)
					&& Profile.STATE.SUBMITTED.equals(profile.state)) {
				stateObject = new FinishState();
			} else if (Profile.EVENT.REJECT.equals(event)
					&& Profile.STATE.SUBMITTED.equals(profile.state)) {
				stateObject = new InitialState();
			} else {
				System.out.println("XXXX--Profile current state is ["
						+ profile.getState() + "], can not operate ["
						+ event.name() + "] event");
			}

			if (stateObject != null) {
				stateObject.operation(profile);
				System.out.println("Profile operate [" + event.name()
						+ "], current state is [" + profile.getState() + "]");
			}
		}

	}

	private static interface StateObject {
		public void operation(Profile profile);
	}

	private static class InitialState implements StateObject {
		@Override
		public void operation(Profile profile) {
			profile.setState(Profile.STATE.INIT);
		}
	}

	private static class SubmittedState implements StateObject {
		@Override
		public void operation(Profile profile) {
			profile.setState(Profile.STATE.SUBMITTED);
		}
	}

	private static class FinishState implements StateObject {
		@Override
		public void operation(Profile profile) {
			profile.setState(Profile.STATE.FINISH);
		}
	}

	private static class Profile {
		public enum STATE {
			INIT, SUBMITTED, FINISH
		}

		public enum EVENT {
			SUBMIT, DISMISS, REJECT, AGREE
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
