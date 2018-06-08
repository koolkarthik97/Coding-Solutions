#include<iostream>

using namespace std;

int arraySum(int i, int j, int cost[]) {
	int sum = 0;
	for (int start = i;start <= j;start++)
		sum += cost[start];
	return sum;
}

int optimalCostBST(int node[], int cost[], int n) {
	int **m = new int*[n];
	for (int i = 0;i < n;i++) {
		m[i] = new int[n]; 
	}

	for (int i = 0;i < n;i++)
		for (int j = 0;j < n;j++)
			m[i][j] = 0;

	for (int i = 0;i < n;i++)
	{
		m[i][i] = cost[i];
	}

	for (int l = 2;l <= n;l++) {

		for (int i = 0 ; i <= n - l ; i++) {
			int j = i + l - 1;
			m[i][j] = INT_MAX;
			//compute cost
			for (int r = i;r <= j;r++) {
				
				int sum = arraySum(i, j, cost) +
					((r > i) ? m[i][r - 1] : 0) +
					((r < j) ? m[r + 1][j] : 0);

				if (sum < m[i][j])
					m[i][j] = sum;
			}
		}
	}

	cout << "final computed dynamic matrix : \n\n";
	for (int i = 0;i < n;i++) {
		for (int j = 0;j < n;j++)
			cout << m[i][j] << "  ";
		cout << endl;
	}

		return m[0][n-1];
}

int main() {
	int n;
	cout << "Enter the number of nodes in the BST :" << endl;
	cin >> n;
	int *node = new int[n];
	int *cost = new int[n];
	cout << "Enter each node and their cost " << endl;
	
	for (int i = 0;i < n;i++)
		cin >> node[i] >> cost[i];

	cout << "\n\nMin cost = " << optimalCostBST(node, cost, n);
	
	return 0;
}
