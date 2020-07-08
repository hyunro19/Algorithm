def dfs(i, computers, visited):
    visited[i] = True
    for idx, cpt in enumerate(computers[i]) :
        if not visited[idx] and cpt :
            dfs(idx, computers, visited)

def solution(n, computers):
    num_of_network = 0
    visited = [False]*n

    for i, v in enumerate(visited) :
        if v : continue
        num_of_network += 1
        dfs(i, computers, visited)

    return num_of_network


