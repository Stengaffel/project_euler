import numpy as np
import time

# Problem 36

# Returns an array containing the binary representation of the number x. Max limit of 32-bit
def createBinary(x):
    biNum = np.array([])
    for i in range(32,-1,-1):
        if( x >= 2**i ):
            biNum = np.append(biNum,1)
            x = x - 2**i
            continue
        if( len(biNum) > 0 ):
            biNum = np.append(biNum,0)
    return biNum

# Returns an array containing the digits of the number x.
def numToArray(x):
    arr = np.array([])
    while(x != 0):
        arr = np.append(arr,x % 10)
        x = x // 10
    return np.flip(arr)

# Returns True if the array x contains a palindrome. False if not
def isPali(x):
    temp = np.array([])
    for i in range(0,len(x)//2 + 1):
        if( x[i] != x[len(x)-1-i] ):
            return False
    return True


start = time.time()

LIMIT = 1000000

sum = 0

for i in range(1,LIMIT):
    numArr = numToArray(i)
    if(isPali(numArr)):
        biNum = createBinary(i)
        if(isPali(biNum)):
            sum = sum + i
            print(i)


print("Sum of all double-base palindromes: ", sum)

end = time.time()
print("Elapsed time: ", end-start)
