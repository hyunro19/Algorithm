# KRUSKAL 알고리즘

# idx=2순으로 연결관계를 정렬
# list에 set들로 연결된 덩어리를 차례대로 저장
# CASE1 : 둘 다 아직 없는 경우 -> 새로운 set으로 만듬
# CASE2 : 하나만 있는 경우 -> 기존 set에 추가
# CASE3 : 두 개가 다른 set에 있는 경우 -> 두 set을 하나로 합침
# CASE4 : 두 개가 같은 set에 있는 경우 -> do nothing

def solution(n, costs):
    costs.sort(key=lambda x:x[2])

    connections = []
    total_cost = 0
    for cost in costs:
        first = 101
        second = 101
        for idx, connection in enumerate(connections):
            if cost[0] in connection:
                first = idx
            if cost[1] in connection:
                second = idx
        # CASE1
        if first>100 and second>100:
            connections.append(set([cost[0], cost[1]]))
            total_cost += cost[2]
        # CASE2
        elif first>100:
            connections[second].add(cost[0])
            total_cost += cost[2]
        elif second>100:
            connections[first].add(cost[1])
            total_cost += cost[2]
        # CASE3
        elif first!=second:
            connections[first] = connections[first]|connections[second]
            del connections[second]
            total_cost += cost[2]
        # CASE4
        # else:
            #do nothing

    return total_cost