package com.rabbit.designpattern.behavioral;


public class State2 {

	public static void main(String[] args) {
		Profile profile = new Profile();
		profile.setState(Profile.STATE.INIT);
		StateMachine fsm = new StateMachine();
		fsm.submit(profile);
		fsm.reject(profile);
		fsm.dismiss(profile);
		fsm.submit(profile);
		fsm.agree(profile);
	}
	
	public static class StateMachine{
		private StateObject stateObject;
	
		private StateObject initState;
		private StateObject submittedState;
		private StateObject finishState;
		
		public StateMachine(){
			initState = new InitialState(this);
			submittedState = new SubmittedState(this);
			finishState = new FinishState(this);
			stateObject = initState;
		}
		
		public void setStateObject(StateObject stateObject) {
			this.stateObject = stateObject;
		}
		
		public void submit(Profile profile){
			this.stateObject.submit(profile);
		}
		
		public void reject(Profile profile){
			this.stateObject.reject(profile);
		}
		
		public void dismiss(Profile profile){
			this.stateObject.dismiss(profile);
		}
		
		public void agree(Profile profile){
			this.stateObject.agree(profile);
		}

		public StateObject getInitState() {
			return initState;
		}

		public void setInitState(StateObject initState) {
			this.initState = initState;
		}

		public StateObject getSubmittedState() {
			return submittedState;
		}

		public void setSubmittedState(StateObject submittedState) {
			this.submittedState = submittedState;
		}

		public StateObject getFinishState() {
			return finishState;
		}

		public void setFinishState(StateObject finishState) {
			this.finishState = finishState;
		}
		
	}

	private static interface StateObject {
		public void submit(Profile profile);
		public void reject(Profile profile);
		public void dismiss(Profile profile);
		public void agree(Profile profile);
	}

	private static class InitialState implements StateObject {
		
		private StateMachine stateMachine;
		
		public InitialState(StateMachine stateMachine) {
			this.stateMachine = stateMachine;
		}

		@Override
		public void submit(Profile profile) {
			Profile.STATE prevState = profile.getState();
			profile.setState(Profile.STATE.SUBMITTED);
			stateMachine.setStateObject(stateMachine.getSubmittedState());
			System.out.println("transit from State [" + prevState
					+ "] to State [" + profile.getState() + "] via event [SUBMIT]");
		}

		@Override
		public void reject(Profile profile) {
			System.out.println("XXXX--can not transit from State ["
					+ profile.getState() + "] via event [REJECT]");
			
		}

		@Override
		public void dismiss(Profile profile) {
			System.out.println("XXXX--can not transit from State ["
					+ profile.getState() + "] via event [DISMISS]");
			
			
		}

		@Override
		public void agree(Profile profile) {
			System.out.println("XXXX--can not transit from State ["
					+ profile.getState() + "] via event [AGREE]");
			
			
		}
		
		
	}

	private static class SubmittedState implements StateObject {

		private StateMachine stateMachine;
		
		public SubmittedState(StateMachine stateMachine) {
			this.stateMachine = stateMachine;
		}
		
		@Override
		public void submit(Profile profile) {
			System.out.println("XXXX--can not transit from State ["
					+ profile.getState() + "] via event [SUBMIT]");
			
		}

		@Override
		public void reject(Profile profile) {
			Profile.STATE prevState = profile.getState();
			profile.setState(Profile.STATE.INIT);
			stateMachine.setStateObject(stateMachine.getInitState());
			System.out.println("transit from State [" + prevState
					+ "] to State [" + profile.getState() + "] via event [REJECT]");
			
		}

		@Override
		public void dismiss(Profile profile) {
			Profile.STATE prevState = profile.getState();
			profile.setState(Profile.STATE.FINISH);
			stateMachine.setStateObject(stateMachine.getFinishState());
			System.out.println("transit from State [" + prevState
					+ "] to State [" + profile.getState() + "] via event [DISMISS]");
			
		}

		@Override
		public void agree(Profile profile) {
			Profile.STATE prevState = profile.getState();
			profile.setState(Profile.STATE.FINISH);
			stateMachine.setStateObject(stateMachine.getInitState());
			System.out.println("transit from State [" + prevState
					+ "] to State [" + profile.getState() + "] via event [AGREE]");
		}

	}

	private static class FinishState implements StateObject {
		
		private StateMachine stateMachine;
		
		public FinishState(StateMachine stateMachine) {
			this.stateMachine = stateMachine;
		}
		

		@Override
		public void submit(Profile profile) {
			System.out.println("XXXX--can not transit from State ["
					+ profile.getState() + "] via event [SUBMIT]");
			
		}

		@Override
		public void reject(Profile profile) {
			System.out.println("XXXX--can not transit from State ["
					+ profile.getState() + "] via event [REJECT]");
		}

		@Override
		public void dismiss(Profile profile) {
			System.out.println("XXXX--can not transit from State ["
					+ profile.getState() + "] via event [DISMISS]");			
		}

		@Override
		public void agree(Profile profile) {
			System.out.println("XXXX--can not transit from State ["
					+ profile.getState() + "] via event [AGREE]");
		}
		
	}

	private static class Profile {
		public enum STATE {
			INIT, SUBMITTED, FINISH
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
