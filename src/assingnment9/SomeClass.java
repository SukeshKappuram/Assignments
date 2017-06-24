package assingnment9;

public class SomeClass implements Runnable {
	boolean obj1_ok = false;
	SomeClass(){
	Thread obj1 = new Thread(this, "o");
	Thread obj2 = new Thread(this, "x");
	obj2.start( ) ;
	obj1.start( ) ;
	}

	public synchronized void my( ) {
		if(Thread.currentThread( ).getName( ).equals("x")) { while( !obj1_ok) {
		try {
		System.out.print("A"); wait( ) ;
		} catch(InterruptedException e) { }
		}
		}
		System.out.print("B"); obj1_ok = true ; notifyAll( ) ;
		}

		public void run( ) { my( ) ;
		}


	public static void main(String[] args) {
		SomeClass obj = new SomeClass( ) ;
	}
}
