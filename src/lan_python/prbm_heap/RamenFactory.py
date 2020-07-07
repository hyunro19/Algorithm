import heapq

def solution(stock, dates, supplies, k): 
    possibleSupplies = []
    answer = 0

    for idx, day in enumerate(dates) :                 
        if stock < day :
            stock += heapq.heappop(possibleSupplies)[1]
            answer += 1
        heapq.heappush(possibleSupplies, (-supplies[idx], supplies[idx]))

        # 아래 조건문에 등호가 포함되고, heappush가 조건문 앞에 나오면 오답이 된다. 왜지?
        # 오히려 아래가 맞는 코드인 것 같은데
        # !! day가 K이하이기 때문에
        # dates에 [4, 10, 15, 30]이 오고, 그 날까지의 누적 재고가 딱 30인 경우에도 
        # 그 날 받는 supply를 추가하게 되기 때문 그래서 오류가 난다.
        # heapq.heappush(possibleSupplies, (-supplies[idx], supplies[idx]))
        # if stock <= day :
        #     stock += heapq.heappop(possibleSupplies)[1]
        #     answer += 1        
        
    while stock < k :
        stock += heapq.heappop(possibleSupplies)[1]
        answer += 1
        
    return answer



# 시간초과 loop을 day기준으로 두면 안되는 것 같다.
def solution2(stock, dates, supplies, k):
    possibleSupplies = []
    answer = 0
    for day in range(0, k) :                        
        if len(dates) != 0 and day == dates[0] :
            heapq.heappush(possibleSupplies, (-supplies[0], supplies[0]))
            del dates[0]
            del supplies[0]
        if stock == 0 :            
            stock += heapq.heappop(possibleSupplies)[1]
            answer += 1
        stock -= 1
    return answer

# print(solution(4, [4, 10, 15], [20, 5, 10], 30))
# print(solution(4, [1, 2, 3, 4], [10, 40, 20, 30], 100)) # 4
# print(solution(4, [1, 2, 3, 4], [1, 1, 1, 1], 6)) # 2
print(solution(4, [4, 10, 15, 30], [26, 5, 10, 10], 30)) # 1
