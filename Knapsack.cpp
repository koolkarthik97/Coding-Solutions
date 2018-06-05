#include<iostream>

using namespace std;

int max(int a, int b) { return a > b ? a : b; }

int dynamic_knapsack(int wt[], int val[], int total, int n, int **dp) {
	
	for (int j = 0;j < n;j++)
		dp[j][0] = 0;

	for (int j = 1;j <= total;j++)
		if (j < wt[0])
			dp[0][j] = 0;
		else
			dp[0][j] = val[0];

	for (int i = 1;i < n;i++) {

		for (int j = 1;j <= total;j++) {

			if (wt[i] > j)
				dp[i][j] = dp[i - 1][j];
			else
			{
				dp[i][j] = max(dp[i - 1][j], val[i] + dp[i - 1][j - wt[i]]);
			}
		}
	}


	return dp[n - 1][total];
}

int main() {
	int size,tot_wt;
	cin >> size>>tot_wt;
	int *wt = new int[size];
	int *val = new int[size];
	for (int i = 0;i < size;i++)
		cin >> wt[i] >> val[i];

	int **dp = new int*[size];
	for (int i = 0;i < size;i++)
		dp[i] = new int[tot_wt+1];

	cout <<"answer : "<< dynamic_knapsack(wt, val, tot_wt, size,dp);
	return 0;
