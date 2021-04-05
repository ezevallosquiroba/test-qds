package com.test.api.qds.api.qds;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matrix")
public class MatrizController {

	@PostMapping("/rotate")
	public String rotateArrays(@RequestBody ArrayRequest request) {

		int[][] matrix = request.getMatrix();

		int N = matrix[0].length;

		rotateMatrix90deg(N, matrix);

		return printMatrix(N, matrix);
	}

	private void rotateMatrix90deg(int N, int matrix[][]) {
		for (int x = 0; x < N / 2; x++) {
			for (int y = x; y < N - x - 1; y++) {
				int temp = matrix[x][y];

				matrix[x][y] = matrix[y][N - 1 - x];

				matrix[y][N - 1 - x] = matrix[N - 1 - x][N - 1 - y];

				matrix[N - 1 - x][N - 1 - y] = matrix[N - 1 - y][x];

				matrix[N - 1 - y][x] = temp;
			}
		}
	}

	private String printMatrix(int N, int matrix[][]) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append("[" + matrix[i][j]).append("]");
			}
			sb.append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}

}
