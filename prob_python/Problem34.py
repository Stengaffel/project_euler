import numpy as np
import time

# Problem 34

def factorial(x):
    if(x <= 1):
        return 1
    else:
        return x * factorial(x-1)

start = time.time()

countRange = 10**5

facSum = 0

for i in range(3,countRange):
    curNum = i
    digitFacSum = 0
    while ( curNum != 0 ):
        digitFacSum = digitFacSum + factorial(curNum % 10)
        curNum = curNum // 10


    if(digitFacSum == i):
        facSum = facSum + i
        print(i)

print('Sum of curious numbers: ', facSum)
end = time.time()
print('Time elapsed: ', end-start)
