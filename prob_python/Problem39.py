import numpy as np
import time

# Problem 39

start = time.time()

LIMIT = 1000
maxComs = 0
pMax = 0

for p in range(1,LIMIT):
    curComs = 0
    # Might iterate an unnecessary amount of times
    for i in range(1,p//2):
        for j in range(i,p//2):
            testSum = i + j + np.sqrt(i**2 + j**2)
            if( testSum == p ):
                curComs = curComs + 1
    if( curComs > maxComs ):
        print("p:", p, ", Combinations: ", curComs)
        pMax = p
        maxComs = curComs

print("Maximum combinations: ", maxComs, " at p =",pMax)

end = time.time()
print("Time elapsed: ", end-start)
