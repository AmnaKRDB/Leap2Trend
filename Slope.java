
public class Slope {
	public static void main(String[] args) {

		double meanX = 0;
		double meanY = 0;
		double sumX = 0;
		double sumY = 0;
		int x1 = 0;
		int x2 = 1;
		int x3 = 2;
		int x4 = 3;
		//Google Trends
		int y1 = 422;
		int y2 = 433;
		int y3 = 450;
		int y4 = 550;
		int year = 2006;

		if (year < 2016) {

			sumX += x1 + x2 + x3 + x4;
			sumY += y1 + y2 + y3 + y4;
			meanX += sumX / 4;
			meanY += sumY / 4;

			double slope = ((x1 - meanX) * (y1 - meanY) + (x2 - meanX) * (y2 - meanY) + (x3 - meanX) * (y3 - meanY)
					+ (x4 - meanX) * (y4 - meanY))
					/ (Math.pow((x1 - meanX), 2) + Math.pow((x2 - meanX), 2) + Math.pow((x3 - meanX), 2)
							+ Math.pow((x4 - meanX), 2));
			System.out.println("The slope is " + slope);

		} else {
			sumX += x1 + x2 + x3;
			sumY += y1 + y2 + y3;
			meanX += sumX / 3;
			meanY += sumY / 3;

			double slope = ((x1 - meanX) * (y1 - meanY) + (x2 - meanX) * (y2 - meanY) + (x3 - meanX) * (y3 - meanY))
					/ (Math.pow((x1 - meanX), 2) + Math.pow((x2 - meanX), 2) + Math.pow((x3 - meanX), 2));
			System.out.println("The slope is " + slope);

		}

	}

}
