import java.util.Scanner; // 사용자 입력을 받기 위한 Scanner 클래스

/**
 * 피보나치 수열 재귀 구현
 * 피보나치 수열: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
 * F(n) = F(n-1) + F(n-2), F(0) = 0, F(1) = 1
 */
public class Fibonacci {
    
    /**
     * 기본 재귀 방식으로 피보나치 수 계산
     * 
     * @param n 구하고자 하는 피보나치 수열의 인덱스
     * @return n번째 피보나치 수
     */
    public static int fibonacciRecursive(int n) {
        // 기저 조건 (Base Case)
        // n이 0이면 0을 반환
        if (n == 0) {
            return 0;
        }
        // n이 1이면 1을 반환
        if (n == 1) {
            return 1;
        }
        
        // 재귀 호출: F(n) = F(n-1) + F(n-2)
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    /**
     * 메모이제이션을 사용한 재귀 방식 (최적화)
     * 
     * @param n 구하고자 하는 피보나치 수열의 인덱스
     * @return n번째 피보나치 수
     */
    public static int fibonacciMemo(int n) {
        // 메모이제이션을 위한 배열 생성
        int[] memo = new int[n + 1];
        return fibonacciMemoHelper(n, memo);
    }
    
    /**
     * 메모이제이션 헬퍼 함수
     * 
     * @param n 구하고자 하는 피보나치 수열의 인덱스
     * @param memo 이미 계산된 값을 저장하는 배열
     * @return n번째 피보나치 수
     */
    private static int fibonacciMemoHelper(int n, int[] memo) {
        // 기저 조건
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        // 이미 계산된 값이 있으면 재사용 (중복 계산 방지)
        if (memo[n] != 0) {
            return memo[n];
        }
        
        // 계산 후 메모 배열에 저장
        memo[n] = fibonacciMemoHelper(n - 1, memo) + fibonacciMemoHelper(n - 2, memo);
        return memo[n];
    }
    
    /**
     * 메인 함수 - 프로그램 실행 시작점
     */
    public static void main(String[] args) {
        // Scanner 객체 생성 - 사용자 입력을 받기 위함
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== 피보나치 수열 계산기 ===\n");
        
        // 사용자로부터 숫자 입력받기
        System.out.print("몇 번째 피보나치 수까지 출력할까요? ");
        int n = scanner.nextInt();
        
        // 입력값 유효성 검사
        if (n < 0) {
            System.out.println("0 이상의 숫자를 입력해주세요.");
            scanner.close();
            return;
        }
        
        System.out.println("\n=== 결과 ===\n");
        
        // 기본 재귀 방식으로 피보나치 수열 출력
        System.out.println("1. 기본 재귀 방식:");
        System.out.print("피보나치 수열 (0부터 " + n + "번째까지): ");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacciRecursive(i));
            if (i < n) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
        
        // 메모이제이션 방식으로 피보나치 수열 출력
        System.out.println("2. 메모이제이션 방식 (최적화):");
        System.out.print("피보나치 수열 (0부터 " + n + "번째까지): ");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacciMemo(i));
            if (i < n) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
        
        // 특정 인덱스의 피보나치 수 출력
        System.out.println("3. 특정 인덱스 계산:");
        System.out.print("계산하고 싶은 피보나치 수의 인덱스를 입력하세요: ");
        int index = scanner.nextInt();
        
        if (index < 0) {
            System.out.println("0 이상의 숫자를 입력해주세요.");
        } else if (index > 45) {
            // 기본 재귀는 45 이상에서 매우 느려지므로 경고
            System.out.println("\n" + index + "번째 피보나치 수 (메모이제이션): " + fibonacciMemo(index));
            System.out.println("(참고: 기본 재귀는 큰 수에서 매우 느려 생략합니다)");
        } else {
            System.out.println("\n" + index + "번째 피보나치 수 (기본 재귀): " + fibonacciRecursive(index));
            System.out.println(index + "번째 피보나치 수 (메모이제이션): " + fibonacciMemo(index));
        }
        
        // Scanner 닫기3
        scanner.close();
        System.out.println("\n프로그램을 종료합니다.");
    }
}
