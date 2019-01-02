import numpy as np
import time

# Returns an array containing all primes below 'limit'
def primeArr(limit):
    print("Calculating all primes below", limit, "...")
    primes = np.array([2,3,5])
    count = primes[len(primes)-1]
    progress = 1
    while ( count < limit ):
        count = count + 1
        # Prints the progress
        if( count % ( limit // 10 ) == 0 ):
            tempEnd = time.time()
            print( " -", progress * 10, "% Done, Latest calculated Prime:", primes[len(primes)-1], ", Time elapsed:", tempEnd-start, "s" )
            progress = progress + 1
        for p in primes:
            if ( p > np.sqrt(count) ):
                primes = np.append(primes,count)
                break
            if ( count % p == 0 ):
                break
    return primes

start = time.time()

LIMIT = 10000000

# Generate primes
primes = primeArr(LIMIT)

# Transfer primes from integers to strings
print("Converting primes to String ...")
strPrimes = [""]
comma = ","
for i in range(0,len(primes)-1):
    tempStr = str(primes[i]) + comma
    strPrimes.append(tempStr)
# To make sure there is no comma added at the last point
strPrimes.append(str(primes[len(primes)-1]) )
print("Done! Primes converted!")

print("Printing to file ...")
path = r".\\CompFiles\\primes.txt"
file = open(path, "w")
file.writelines(strPrimes)
file.close()

print("Program finished!")
end = time.time()
print("Time elapsed: ", end-start)
