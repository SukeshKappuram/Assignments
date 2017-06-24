package mypack;

import org.junit.Test;

import junit.framework.Assert;
import mypackage.HostelStudent;
import mypackage.Student;


public class MainClass {
	public static void main(String[] arg){
		Student s1=new Student();
		System.out.println(s1.getStudentId());
		Student s2=new Student(101,"virat",99.3f);
		System.out.println(s2.getStudentId());
		
		s1.display();
		s2.display();
		
		HostelStudent hs=new HostelStudent();
		System.out.println(hs.getStudentId());
		
		hs.display();
	}
	
	
	void display(){
	
	}
}
