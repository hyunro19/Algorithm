def budget_calculator(budgets, idx):
    num_of_rightside = len(budgets)-idx
    bgt = sum(budgets[:idx])+budgets[idx]*num_of_rightside
    return bgt

def solution(budgets, M):
    budgets.sort()
    
    # 예외CASE1 모든 예산을 줄 수 있는 경우
    if sum(budgets)<=M:
        return budgets[-1]
    
    # 예외CASE2 어느 한 도시도 예산을 맞춰 줄 수 없는 경우
    if M//len(budgets)<budgets[0]:
        return M//len(budgets)
            
    left = 0
    right = len(budgets)-1
    result = 0
    # 여기서는 특정 값이 있는게 아니라, 조건을 만족하는 최댓값을 찾는거다.
    while left<=right:
        mid = (left+right)//2
        m = budget_calculator(budgets, mid)
        
        if m<=M:
            if M<budget_calculator(budgets, mid+1):
                result = mid
                break
            left = mid+1
        else:
            right = mid-1
            
    # print(budgets[result])
    # print(M-m)
    # print(result)
    # print((M-m)//(len(budgets)-result-1))
    return budgets[result]+(M-m)//(len(budgets)-result-1)


    
    