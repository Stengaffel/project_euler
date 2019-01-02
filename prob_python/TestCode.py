import numpy as np
import time
import re

start = time.time()

path = r".\\CompFiles\\primes.txt"
file = open(path,"r")
a = file.read()
b = re.compile(",").split(a)


end = time.time()
print("Elapsed time: ", end-start)
