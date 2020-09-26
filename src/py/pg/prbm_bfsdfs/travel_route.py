import copy

def should_update(route1, route2):
    for r1, r2 in zip(route1, route2):
        if r1 == r2: continue
            
        if [r1, r2] != sorted([r1, r2]):
            return True
        else: return False

    return False

def dfs(tickets, used, depth, temp_route, final_route):
    if depth==len(tickets):
        if final_route[0]==None or should_update(final_route, temp_route):
            final_route = copy.copy(temp_route)            
        return final_route

    for idx, tkt in enumerate(tickets):
        if used[idx]: continue
        if tkt[0]==temp_route[depth]:
            temp_route[depth+1]=tkt[1]
            used[idx]=True
            final_route = dfs(tickets, used, depth+1, temp_route, final_route)
            temp_route[depth+1]=None
            used[idx]=False
    return final_route


def solution(tickets):
    used = [False]*len(tickets)
    temp_route = [None]*(len(tickets)+1)
    temp_route[0]="ICN"
    final_route = [None]*(len(tickets)+1)
    ans = dfs(tickets, used, 0, temp_route, final_route)
    return ans