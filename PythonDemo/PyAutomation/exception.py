'''
Created on May 29, 2018

@author: 29265
'''
def this_fails():
    x = 1/0          
     
try:
    this_fails()
except ZeroDivisionError as err:
    print('Handling run-time error:', err)

