# 1. 피보나치 수열fib을 만든다. (dp, memoization)
# 2. n번째 사각형까지의 둘레는 fib[n-1]*4+fib[n-2]*2

def solution(N):
    # []*n은 []이다. 
    # [0]*N이 [0, 0, 0, ...]이다.
    fib = [0]*N 
    for i in range(N):
        if i==0 or i==1:
            fib[i]=1
        else:
            fib[i]=fib[i-1]+fib[i-2]
    return fib[N-1]*4+fib[N-2]*2