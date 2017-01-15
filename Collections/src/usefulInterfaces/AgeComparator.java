package usefulInterfaces;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class AgeComparator implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		AgeOfBride a1=(AgeOfBride)o1;
		AgeOfBride a2=(AgeOfBride)o2;
		
		if(a1.age==a2.age)return 0;
		else if(a1.age>a2.age)return -1;
		else return 1;
	}

}
