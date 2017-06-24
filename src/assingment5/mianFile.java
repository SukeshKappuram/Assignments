package assingment5;

	class mianFile{
		
	}

	class B extends Thread{
		public String x;
		B(String in) { x = in;
		}
		public void run() { for(int i=1; i<5; i++) {
			System.out.println(x+"-"+i);
		}
		}

	}
	class A {
			public static void main(String[] args) {
				B obj1 = new B("o");
				B obj2 = new B("x");
				obj1.setPriority(1);
				obj2.setPriority(10); 
				obj1.start();
				obj2.start();

		}
	}


