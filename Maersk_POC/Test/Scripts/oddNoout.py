'''
Created on May 13, 2019

@author: 29265
'''
input=[2342,1234,2345,768]
#find the odd one
#1st sort order in each entry
#then use loop to check for all the input
#a=2343
for k in input:
    a=str(k)
    temp=[]
    for i in a:
        temp.append(i)
    temp
    for i in range(0,len(temp)):
        for j in range(i+1,len(temp)):
            if temp[i]>temp[j]:  
                print(a)
                break
            break
        
import pandas as pd
df=pd.read_excel("C:\\Users\\29265\\Desktop\\apttus.xlsx")
df=df.T
print(len(df.columns))
DataMissingInClientVsOnePoint=[]
for i in range(0,len(df.columns)):
    #print(list(df[i])[0])
    a=list(df[i])[0]
    a=a.split("#")
    print(a[1])
    