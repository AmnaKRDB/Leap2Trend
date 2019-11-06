import java.io.*;
import java.util.*;

public class MatrixFromFile {

	static double[][] createMatrix(BufferedReader bf, String fileName, int n) throws IOException {
		double generatedMatrix[][] = new double[n][n];
		String line;
		StringTokenizer st;
		int i = 0, j;
		bf = new BufferedReader(new FileReader(fileName));
		while ((line = bf.readLine()) != null) {
			st = new StringTokenizer(line);
			j = 0;
			while (st.hasMoreTokens()) {
				Double d = Double.parseDouble(st.nextToken());
				generatedMatrix[i][j] = d;
				j++;

			}
			i++;

		}
		bf.close();

		return generatedMatrix;

	}

	// function to print the given matrix
	static void printMat(double mat[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		try {
			String fileName = "D:\\Incremental Windows\\wind16_87_04\\topK_SimilarityMatrix.txt";
			BufferedReader bf = new BufferedReader(new FileReader(fileName));
			System.out.println("Creation of matrix from the file " + fileName);
			System.out.println("<------------------------------> ");
			double[][] matrix = createMatrix(bf, fileName, 20);
			printMat(matrix, 20);
			System.out.println("<------------------------------> ");
			System.out.println("Done!!!!");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
