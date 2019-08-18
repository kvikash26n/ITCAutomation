'''
Created on Aug 4, 2018

@author: 29265
'''
# MetaData:=CustId:=StringType(18):=NonNullable\n


key=[]

#string="abc&def#ghi"
st='MetaData:=CustId:=StringType(18):=NonNullable\n'
#for i in 
for ch in ['MetaData:=','\n',':','ConfigFileInfo','Query','Data','DATAQUALITY','SparkInputArguments']:
    
#':=StringType(18):' 
    if ch in st: #7204852839
        
        st=st.replace(ch,'')
    x=st.split('=')
print(x)
dict={'id':x[2] }
print(dict)

f=open('C:\\Users\\29265\\Desktop\\abc.txt')
f.seek(0)
a=f.readlines()
print (a)