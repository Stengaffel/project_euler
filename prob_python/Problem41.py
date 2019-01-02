import numpy as np
import time

# Returns an array containing all arrays under the 'limit'
def primeArr(limit):
    primes = np.array([2,3,5])
    count = 5
    while ( count < limit - 1 ):
        count = count + 1
        for i in primes:
            if( count % i == 0 ):
                break
            if ( i > np.sqrt(count) ):
                primes = np.append(primes,count)
                break
    return primes

# Returns an array with all the digits of the number x
def numToArray(x):
    temp = np.array([])
    while( x != 0 ):
        temp = np.append(temp, x % 10 )
        x = x // 10
    return np.flip(temp)

# Checks if the array x has enough zeros
def enoughZeros(x):
    if( len(x) > 9 ):
        if( len(x) % 2 == 0 ):
            return False
        else:
            zerAmount = ( ( ( len(x) - 9 ) // 2 ) // 10 ) + 1
    else:
        zerAmount = 0
    maxZeros = zerAmount
    zeros = 0
    for i in x:
        if ( i == 0 ):
            if( zeros >= maxZeros ):
                return False
            else:
                zeros = zeros + 1
    return True

# Checks if the array x contains the digits of a pandigital numbers
def isPandigital(x):
    if ( enoughZeros(x) == False ):
        return False
    length = 0
    if( len(x) < 10 ):
        length = len(x)
    else:
        length = 9 + ( len(x) - 9 ) // 2
    numChecks = np.zeros(length)
    pos = 0
    while ( pos < len(x) ):
        if(x[pos] > length):
            return False
        if ( ( ( pos == len(x)-1 ) == False )  and ( ( x[pos] * 10 + x[pos+1] ) <= length ) ):
            testPos = int( x[pos] * 10 + x[pos+1] )
            if( numChecks[testPos-1] < 1 ):
                numChecks[testPos-1] = 1
                pos = pos + 2
                continue
        curIndex = int( x[pos]-1 )
        if ( numChecks[curIndex] > 0 ):
            return False
        else:
            numChecks[curIndex] = 1
            pos = pos + 1
    return True

start = time.time()

LIMIT = 10000000
maxNum = 0

primes = primeArr(LIMIT)

for p in primes:
    a = numToArray(p)
    if ( isPandigital(a) ):
        if ( p > maxNum ):
            maxNum = p
            print("New maxNum: ", maxNum)

print("Biggest pandigital prime under",LIMIT,":", maxNum)
end = time.time()
print("Time elapsed: ", end-start)
