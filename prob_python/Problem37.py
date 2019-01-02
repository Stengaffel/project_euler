import numpy as np
import time

# Problem 37

# Returns an array containing all primes below 'limit'
def primeArr(limit):
    primes = np.array([2,3,5])
    testNum = 5
    while( testNum < limit-1):
        testNum = testNum + 1
        for p in primes:
            if( p > np.sqrt(testNum) ):
                primes = np.append(primes,testNum)
                break
            if( testNum % p == 0 ):
                break
    return primes

# Returns an array containing the digits of the number x
def numToArray(x):
    temp = np.array([])
    while( x != 0 ):
        temp = np.append(temp,x % 10)
        x = x // 10
    return np.flip(temp)

# Returns an array containing all left-truncated numbers from the digit-array x
def leftTruncate(x):
    x = np.flip(x)
    rTrunc = np.array([])

    curNum = 0
    dec = 1
    for i in range(0,len(x)-1):
        curNum = curNum + x[i] * dec
        rTrunc = np.append(rTrunc,curNum)
        dec = dec * 10
    return rTrunc

# Returns an array conatining all right-truncated numbers from the digit-array x
def rightTruncate(x):
    x = np.flip(x)
    lTrunc = np.array([])

    curNum = 0
    dec = 1
    for i in x:
        curNum = curNum + i * dec
        dec = dec * 10

    for i in range(0,len(x)-1):
        lTrunc = np.append(lTrunc,curNum // 10)
        curNum = curNum // 10

    return lTrunc

# Uses binarysearch to find if x exists in the array
def isPrime(x, arr, start, end):
    # print("x:",x,",start:",start,",end:",end)
    if(start == end):
        if( arr[start] == x ):
            return True
        else:
            return False
    if( end - start == 1 ):
        if( arr[start] == x or arr[end] == x ):
            return True
        else:
            return False

    guess = ( end + start ) // 2
    if( x < arr[guess] ):
        return isPrime(x,arr,start,guess)
    else:
        return isPrime(x,arr,guess,end)

start = time.time()

LIMIT = 1000000

primeArray = primeArr(LIMIT)
truncPrimes = np.array([])
sum = 0
countNums = 0

# The loop bregins at 4 to ignore 2, 3, 5 and 7
for p in range(4,len(primeArray)):
    isTruncPrime = True
    rTrunc = rightTruncate(numToArray(primeArray[p]))
    for rt in rTrunc:
        if( isPrime(rt,primeArray,0,len(primeArray)) == False ):
            isTruncPrime = False
            break
    if(isTruncPrime == False):
        continue
    lTrunc = leftTruncate(numToArray(primeArray[p]))
    for lt in lTrunc:
        if ( isPrime(lt,primeArray,0,len(primeArray)) == False ):
            isTruncPrime = False
            break
    if(isTruncPrime == True):
        sum = sum + primeArray[p]
        countNums = countNums + 1
        print("No.",countNums,": ",primeArray[p])

print("Sum of all truncatable primes: ", sum)
end = time.time()
print("Time elapsed: ", end-start)
