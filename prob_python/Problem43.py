import numpy as np
import time

# Returns an array containing all digits from the number x
def numToArray(x):
    digits = np.array([])
    while ( x > 0 ):
        digits = np.append(digits,x % 10)
        x = x // 10
    return np.flip(digits)

# Returns True if the array x contains the digits of a 0 to n pandigital. False if not
def isPandigital(x):
    checkNums = np.zeros(len(x))
    for i in x:
        i = int(i)
        if( i > len(x) - 1 ):
            return False
        if ( checkNums[i] > 0 ):
            return False
        if ( checkNums[i] == 0 ):
            checkNums[i] = checkNums[i] + 1
    return True

# Find all 0 to 9 pandigitals.
def findPandigital(curNum, panNums=[]):
    if ( len(curNum) >=  10 ):
        num = 0
        dec = 1
        for i in curNum:
            num = num + i * dec
            dec = dec *  10
        panNums.append(num)
        return

    for i in range(0, 10):
        if( ( i in curNum ) == False ):
            findPandigital(curNum + [i], panNums)
    return panNums

start = time.time()

# test = 1230
# testArr = numToArray(test)
# print(test)
# print(testArr)
# print(isPandigital(testArr))

a = findPandigital([])

totSum = 0

underLimit = 10 ** 9
upperLimit = 10 ** 10

conditionNums = np.array([2,3,5,7,11,13,17])

for pn in a:
    for ind in range(1, len(a)-3 ):
        numArr = numToArray(pn)
        curTest = numArr[ind] * 100 + numArr[ind+1] * 10 + numArr[ind+2]
        if( curTest % conditionNums[ind-1] != 0 ):
            break
        if( ind == len(a) - 4 ):
            print("Current addition: {}".format(pn))
            totSum = totSum + pn




print("Total sum of all 0 to 9 pandigitals fitting all conditions:", totSum)
end = time.time()
print("Time elapsed:", end-start)
