n = int(input())
note = []
for _ in range(n):
    a = int(input())
    if a == 0:
        note.pop()
    else:
        note.append(a)
print(sum(note))