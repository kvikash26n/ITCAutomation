'''
Created on Aug 15, 2018

@author: 29265
'''
import pandas as pd
dfnull=pd.read_excel("C:\\Users\\29265\\Valnull.xlsx")
dfnull

def filterVariables(df):
    data = []
    for col in df.columns:
        if df[col].nunique()>3: #dtype == 'float64':
            level = 'continuous'
        elif df[col].nunique()<3: #dtype == 'int64':
            level = 'class'
       

        col_dict = {
            'varname': col,
            'datatype': df[col].dtype,
            'continuous_class': level
           
        }
        data.append(col_dict)
        

    meta = pd.DataFrame(data, columns=['varname', 'datatype','continuous_class'])
    meta.set_index('varname', inplace=True)
    return meta

df_new=filterVariables(dfnull)

df_new=df_new.T
df_new

for i in df_new.columns:
   for j in dfnull.columns:
       
       if i==j:
           
           if list(df_new[i])[1]=='continuous':
               
               
                a=dfnull[i].median()
                dfnull[i].fillna(a,inplace=True)
           else:
                a=dfnull[i].mode()
                dfnull[i].fillna(a,inplace=True)
dfnull