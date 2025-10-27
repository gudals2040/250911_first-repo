/**
 * 피보나치 수열 재귀 구현
 * 피보나치 수열: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
 * F(n) = F(n-1) + F(n-2), F(0) = 0, F(1) = 1
 */
public class Fibonacci {
    
    /**
     * 기본 재귀 방식으로 피보나치 수 계산
     * 시간 복잡도: O(2^n) - 비효율적
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
     * 시간 복잡도: O(n) - 효율적
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
        int n = 10; // 계산할 피보나치 수열의 개수
        
        System.out.println("=== 피보나치 수열 (재귀 방식) ===\n");
        
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
        int index = 15;
        System.out.println("3. 특정 인덱스 계산:");
        System.out.println(index + "번째 피보나치 수 (기본 재귀): " + fibonacciRecursive(index));
        System.out.println(index + "번째 피보나치 수 (메모이제이션): " + fibonacciMemo(index));
        
        // 성능 비교 (큰 수에서의 차이)
        System.out.println("\n=== 성능 비교 ===");
        int largeN = 40;
        
        // 기본 재귀 방식 시간 측정
        long startTime = System.currentTimeMillis();
        int result1 = fibonacciRecursive(largeN);
        long endTime = System.currentTimeMillis();
        System.out.println("기본 재귀 방식 - " + largeN + "번째: " + result1);
        System.out.println("소요 시간: " + (endTime - startTime) + "ms");
        
        // 메모이제이션 방식 시간 측정
        startTime = System.currentTimeMillis();
        int result2 = fibonacciMemo(largeN);
        endTime = System.currentTimeMillis();
        System.out.println("\n메모이제이션 방식 - " + largeN + "번째: " + result2);
        System.out.println("소요 시간: " + (endTime - startTime) + "ms");
    }
}