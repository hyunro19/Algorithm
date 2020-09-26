def solution(triangle):
    for row_idx, row in enumerate(triangle):
        if row_idx==0: continue # 첫 행 제외
        for col_idx, col in enumerate(row):
            if col_idx==0: # 첫 열
                row[col_idx] += triangle[row_idx-1][0]
            elif col_idx==len(row)-1: # 마지막 열
                row[col_idx] += triangle[row_idx-1][col_idx-1]
            else: # 중간 열
                row[col_idx] += max(triangle[row_idx-1][col_idx-1], triangle[row_idx-1][col_idx])            
            
    return max(triangle[len(triangle)-1]) # 마지막 행 중 최대값 리턴