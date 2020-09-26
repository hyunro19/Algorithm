def solution(n, results):
    matrix = [[0 for i in range(n+1)] for i in range(n+1)]
    cnt = [0]*(n+1)
    
    for r in results:
        matrix[r[0]][r[1]] = 1
    
    
    for i in range(1, n+1): # 기준 선수 x
        for j in range(1, n+1): # x를 이기는 선수 a
            for k in range(1, n+1): # x에게 지는 선수 b
                # 여기서 i, j, k의 순서가 중요하다
                if matrix[j][i]==1 and matrix[i][k]==1:
                    matrix[j][k]=1 
                    # x에게 이기는 선수a는, x에게 지는 선수b에게도 이긴다. 
                    # a>x>b 가 성립
    
    for i in range(1, n+1):
        for j in range(1, n+1):
            if matrix[i][j]==1:
                cnt[i] += 1
                cnt[j] += 1
                #임의의 선수 x에 대해서 밝혀진 
                # x에게 이기는 선수의 수+x에게 지는 선수의 수 가 n-1이면
                # x의 순위를  확정할 수 있다.
                
    answer = 0
    for i in range(1, n+1):
        if cnt[i]==n-1:
            answer += 1
    
    return answer