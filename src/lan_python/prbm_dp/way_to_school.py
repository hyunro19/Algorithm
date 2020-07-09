def solution(m, n, puddles):
    # 이중 배열 선언하는 법
    matrix = [[0 for i in range(m+1)] for i in range(n+1)]
    
    # 아래의 방식은 각 행끼리 같은 리스트를 참조하므로 오류
    # matrix = [[0]*(m+1)]*(n+1)
    
    for r in range(1, n+1):        
        for c in range(1, m+1):
            if [c, r] in puddles: # 여기서 [c, r]인지 [r, c]인지 헷갈리므로 주의
                continue
                
            if [r, c] == [1, 1]:
                matrix[1][1] = 1
                
            else:
                matrix[r][c] = (matrix[r-1][c]+matrix[r][c-1])%1000000007
                
    return matrix[n][m]