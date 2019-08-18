'''
Created on Aug 4, 2018

@author: 29265
'''
#use for getting all column name
f=open('C:\\Users\\29265\\Desktop\\abc1.txt')
f.seek(0)
a=f.readlines()
a
key=[]
type=[]

st=a
for i in st:
    
    for ch in ['MetaData:=',''':=StringType(18):',''''\n',':','ConfigFileInfo','Query','Data','DATAQUALITY','SparkInputArguments','\n']:  
        
        if ch in i:
            i=i.replace(ch,'')
            x=i.split('=')
    key.append(x)
keynew=[]
for i in range(0,len(key)):
    p=key[i]
    p=p[0]
    keynew.append(p)
keynew
while '' in keynew:
    keynew.remove('')
keynew
print(keynew)
