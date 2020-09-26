def solution(routes):
    num_of_cameras = 0
    
    routes.sort()
    begin = routes[0][0]
    end = routes[0][1]
    for b, e in routes:
        # print(b, e, end)
        if e < end:
            end = e
        
        # 카메라를 설치하는 CASE1
        if end < b:
            num_of_cameras += 1
            end = e
            # print('bf', b, e, end)
            
        # 카메라를 설치하는 CASE2
        elif end == b:
            num_of_cameras += 1
            end = 30000
            # print('af', b, e, end)

    return num_of_cameras+1