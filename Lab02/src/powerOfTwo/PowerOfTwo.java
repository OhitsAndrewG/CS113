package powerOfTwo;

public class PowerOfTwo {
	
	public boolean powerOfTwo(int number) {
		
		if(number % 2 == 0){
			while(number > 1) {
				number = number / 2;
			}
			return number == 1;
			
		}else {
			return false;
		}
		
		
		
	}

}
