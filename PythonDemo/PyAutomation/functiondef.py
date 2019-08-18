'''
Created on May 28, 2018

@author: 29265
'''
from __builtin__ import range

import numpy as np

def fab(n):
   a,b=0,1
   while a<n:
       print a
       a,b= b,a+b
 

fab(8)   
print list(range(2,6))

def read(abc='vikash'):
    print (abc)
    return abc
    
z=read('python ')
print (z)
p=lambda i,j:i*2*j
print(p(2,6))
a=[2,1,3,5]

