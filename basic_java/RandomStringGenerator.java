import java.util.Random;

public class RandomStringGenerator {
	private Random randomGenerator;

	public RandomStringGenerator() {
		randomGenerator = new Random();
	}

	public String generateRandomString(){
		StringBuffer randstr = new StringBuffer();
		int min = 33;
		int max = 126;
		for (int i = 0; i< randomGenerator.nextInt(5) + 1; i++) {
			int rand = randomGenerator.nextInt(max - min + 1) + min;
			randstr.append((char)rand);
		}
		return randstr.toString();
	}
}