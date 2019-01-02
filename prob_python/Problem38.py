import numpy as np
import time


# Returns an array containing the digits of the number x
def numToArray(x):
    tempArr = np.array([])
    while(x != 0):
        tempArr = np.append(tempArr, x % 10)
        x = x // 10
    return np.flip(tempArr)

# Checks if there are any duplicates or zeros in the array x. Returns False if none exists
def containsDup(x):
    testDup = np.zeros(9)
    for i in x:
        i = int(i)
        if( i == 0 ):
            return True
        if( testDup[i-1] > 0 ):
            return True
        testDup[i-1] = testDup[i-1] + 1
    return False

start = time.time()

LIMIT = 100000

maxNum = 0

for i in range(1,LIMIT):
    tempArr = np.array([])
    multNum = 1
    while( len(tempArr) < 9 ):
        tempArr = np.append(tempArr,numToArray(i*multNum))
        multNum = multNum + 1
    if( len(tempArr) == 9 ):
        # Checks if there are duplicates or zeros in the array
        if( containsDup(tempArr) ):
            continue
        else:
            print(tempArr)
            # Create the num
            curNum = 0
            dec = 1
            for digit in np.flip(tempArr):
                curNum = curNum + digit * dec
                dec = dec * 10
            if( curNum > maxNum ):
                print("Current maxNum: ", curNum)
                maxNum = curNum

print("Greatest pandigital number: ", maxNum)

end = time.time()
print("Time elapsed: ", end-start)
