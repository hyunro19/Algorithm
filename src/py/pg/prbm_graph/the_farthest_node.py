from collections import deque

# 맞는 풀이
def solution(n, edge):

    not_visited = n
    visited = [False]*(n+1)
    distance = [0]*(n+1)
    
    edge_map = {}

    for e in edge:
        # edge의 연결 맵을 '양방향'으로
        if e[0] not in edge_map:
            edge_map[e[0]] = set()
        edge_map[e[0]].add(e[1])
        
        if e[1] not in edge_map:
            edge_map[e[1]] = set()
        edge_map[e[1]].add(e[0])
    
    queue = deque([])
    queue.append(1)
    visited[1] = True
    not_visited -= 1

    while not_visited:        
        node = queue.popleft()
        # 양방향으로 설정했으므로, edge_map에 node가 없을 경우 X
        # if node not in edge_map:
        #     continue
        for n in edge_map[node]:
            # 양방향으로 만든 후, 이미 방문한 경우 continue하도록 설정
            if visited[n]==False:
                visited[n] = True
                not_visited -= 1
                distance[n] = distance[node]+1
                queue.append(n)
    
    mx = 0
    cnt = 0
    for d in distance:
        if d>mx:
            mx = d
            cnt = 1
        elif d==mx:
            cnt += 1

    return cnt

# 틀린 풀이 (런타임 오류)
def solution2(n, edge):

    not_visited = n
    visited = [False]*(n+1)
    distance = [0]*(n+1)
    
    edge_map = {}

    for e in edge:
        e.sort()
        # 틀린 경우
        # 정렬하고 링크를 단방향으로 하면 안된다.
        # 양방향으로 하고, 이미 방문한 경우를 체크해주는 방식으로 해야함
        if e[0] not in edge_map:
            edge_map[e[0]] = set()
        edge_map[e[0]].add(e[1])
    
    queue = deque([])
    queue.append(1)
    visited[1] = True
    not_visited -= 1

    while not_visited:        
        node = queue.popleft()
        if node not in edge_map:
            continue
        for n in edge_map[node]:
            if visited[n]==False:
                visited[n] = True
                not_visited -= 1
                distance[n] = distance[node]+1
                queue.append(n)
    
    mx = 0
    cnt = 0
    for d in distance:
        if d>mx:
            mx = d
            cnt = 1
        elif d==mx:
            cnt += 1

    return cnt