s = str(input())
S = list(map(str,s))
result = [-1] * 26  
for i in range(len(S)):
    char = S[i]
    index = ord(char) - ord('a') 
    if result[index] == -1:
        result[index] = i

print(" ".join(map(str, result)))