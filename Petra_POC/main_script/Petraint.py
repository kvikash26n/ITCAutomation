'''
Created on Sep 20, 2018

@author: 29265
'''
#use for getting all column name
import pandas as pd

#**************************************
#use for getting all column name
#C:\Users\29265\Desktop\PetraImfFile
import pandas as pd
# a=sys.argv[1]

import os
total_file=os.listdir("C:\\Users\\29265\\Desktop\\\petraInt")
total_file

for i in range(1,len(total_file)):
    
    x1='C:\\Users\\29265\\Desktop\\petraInt'
    x1=x1+total_file[i]

#C:\Users\29265\Desktop
x1='C:\\Users\\29265\\Desktop\\petraInt'


x='C:\\Users\\29265\\Desktop\\PetraImfFile\\Config_Dimension_Cust.txt'
z='C:\\Users\\29265\\Desktop\\PetraImfFile\\Data_Dimension_Cust.csv'
f=open(x)
f.seek(0)
a=f.readlines()
a
key=[]
type=[]
#Take one list that will go in report
NotMatch_Column=[]

st=a
for i in st:
    
    for ch in ['MetaData:=',''':=StringType(18):',''''\n',':','ConfigFileInfo','Query','Data','DATAQUALITY','SparkInputArguments','\n']:  
        
        if ch in i:
            i=i.replace(ch,'')
            x=i.split('=')
    key.append(x)
#print(key)
keynew=[]
for i in range(0,len(key)):
    p=key[i]
    p=p[0]
    keynew.append(p)
keynew
while '' in keynew:
    keynew.remove('')
print(keynew)
#print(len(keynew))
import pandas as pd
df_data=pd.read_csv(z)
#@df3=pd.read_excel("C:\\Users\\29265\\Desktop\\data.xlsx",sheetname='Sheet6')
#df3

data_col=list(df_data.columns)
data_col
insection=list(set(data_col) & set(keynew))
insection
if set(keynew) == set(insection):
    print('passed')
  
    dic_notmatch_col={'Not_Matched_Column':NotMatch_Column}
else:
    NotMatch_Column=list(set(insection)-set(keynew))
    NotMatch_Column=['CommercialName']
    dic_notmatch_col={'Not_Matched_Column':NotMatch_Column}
#if false

#to get all dublicate value from primary key column
df_data=pd.read_csv("C:\\Users\\29265\\Desktop\\PetraImfFile\\Data_Dimension_Cust.csv")
df_count_val=df_data.CustId.value_counts()
df_count_val=pd.DataFrame(df_count_val)#columns=['value','count']
#df_count_val
df_count_val_T=df_count_val.T
#df_count_val_T
dublicate_val=[]
primarykeyduplicate_Count=[]
d_count=[]
for i in df_count_val_T.columns: 
    zzz=df_count_val_T[i]
    if zzz[0]!=1:
        #print(i)
           dublicate_val.append(i)
#if dublicate_val==null:
len(dublicate_val)
if len(dublicate_val)!=0:
    print(dublicate_val)
    for j in range(0,len(dublicate_val)):
        a=list(df_count_val_T[dublicate_val[j]])
        a=a[0]
        ex_dic_df_dublicate={'PrimaryKey-CustID_Duplicate_Counts':dublicate_val[j],'Total Count':a}
        primarykeyduplicate_Count.append(ex_dic_df_dublicate)
else:
    print('all record are unique in primary key column')
primarykeyduplicate_Count
pd.DataFrame(primarykeyduplicate_Count)

#to get all col n type
import string
import re
f=open('C:\\Users\\29265\\Desktop\\PetraImfFile\\Config_Dimension_Cust.txt')
f.seek(0)
a=f.readlines()
a

id = []
for ln in a:
    if ln.startswith("MetaData:="):
        
        id.append(ln[10:])
#print(id)
lt_dict={}
for i in range(0,len(id)):
    zz=id[i]
    zz=zz.split(':=')
    pp = re.sub('[\n]', '', zz[2])
    lt_dict[zz[0]]=pp
print(lt_dict)

# columns list #data_col
# lt_dict
#keynew
for i in range(0,len(keynew)):
    for j in range(0,len(data_col)):
        
    
    #print(keynew[i])
    #print(lt_dict[keynew[i]])
        if keynew[i]==data_col[j]:
            type=lt_dict[keynew[i]]
            total_count=list(df_data[keynew[i]])
            
            print(total_count)
            #print(keynew[i])
            print(df_data.shape[0])
        #df_data[i]
        
    
df_data1=pd.read_csv(z)
#df_count_val12=df_data1.SourceSystemId.value_counts()
df_count_val12=df_data1['CustId'].isnull().sum()
#df.isnull().sum()
print(df_count_val12)
df_data1.shape[0]

#to get all columns wise null value count
# columns list #data_col
# lt_dict
#keynew
Null_Value_Count=[]

for i in range(0,len(keynew)):
    for j in range(0,len(data_col)):
        
    
    #print(keynew[i])
    #print(lt_dict[keynew[i]])
        if keynew[i]==data_col[j]:
            type=lt_dict[keynew[i]]
            #print(type)
            # | (type=='Nullable'):
            if (type=='NonNullable'):
                
                #df_count_val12 should be equal to zero
                df_count_val12=df_data[keynew[i]].isnull().sum()
                if df_count_val12!=0:
                    print("for column: '{}' total null count is :{}".format(keynew[i],df_count_val12))
                    
                    ex_dic_df={'Column Name':keynew[i],
                               'Null Count':df_count_val12
                        
                    }
                   
                    Null_Value_Count.append(ex_dic_df)
                    #ex_dic_df[keynew[i]]=df_count_val12
                 
            '''   
            if (type=='Nullable'):
                
                #df_count_val12 should be equal to zero
                df_count_val12=df_data[keynew[i]].isnull().sum()
                if df_count_val12!=0:
                    print("for column: '{}' total null count is :{}".format(keynew[i],df_count_val12))
            '''      
import openpyxl
#d=pd.DataFrame({'b':[2,3]})

#print(df134)
c=[]
dfblank=pd.DataFrame(c)
df123=pd.DataFrame(dic_notmatch_col)
#primarykeyduplicate_Count
#df124=pd.DataFrame(ex_dic_df_dublicate)
df124=pd.DataFrame(primarykeyduplicate_Count)
dup_total_Count=df124['Total Count'].sum()
#total_Count=df125['Null Count'].sum()
df125=pd.DataFrame(Null_Value_Count)
total_Count=df125['Null Count'].sum()
f_p_status={'No Of Files Verified':1,
            'No_Of Success':0,
            'No_Of Failed':1
    
    
    
}
b=[]
b.append(f_p_status)
df_f_p_status=pd.DataFrame(b)
#df_f_p_status.style.set_properties(subset=['No Of Files Verified','No_Of Success','No_Of Failed'], **{'width': '1000px'})
df_f_p_status=df_f_p_status.T
dict={'Config':'=HYPERLINK("#Config_Dimension_Cust!A1","Config_Dimension_Cust")',
      'DataFile':'=HYPERLINK("#Config_Dimension_Cust!A1","Data_Dimension_Cust")',
     'Not_Matched_Column':'',
      'Dublicate_Counts_PK':dup_total_Count,
     'NotNullable_Count':total_Count,
     'Status':'=HYPERLINK("#Config_Dimension_Cust!A1","Failed")'
     }
a=[]
a.append(dict)
df134=pd.DataFrame(a)
writer = pd.ExcelWriter('Petra_ReportInt.xlsx', engine='xlsxwriter')

df134.to_excel(writer, sheet_name='Summary_Report',startrow=0,index = False,startcol=0) 
workbook  = writer.book
worksheet = writer.sheets['Summary_Report']
worksheet.set_column('A:G', 20)
worksheet.set_column('H:H', 20)
# Add a header format.
header_format = workbook.add_format({
    'bold': True,
'font_color': 'dark blue',
    'text_wrap': False,
    'valign': 'top',
    'fg_color': '#D7E4BC',
    'border': 1
    
})


# Write the column headers with the defined format.
for col_num, value in enumerate(df134.columns.values):
    worksheet.write(0, col_num , value, header_format)


df123.to_excel(writer, sheet_name='Config_Dimension_Cust',startrow=2)  # Default position, cell A1.
df124.to_excel(writer, sheet_name='Config_Dimension_Cust',startcol=3,startrow=2)  # Default position, cell A1.
df125.to_excel(writer, sheet_name='Config_Dimension_Cust', startcol=7,startrow=2)

df_f_p_status.to_excel(writer, sheet_name='Summary_Report',header=False,startcol=7) 

#d.to_excel(writer, sheet_name='Config_Dimension_Cust',startrow=1)

writer.save()
