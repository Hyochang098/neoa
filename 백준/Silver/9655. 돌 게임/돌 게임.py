N = int(input())
DP = [""]*(N+1)
DP[1] = "SK"
if N>1:
    DP[2] = "CY"
if N>2:
    DP[3] = "SK"
for i in range(4,N+1):
    if DP[i-3] == "CY"or DP[i-1] == "CY":
        DP[i] = "SK"
    else:
        DP[i] = "CY"
print(DP[N])