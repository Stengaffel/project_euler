import numpy as np
import time

# Problem 33

# Returns an array of the digits, x is an integer
def numToArray(x):
    arr = np.array([])
    while(x != 0):
        arr = np.append(arr,x % 10)
        x = x // 10
    return np.flip(arr)

# Finds the matching numbers and removes them
# Returns a vector with the remaining numbers. Returns zeros if no match
def removeMatch(x,y):
    a = numToArray(x)
    b = numToArray(y)

    k = np.array([])

    for c in a:
        for d in b:
            # Match found
            if(c == d):
                # Find the remainder
                for c1 in a:
                    if(c1 != c):
                        k = np.append(k,c1)
                for d1 in b:
                    if(d1 != d):
                        k = np.append(k,d1)
                if(len(k) == 1):
                    k = np.zeros(len(a))
                return k
    return np.zeros(len(a))


start = time.time()

denomProd = 1
# i is the denominator
for i in range(11,99):

    if( i % 10 == 0 ):
        continue

    # j is the numerator
    for j in range(i+1,100):
        # i / j

        if( j % 10 == 0 ):
            continue

        check = removeMatch(i,j)
        if(check[1] == 0):
            continue
        if(i/j == check[0] / check[1]):
            print(i,"/",j," --> ",check[0],"/",check[1])
            denomProd = denomProd * ( check[0] / check[1] )


print("Prod: ", denomProd)
end = time.time()
print('Time elapsed: ', end-start)
