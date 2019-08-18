'''
Created on Feb 9, 2019

@author: 29265
'''
#C:\Users\29265\Desktop\TSPOC
import pandas as pd
df_ITCOP=pd.read_excel("C:\\Users\\29265\\Desktop\\TSPOC\\ITC_OP_TS.xlsx")
df_TM=pd.read_excel("C:\\Users\\29265\\Desktop\\TSPOC\\TM Timesheet Master Template.xlsx")
#df_ITCOP.head(2)

df_TM=df_TM.T
df_ITCOP=df_ITCOP.T


for i in range(0,len(df_TM.columns)):
    
    for j in range(0,len(df_ITCOP.columns)):
        #id validation
        if list(df_TM[i])[0]== list(df_ITCOP[j])[1] and str(list(df_TM[i])[2])==str(list(df_ITCOP[j])[3]):
            break
        if(j==len(df_ITCOP.columns)):
            print(list(df_TM[i])[0])
            print(str(list(df_TM[i])[2]))
            
            

import pandas as pd
df_TM=pd.read_excel("C:\\Users\\29265\\Desktop\\pythonAssignment.xlsx",sheetname='Sheet1')
df_ITCOP=pd.read_excel("C:\\Users\\29265\\Desktop\\pythonAssignment.xlsx",sheetname='Sheet2')
#df_ITCOP.head(2)

df_TM=df_TM.T
df_ITCOP=df_ITCOP.T
df_TM

for i in range(0,len(df_TM.columns)):
    
    for j in range(0,len(df_ITCOP.columns)):
        #id validation
        if list(df_TM[i])[0]== list(df_ITCOP[j])[0] and str(list(df_TM[i])[1])==str(list(df_ITCOP[j])[1]):
            #print(list(df_TM[i])[0])
            #print(str(list(df_TM[i])[1]))
            break
        if(j==len(df_ITCOP.columns)-1):
            print(list(df_TM[i])[0])
            print(str(list(df_TM[i])[1]))
            
            
            
            