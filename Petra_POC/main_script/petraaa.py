'''
Created on Aug 20, 2018

@author: 29265
'''
import pandas as pd
allRelease=['R1','R2']
pf='C:\\Users\\29265\\Desktop\\petra_report\\'
input='\\input_file\\'
release=''
output='output file\\'
dataInput=[]
df='df'
def GetGoldenInput():
    for i in range(0,len(allRelease)):
        df=df+str(i+1)
        df=pd.read_csv(pf+allRelease[i]+input+'Data_Dimension_Cust.csv')
        dataInput.append(df)
    print(dataInput)
    #result = pd.concat(dataInput)
    #return result
      
re=GetGoldenInput()  
re.head()  