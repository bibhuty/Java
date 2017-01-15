package usefulInterfaces;

public class AgeOfBride implements Comparable<AgeOfBride>{
	String name;
	int age;
	
	public AgeOfBride(String name,int age) {
		this.name=name;
		this.age=age;
	}

	@Override
	public int compareTo(AgeOfBride a) {
		if(age==a.age)return 0;
		else if(age>a.age)return 1;
		else return -1;
	}

}
