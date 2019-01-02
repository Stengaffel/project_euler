import numpy as np
import time
import re


start = time.time()

path = r'.\\Compfiles\\p042_words.txt'
file = open(path,"r")
a = file.read()
b = re.sub('["]','',a)
words = re.compile(",").split(b)


triSum = 0

triNums = np.array([])
curAdd = 0
for i in range(1,51):
    curAdd = curAdd + i
    triNums = np.append(triNums,int(curAdd))

for w in words:
    curSum = 0
    for char in w:
        curSum = curSum + ord(char) - 64
    for tn in triNums:
        if ( curSum == tn ):
            print(w)
            triSum = triSum + 1
            break
        if ( tn > curSum ):
            break
print("There are", triSum, "triangle numbers in the .txt file")
end = time.time()
print("Time elapsed: ", end-start)
