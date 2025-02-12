import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        sc.close();  // 입력 종료

        int[] arr = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0'; // 8진수 숫자로 변환
        }

        StringBuilder sb = new StringBuilder();
        
        // 첫 번째 숫자는 앞의 0을 제거하여 변환
        sb.append(exchangeFirst(arr[0]));

        // 두 번째 숫자부터는 항상 3자리 유지
        for (int i = 1; i < str.length(); i++) {
            sb.append(exchange(arr[i]));
        }

        System.out.println(sb.toString()); // 변환된 2진수 출력
    }

    // 첫 번째 숫자 변환 (앞의 0 제거)
    static String exchangeFirst(int a) {
        switch (a) {
            case 0: return "0";   // "000"이 아니라 "0"
            case 1: return "1";   // "001"이 아니라 "1"
            case 2: return "10";  // "010"이 아니라 "10"
            case 3: return "11";  // "011"이 아니라 "11"
            case 4: return "100";
            case 5: return "101";
            case 6: return "110";
            case 7: return "111";
            default: return "error"; // 예외 처리
        }
    }

    // 두 번째 숫자부터는 항상 3자리 변환
    static String exchange(int a) {
        switch (a) {
            case 0: return "000";
            case 1: return "001";
            case 2: return "010";
            case 3: return "011";
            case 4: return "100";
            case 5: return "101";
            case 6: return "110";
            case 7: return "111";
            default: return "error"; // 예외 처리
        }
    }
}
