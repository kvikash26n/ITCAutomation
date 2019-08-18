'''
Created on May 28, 2018

@author: 29265
'''


a,b=0,1
while b<10:
    print (b)
    a,b=b,a+b;
    
    
x=int(input("enter the number"))
if x<0:
    print ("x<0")
elif x==0:
    print ("x is zero")
elif x>0:
    print ("x>0")
else :
    print ("more")
    
w=['ram','shyam','vikash']
for i in w[:]:
    if len(i)>1:
            w.insert(0, i)
print (w)

