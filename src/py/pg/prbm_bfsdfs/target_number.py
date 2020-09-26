def dfs(cur, numbers, target):
    cnt = 0
    if len(numbers)==0 :
        if cur==target :
            return 1
        return 0
    cnt += dfs(cur+numbers[0], numbers[1:], target)
    cnt += dfs(cur-numbers[0], numbers[1:], target)
    return cnt
    # 여기서 cnt변수를 쓰지 않고
    # return dfs(cur+numbers[0], numbers[1:], target)+dfs(cur-numbers[0], numbers[1:], target)를 해줄 수도 있다

def solution(numbers, target):    
    return dfs(0, numbers, target)


# 다른사람 풀이
# 주어진 solution함수 자체를 재귀로 사용했는데,,
def solution(numbers, target):
    if not numbers and target == 0 : # numbers를 모두 소진해서 0이라서false이고 이 때, target과의 차이가 0이면 target에 도달했다는 뜻
        return 1 # 도달했으므로 cnt1 추가
    elif not numbers: # numbers를 모두 소진했는데 도달하지 못했으므로 return 0
        return 0
    else:
        return solution(numbers[1:], target-numbers[0]) + solution(numbers[1:], target+numbers[0]) # 재귀 호출