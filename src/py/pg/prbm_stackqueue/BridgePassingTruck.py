import queue

class Truck:
    def __init__(self, weight):
        self.location = 1
        self.weight = weight

    def oneSec(self):
        self.location += 1

def solution(bridge_length, weight, truck_weights):
    sec = 0
    truckOnBridgeQueue = list()
    weightOnBridge = 0
    
    while len(truck_weights) > 0 :
        for truck in truckOnBridgeQueue :
            truck.oneSec()
            
        if len(truckOnBridgeQueue)>0 and truckOnBridgeQueue[0].location > bridge_length :
            weightOnBridge -= truckOnBridgeQueue[0].weight                
            del truckOnBridgeQueue[0]

        if weightOnBridge+truck_weights[0] <= weight :
            truckOnBridgeQueue.append(Truck(truck_weights[0]))
            weightOnBridge += truck_weights[0]
            del truck_weights[0]        
        sec += 1
        
    return sec+bridge_length



# 틀렸던 부분
def solutionWrong(bridge_length, weight, truck_weights):
    sec = 0
    truckOnBridgeQueue = list()
    weightOnBridge = 0
    
    while len(truck_weights) > 0 :
        for truck in truckOnBridgeQueue :
            truck.oneSec()            
            if truck.location > bridge_length :
                weightOnBridge -= truckOnBridgeQueue[0].weight                
                del truckOnBridgeQueue[0] # for loop 순회하던 중 큐의 원소를 지워버려서 제대로 순회 못하는 문제가 발생했었다.
                # loop 순회 중에는 loop의 길이에 변화를 주는 행동은 하지 말것

        if weightOnBridge+truck_weights[0] <= weight :
            truckOnBridgeQueue.append(Truck(truck_weights[0]))
            weightOnBridge += truck_weights[0]
            del truck_weights[0]        
        sec += 1
        
    return sec+bridge_length