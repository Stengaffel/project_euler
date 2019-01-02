import numpy as np
import time

# Problem 32

# Checks if all nums are included once
def checkNums(x):
    for i in x:
        if(i != 1):
            return False
    return True

# Checks if the indexed number is occupied
def numOccupied(numbers, index):
    if( numbers[int(index)] >= 1 ):
        return True
    else:
        return False

# Creates an array containing all digits, returns zeros if there are too many zeros
# x is an array containing the numbers
def numsToArray(x):
    theArr = np.zeros(9)
    index = 0
    for i in x:
        curNum = i
        while(curNum != 0):
            if(index > 8):
                return np.zeros(9)
            theArr[index] = curNum % 10
            curNum = curNum // 10
            index = index + 1
    return theArr

# Check if number contains duplicates
def containsDup(x):
    nums = np.zeros(9)
    curNum = numsToArray(np.array([x]))
    for digit in curNum:
        if(digit < 1):
            break
        if(numOccupied(nums,digit-1)):
            return True
        else:
            nums[int(digit-1)] = nums[int(digit-1)] + 1
    return False

def prodExists(x,products):
    for prod in products:
        if(x == prod):
            return True
    return False


start = time.time()


dim = 9
upperLimit = 2000
prodSum = 0

prods = np.zeros(20)
prodInd = 0

# i represents the first factor
for i in range(1,upperLimit):

    if( (i % 10 == 0) or containsDup(i) ):
        continue

    # j represents the second factor
    for j in range(i,upperLimit):
        nums = np.zeros(dim)

        if( (j % 10 == 0) or containsDup(j) ):
            continue

        prod = i * j
        if(prod % 10 == 0 or containsDup(prod)):
            continue

        digits = numsToArray(np.array([i,j,prod]))

        # Checks if the correct amount of numbers are present
        if(digits[dim-1] == 0):
            continue

        correct = False
        # Check if all the digits are unique
        for n in digits:
            if(numOccupied(nums,n-1) or int(n) == 0):
                correct = False
                break
            else:
                nums[int(n-1)] = nums[int(n-1)] + 1
                correct = True

        if(correct and prodExists(prod,prods) == False):
            prodSum = prodSum + prod
            prods[prodInd] = prod
            prodInd = prodInd + 1
print("Total sum of products: ", prodSum)
end = time.time()
print("Time elapsed: ", end-start)
