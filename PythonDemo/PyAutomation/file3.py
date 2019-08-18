'''
Created on Aug 4, 2018

@author: 29265
'''
import string

f=open('C:\\Users\\29265\\Desktop\\abc1.txt')
f.seek(0)
a=f.readlines()
a
#with open("hnr1.abc","r") as fi:
id = []
for ln in a:
    if ln.startswith("MetaData:="):
        
        id.append(ln[10:])
print(id)
lt_dict=[]
for i in range(0,len(id)):
    zz=id[i]
    zz=zz.split(':=')
    pp= string.replace(zz[2], '\n', '')
    #print(new_str)
    #val=val.replace('\n','')
    dict={zz[0]:pp}
    lt_dict.append(dict)
print(lt_dict)

'''   
zz=id[0]
print(zz)
zz=zz.split(':=')
print (zz[2])
'''