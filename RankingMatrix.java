
// Java implementation to 
// sort the given matrix 
//import java.io.*; 
//import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.*;

class RankingMatrix {

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

	static int SIZE = 10;

	// function to sort the given matrix
	static double[][] sortMat(double mat[][], int n) {
		// temporary matrix of size n^2
		Double temp[] = new Double[n * n];
		double RankedMatrix[][] = new double[n][n];
		int k = 0;

		// copy the elements of matrix
		// one by one into temp[]
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				temp[k++] = mat[i][j];

		// sort temp[]
		Arrays.sort(temp, Collections.reverseOrder());

		// copy the elements of temp[]
		// one by one in mat[][]
		k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				RankedMatrix[i][j] = temp[k++];
		}
		return RankedMatrix;
	}

	// Rank Matrice
	static int[][] rankMat(double matRank[][], double matOriginal[][], int n) {
		int rank = 1;
		int RankedMatrix[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			loop: for (int j = 0; j < n; j++) {
				double temp = matRank[i][j];
				for (int k = 0; k < n; k++) {
					for (int p = 0; p < n; p++) {
						// System.out.println(matOriginal[k][p]);
						if (matOriginal[k][p] == temp) {
							RankedMatrix[k][p] = rank++;
							continue loop;

						}
					}
				}
			}
		}
		return RankedMatrix;

	}

	// function to print the given matrix
	static void printMat(double mat[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	static void printMat(int mat[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	static void saveMat(int mat[][], int n, PrintWriter pw) throws IOException {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				pw.print(mat[i][j] + " ");
			pw.println();
		}
		pw.close();
	}

	static void saveMat(double mat[][], int n, PrintWriter pw) throws IOException {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				pw.print(mat[i][j] + " ");
			pw.println();
		}
		pw.close();
	}

	static String position(int mat[][], int n, int x) {
		String p = "";
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (mat[i][j] == x)
					p = "position of " + x + " is " + i + "," + j;
				// System.out.println(p);
			}
		}
		return p;
	}

	// Driver program to test above
	public static void main(String args[]) {
		try {
			int i = 2016;
			int j = 2018;
			//do {

				String path = "D:\\MICCAI\\Sliding Windows\\"+i+"_"+j+"\\";
				String fileName = "top20.txt";
				PrintWriter pwOriginal = new PrintWriter(path + "top20_OriginalMatrix.txt");
				PrintWriter pw = new PrintWriter(path + "top20_RankedMatrix.txt");
				PrintWriter pwPositions = new PrintWriter(path + "Positions.txt");

				BufferedReader bf = new BufferedReader(new FileReader(path + fileName));
				System.out.println("Creation of matrix from the file " + fileName);
				System.out.println("<------------------------------> ");
				double mat[][] = createMatrix(bf, path + fileName, 17);
				int n = 17;

				System.out.println("Original Matrix:");
				printMat(mat, n);
				saveMat(mat, n, pwOriginal);

				double matRank[][] = sortMat(mat, n);

				System.out.println("Matrix After Sorting:");
				printMat(matRank, n);

				System.out.println("Matrix with Ranking:");
				int rankedMat[][] = rankMat(matRank, mat, n);
				printMat(rankedMat, n);

				System.out.println("Saving Matrix:");
				saveMat(rankedMat, n, pw);

				for (int k = 17; k <= 71; k += 2) {
					position(rankedMat, n, k);
					System.out.println(position(rankedMat, n, k));
					pwPositions.write(position(rankedMat, n, k));
					pwPositions.println();
				}
				pwPositions.close();
				//i++;
				//j++;
			//} while (i < 2017 && j < 2019);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("All Done! Thank you :) ");
	}
}
