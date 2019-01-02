import numpy as np
import time

# Returns an array containing all digits of the number x
def numToArray(x):
    temp = np.array([])
    while ( x != 0 ):
        temp = np.append(temp, x % 10 )
        x = x // 10
    return np.flip(temp)

start = time.time()

LIMIT = 1000000

irrArr = np.array([])
prod = 1

concNum = 1

while ( len(irrArr) < LIMIT + 1 ):
    print("Length= ",len(irrArr),", concNum: ",concNum)
    irrArr = np.append(irrArr, numToArray(concNum))
    concNum = concNum + 1

for i in range(0,7):
    curIndex = 10 ** i
    print(irrArr[curIndex-1])
    prod = prod * irrArr[curIndex-1]


print("Final product: ", prod)
end = time.time()
print("Time elapsed: ", end-start)
