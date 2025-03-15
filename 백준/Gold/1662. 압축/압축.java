import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getOriginalLength(str, 0, str.length()));
    }

    private static int getOriginalLength(String str, int start, int end) {
        int length = 0;
        for (int i = start; i < end; i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) { // 숫자일 때
                if (i + 1 < end && str.charAt(i + 1) == '(') { // 다음 문자가 '(' 인 경우
                    int k = c - '0'; // K 값 저장
                    int closeIdx = findClosingBracket(str, i + 1); // 닫는 괄호 위치 찾기
                    length += k * getOriginalLength(str, i + 2, closeIdx); // Q 부분을 재귀 호출 후 K배 적용
                    i = closeIdx; // i를 닫는 괄호 위치로 이동
                } else {
                    length++; // 단순한 숫자는 길이에 포함
                }
            } else if (c != '(' && c != ')') { // 일반 문자 처리
                length++;
            }
        }
        return length;
    }

    private static int findClosingBracket(String str, int openIdx) {
        int balance = 0;
        for (int i = openIdx; i < str.length(); i++) {
            if (str.charAt(i) == '(') balance++;
            if (str.charAt(i) == ')') balance--;
            if (balance == 0) return i; // 짝이 맞는 닫는 괄호 위치 반환
        }
        return -1; // 이론상 도달하지 않음 (올바른 입력 가정)
    }
}
