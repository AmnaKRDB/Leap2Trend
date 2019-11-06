import java.io.*;

public class CountGoogleTrends {

	public static void main(String[] args) {

		String fileName = "D:\\MICCAI\\Google Trends\\GD_ML.csv";
		String fileWriter = "D:\\MICCAI\\CoupleKeywords\\GD_ML\\GoogleTrends.txt";
		int sumCount = 0;
		String line;
		boolean yBoolean = true;
		PrintWriter pw;
		try {
			pw = new PrintWriter(fileWriter);
			for (int year = 2004; year < 2019; year++) {
				yBoolean = true;
				sumCount = 0;
				BufferedReader bf = new BufferedReader(new FileReader(fileName));
				while (((line = bf.readLine()) != null) && yBoolean) {

					int y = Integer.parseInt(line.substring(0, line.indexOf('-')));
					if (y == year) {
						yBoolean = true;
						String nbSearch = line.substring(line.indexOf(',') + 1, line.length());
						sumCount += Integer.parseInt(nbSearch);

					}

				}
				bf.close();
				System.out.println("The number of queries in " + year + " is " + sumCount);
				pw.write("The number of queries in window " + year + " is " + sumCount);
				pw.println();
			}
			pw.close();
			System.out.println();
			System.out.println("All Done, thank you :)  ");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
