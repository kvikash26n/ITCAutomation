'''
Created on Aug 6, 2018

@author: 29265
'''
import pandas as pd

#to get all dublicate value from primary key column
df_data=pd.read_csv("C:\\Users\\29265\\Desktop\\Data_Dimension_Cust.csv")
df_count_val=df_data.CustId.value_counts()
df_count_val=pd.DataFrame(df_count_val)#columns=['value','count']
#df_count_val
df_count_val_T=df_count_val.T
#df_count_val_T
dublicate_val=[]
for i in df_count_val_T.columns:
    zzz=df_count_val_T[i]
    if zzz[0]!=1:
        #print(i)
           dublicate_val.append(i)
#if dublicate_val==null:
len(dublicate_val)
if len(dublicate_val)!=0:
    print(dublicate_val)
else:
    print('all record are unique in primary key column')