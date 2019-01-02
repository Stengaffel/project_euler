import numpy as np
import time

# Problem 31 v2

coins = (1,2,5,10,20,50,100,200)

def recCoin(curMon, maxCoin):
    sum = 0
    if(maxCoin == len(coins) - 1):
        return 1
    for i in range(maxCoin, len(coins)):
        if( curMon + coins[i] == 200 ):
            sum = sum + 1
        if( curMon + coins[i] < 200 ):
            sum = sum + recCoin(curMon + coins[i],i)
    return sum


start = time.time()

print(recCoin(0,0))

end = time.time()
print("Time Elapsed: ", end-start)
