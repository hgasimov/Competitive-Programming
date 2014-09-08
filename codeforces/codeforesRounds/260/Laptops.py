# 
# Codeforces Round #260 (Div. 2), Problem A
#
n = int(raw_input())
a = map(lambda x: map(int, x), [raw_input().split(' ') for i in range(n)])

a.sort(key = lambda x: x[0])

if any(a[i][0] < a[i+1][0] and a[i][1] > a[i+1][1] for i in range(n-1)):
	print('Happy Alex')
else:
	print('Poor Alex')
