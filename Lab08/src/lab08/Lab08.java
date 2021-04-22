package lab08;
import java.util.LinkedList;
import java.util.Queue;

public class Lab08 {

	public static void main(String[] args) {
		Queue<Integer> newQueue = new LinkedList<Integer>();		//note: a queue is fifo
		
		for(int i = 0; i < 21; i ++) {
			newQueue.add(i);
		}
		
		for(int i = 0 ; i < 21; i ++) {
			System.out.println(newQueue.remove());
		}
		
		
		

	}

}
