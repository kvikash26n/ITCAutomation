'''
Created on Jun 10, 2018

@author: 29265
'''

a=[23,1,5,1]

a.sort(reverse=False)
print (a)
print(a.count(1))
#print (f"{a},'has been srted'")
i = 1
while i < 6:
    print(i)
    i=i+1
    if(i==3):
        continue
    
name=['vikash','kumar']
for i in name:
    i[0].capitalize()
    print (i[0].capitalize()+i[1:])


