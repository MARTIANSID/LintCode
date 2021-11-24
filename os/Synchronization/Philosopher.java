package os.Synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

// Note that in this implementation a philosopher picks up BOTH chopsticks at a time.
// Another solution can be that a chopstick acts as a monitor object.

// Monitor object class. 
// Provides synchronized interfaces and keeps track of state variables.
class Monitor {
	// Private data.
	private int numOfPhilosophers;
	final Lock lock;
	private enum States {hungry, thinking, eating};
	private States [] state;
	final Condition [] cond;	
	// Constructor.
	Monitor(int numOfPhil){
		this.numOfPhilosophers = numOfPhil;
		lock = new ReentrantLock();
		state = new States[numOfPhilosophers];
		cond = new Condition[numOfPhilosophers];
		// Set initial states and the conditions of the philosophers.
		for(int i = 0; i < numOfPhilosophers; i++){
			state[i] = States.thinking;
			cond[i] = lock.newCondition();
		}
	}
	// Synchronized interface methods.
	// Pick up both chopstics for a philosopher i.
	public void PickUp(int i){
		lock.lock();
		try{
			// Indicate that I want to take chopsticks.
			state[i] = States.hungry;
			// Pick up chopsticks if both neighbors are not eating.
			if( ( state[(i-1+numOfPhilosophers)%numOfPhilosophers] != States.eating ) &&					
			    (state[(i+1)%numOfPhilosophers] != States.eating) ){
				System.out.format("Philosopher %d picks up left chopstick\n", i+1);
				System.out.format("Philosopher %d picks up right chopstick\n", i+1);
				state[i] = States.eating;
			} 
			else {	// If at least one neighbor is eating, then wait. 
				try {
					cond[i].await();
					// Eat after waiting.
					System.out.format("Philosopher %d picks up left chopstick\n", i+1);
					System.out.format("Philosopher %d picks up right chopstick\n", i+1);
					state[i] = States.eating;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}// end else
		}// end try
		finally{
			lock.unlock();
		}
	}
	// Put down both chopstics.
	public void PutDown(int i){
		lock.lock();
		try{
			System.out.format("Philosopher %d puts down right chopstick\n", i+1);
			System.out.format("Philosopher %d puts down left chopstick\n", i+1);
			state[i] = States.thinking;
			// Tell the left neighbor about the possibility to eat.
			int left = (i - 1 + numOfPhilosophers)%numOfPhilosophers;
			int left2 = (i - 2 + numOfPhilosophers)%numOfPhilosophers;
			if( (state[left] == States.hungry) &&
				(state[left2] != States.eating) ){
				cond[left].signal();
			}
			// Tell the right neighbor about the possibility to eat
			if( (state[(i+1)%numOfPhilosophers] == States.hungry) &&
				(state[(i+2)%numOfPhilosophers] != States.eating) ){
				cond[(i+1)%numOfPhilosophers].signal();
			}
		}// end try
		finally {
			lock.unlock();
		}
	}		
}

// This class represents a thread which holds a philosopher.
public class Philosopher implements Runnable {
	// Private data.
	private int myId;
	private int timesToEat;		// Times to eat.
	private Monitor mon;
	private Thread t;	
	private int sleepLength;		// How long to sleep during eating.
	// Constructor.
	Philosopher(int id, int numToEat, Monitor m){
		this.myId = id;
		this.timesToEat = numToEat;
		this.mon = m;
		sleepLength = 10;			// Make a pause of 10 ms while eating.
		t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		int count = 1;
		while(count <= timesToEat ){
			mon.PickUp(myId);
			eat(count);
			mon.PutDown(myId);
			++count;
		}		
	}
	// Print the state of the philosopher.
	void eat(int count){
		System.out.format("Philosopher %d eats (%d times)\n", myId+1, count);
		// Sleep a little bit.
		try {
		    Thread.sleep(sleepLength);
		} 
		catch (InterruptedException e) {}
	}
	
	public static void main(String[] args) {
		int numOfPhilosophers = 5;
		int timesToEat = 5;
		
		Monitor mon = new Monitor(numOfPhilosophers);
		Philosopher [] p = new Philosopher[numOfPhilosophers];
		
		System.out.println("Dinner is starting!");
		System.out.println("");
		
		// Start philosopher threads.
		for(int i = 0; i < numOfPhilosophers; i++)
			p[i] = new Philosopher(i, timesToEat, mon);
		
		// Suspend the current thread until the philosophers have not done.
		for(int i = 0; i < numOfPhilosophers; i++)
			try {
				p[i].t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("");
		System.out.println("Dinner is over!");		
	}
}