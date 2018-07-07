#include <iostream>

using namespace std;

void printCombinations(int *comb, int index, int *coins) {
	while (comb[index] != -1)
	{
		cout << coins[comb[index]] << "  ";
		index -= coins[comb[index]];
	}
}

int changeCoins(int tot, int n, int *coins) {

	int *arr=new int[tot+1];
	int *comb = new int[tot + 1];
	for (int i = 0;i < tot + 1;i++) {
		arr[i] = INT_MAX - 1; comb[i] = -1;
	}
	arr[0] = 0;
	for (int i = 0;i < n;i++) {
		for (int j = 1;j < tot + 1;j++) {
			if (j >= coins[i]) {
				if (1 + arr[j - coins[i]] < arr[j]) {
					arr[j] =1 + arr[j - coins[i]];
					comb[j] = i;
				}
			}
		}
	}

		cout << "\n Denominations that were picked : ";
		printCombinations(comb, tot, coins);
		return arr[tot];
}

int main() {

	int total, n;
	cout << " total amount : ";
	cin >> total;

	cout << " no of coins : ";
	cin >> n;

	int *coins=new int[n];
	cout << "coin values : ";
	for (int i = 0;i < n;i++)
		cin >> coins[i];

	cout << "\n Min number of coins : "<<changeCoins(total, n, coins) << endl;

	return 0;
}