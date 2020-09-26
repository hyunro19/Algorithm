def solution(prices):
    answer = []
    for i in range(0, len(prices)-1) :
        sec = 1
        t = i+1
        while t < len(prices)-1 and prices[t] >= prices[i] :
            t += 1
            sec += 1
        answer.append(sec)
    answer.append(0)    
    return answer

# Stack을 사용한 버전
# stack은 '주식 가격이 처음으로 떨어지는 지점을 아직 못찾은 가격의 index 모음'입니다. 
# i for문을 돌며 'stack에 남은 것들이 i 번째에 처음으로 가격이 떨어지는가?'를 매번 검사합니다. 
# 이때 queue를 쓰지 않고 stack을 써서 역으로 index를 검사하는 이유는 
# stack 내 뒤쪽 것이 p[i]보다 가격이 같거나 작다면, 
# 그 앞의 것들은 i index에서 최초로 가격이 떨어질리 없기에 굳이 검사하지 않고 break로 시간을 줄일 수 있기 때문입니다.
def solution2(p):
    ans = [0] * len(p)
    stack = [0]
    for i in range(1, len(p)):
        if p[i] < p[stack[-1]]:
            for j in stack[::-1]:
                if p[i] < p[j]:
                    ans[j] = i-j
                    stack.remove(j)
                else:
                    break
        stack.append(i)
    for i in range(0, len(stack)-1):
        ans[stack[i]] = len(p) - stack[i] - 1
    return ans