import java.io.*;

public class Jump {

	int[] returnTab(String fileName) throws IOException {
		int[] rankTab = new int[15];
		int i = 0;
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = bf.readLine()) != null) {
			int rankPos = Integer.parseInt(line);
			rankTab[i] = rankPos;
			i++;

		}
		bf.close();
		return rankTab;

	}

	public static void main(String args[]) {
		String couple = "TS_NN";
		String fileName = "D:\\MICCAI\\CoupleKeywords\\Sliding CoupleKeywords\\" + couple + "\\" + couple + "_TrueRankedPosition.txt";
		String fileJump = "D:\\MICCAI\\CoupleKeywords\\Sliding CoupleKeywords\\" + couple + "\\" + couple + "_Jump.txt";
		try {
			PrintWriter pw = new PrintWriter(fileJump);
			int[] tabRank = new Jump().returnTab(fileName);
			// int[] tabJump = new int[14];
			int jump = 0;
			int i = 0;
			System.out.print(jump + " || ");
			pw.write(jump + " || ");
			do {
				// System.out.println(tabRank[i]);
				jump += tabRank[i] - tabRank[i + 1];
				System.out.print(jump + " || ");
				pw.write(jump + " || ");
				i++;

			} while (i < tabRank.length - 1);
			pw.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
