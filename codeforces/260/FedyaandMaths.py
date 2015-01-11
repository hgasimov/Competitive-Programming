# 
# Codeforces Round #260 (Div. 2), Problem B
# 
s = raw_input()
if len(s) == 1 and int(s) == 0:
	print(4)
else:
	if len(s) > 2: s = s[-2:]
	n = (int(s) - 1) % 4 + 1
	print((1 + 2**n + 3**n + 4**n) % 5)
