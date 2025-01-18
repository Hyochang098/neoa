import sys
input = sys.stdin.readline
def checking(board, start_row, start_col):

    line1 = ['W','B','W','B','W','B','W','B']
    line2 = ['B','W','B','W','B','W','B','W']

    chess1 = []
    chess2 = []
    for _ in range(4):
        chess1.append(line1)
        chess1.append(line2)
        chess2.append(line2)
        chess2.append(line1)

    count1 = 0
    count2 = 0
    for r in range(8):
        for c in range(8):
            color = board[start_row + r][start_col + c]

            if chess1[r][c] != color:
                count1 += 1

            if chess2[r][c] != color:
                count2 += 1

    return min(count1, count2)


N, M = map(int, input().split())
board = [list(input().strip()) for _ in range(N)]

answer = float('inf')
for a in range(N - 7):
    for b in range(M - 7):
        cost = checking(board, a, b)
        if cost < answer:
            answer = cost

print(answer)
