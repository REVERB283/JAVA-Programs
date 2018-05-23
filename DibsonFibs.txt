Dibs on Fibs

You are given two sequences A and B, each with size M, and an integer N. Consider the following pseudocode:
result := 0
for i := 1 to M
    for j := 1 to M
        array fib[1..max(2, N)]
        fib[1] := A[i]
        fib[2] := B[j]
        for k := 3 to N
            fib[k] := fib[k-1] + fib[k-2]
        result := result + fib[N]        
Compute the final value of the variable result. Since it can be very large, compute its remainder modulo 10**9 + 7.

Input
*  The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
*  The first line of each test case contains two space-seperated integers M and N.
*  The second line contains M space-seperated integers A1, A2, …, AM.
*  The third line contains M space-seperated integers B1, B2, …, BM.

Output
For each test case, print the final value of result modulo 10**9 + 7.

Constraints
*  1 ≤ T ≤ 10
*  1 ≤ M ≤ 10**5
*  1 ≤ N ≤ 10**5
*  0 ≤ Ai, Bi ≤ 10**9 for each valid i

Example Input
1
3 3
1 2 3
4 5 6

Example Output
63

