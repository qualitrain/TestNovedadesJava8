package qtx.test.interFunc;

public class PromediadorInt implements IPromediador<Integer> {

	@Override
	public double promediar(Integer... nums) {
		int total = 0;
		for(Integer n : nums) {			
			total += (int)n;
		}
		
		return total / (double) nums.length;
	}

}

