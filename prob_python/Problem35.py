import numpy as np
import time

# Problem 35

# Returns an array containing all prime numbers below 'limit'
def primeArr(limit):
    primes = np.array([])
    primes = np.append(primes,2)
    primes = np.append(primes,3)
    primes = np.append(primes,5)

    count = 5
    while(count < limit-1):
        count = count + 1
        for p in primes:
            if(p > np.sqrt(count)):
                primes = np.append(primes,count)
                break
            if(count % p == 0):
                break
    return primes

# Binary search of an array. Returns true if found, false otherwise
def primeExists(arr,x,start,end):

    if( end - start == 1 ):
        if(arr[end] == x or arr[start] == x):
            return True
        else:
            return False

    if(start == end):
        if(arr[start] == x):
            return True
        else:
            return False

    guess = ( (end + start) // 2 )

    if ( x < arr[guess] ):
        end = guess
    else:
        start = guess

    return primeExists(arr,x,start,end)

def numToArray(x):
    # Create an array of the digits
    tempArr = np.array([])
    while ( x != 0 ):
        tempArr = np.append(tempArr,x%10)
        x = x // 10
    return np.flip(tempArr)


# Returns the next num which puts the last number first and the array containing the digits
def rotateNum(x):

    # Create an array with the digits in the new order
    newArr = np.array([x[len(x)-1]])
    for i in range(0,len(x)-1):
        newArr = np.append(newArr,x[i])
    newArr = np.flip(newArr)

    # Create the number
    place = 1
    finalNum = 0
    for i in newArr:
        finalNum = finalNum + place * i
        place = place * 10

    return int(finalNum), np.flip(newArr)

start = time.time()

circPrims = 0

# Create an array containing all primes under 1,000,000
prime = primeArr(1000000)
print(len(prime), " primes")

for p in prime:
    numArr = numToArray(p)
    tempPrime, currArr = rotateNum(numArr)

    # Iterate until you find the prime again
    while ( p != tempPrime ):

        # Find the potential prime
        if(primeExists(prime,tempPrime,0,len(prime)-1)):
            tempPrime, currArr = rotateNum(currArr)
        else:
            break
    if(p == tempPrime):
        circPrims = circPrims + 1
        print("No.", circPrims, ": ", p)

print('Circular Primes: ', circPrims)
end = time.time()
print('Time elapsed: ', end-start)
