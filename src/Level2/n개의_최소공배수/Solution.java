package Level2.n개의_최소공배수;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;

        if (arr.length == 1) return arr[0];

        int gcd = arr[0];
        int lcm = arr[0];
        System.out.println(gcd);
        for (int i = 1; i < arr.length; i++) {
            gcd = getGcd(lcm, arr[i]);
            lcm = getLcm(lcm, arr[i], gcd);
        }

        answer = lcm;

        return answer;
    }

    public static int getGcd(int a, int b) {

        if (b == 0) return a;
        // GCD(a, b) = GCD(b, r)이므로 (r = a % b)
        return getGcd(b, a % b);

    }

    public static int getLcm(int a, int b, int gcd) {
        return a * b / gcd;
    }

}


// class Solution {
//     public int solution(int[] arr) {
//         int answer = 0;

// 		int result = arr[0];
// 		for (int i = 1; i < arr.length; i++) {
// 			result = getLcm(result, arr[i]);
// 		}

// 		answer = result;

// 		return answer;
// 	}

// 	public static int getGcd(int a, int b) { // 최대공약수
// 		int tmp;
// 		while (b != 0) {
// 			tmp = b;
// 			b = a % b;
// 			a = tmp;
// 		}

// 		return a;
// 	}

// 	static int getLcm(int a, int b) {
// 		int tmp = a * b / getGcd(a, b);
// 		return tmp;
// 	}
// }