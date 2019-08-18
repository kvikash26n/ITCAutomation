'''
Created on May 6, 2019

@author: 29265
'''
#first recurring charactor count
def getkey(input):
    key=[]
    for i in input:
        #print(i)
        if i not in key:
            key.append(i)
    return key

def getOccurencerr(input,key):
    result=[]
    for i in key:#['a', 'b', 'c', 'd']
        count=0
        for j in input:#abcacd
            if i==j:
                count=count+1
        dict={i:count}
        result.append(dict)
    return result
#input='abcdd'
input=input("enter the input string: ");
key=getkey(input)

#key value camparison then pick
found=False
xx=input
xx=list(xx)
for i in range(0,len(xx)):
    x=xx[i]
    #print(x)
    res=getOccurencerr(input,key)
    for i in range(0,len(res)):
        #need to check the key value with character
        try:
            if(res[i][x])>1:
                print("for char.: '"+str(x)+"' occurence is :"+str(res[i][x]))
                found=True
                break
    
        except:
            #print("ex")
            continue
    if(found):    
        break
    else:
        continue
if(not found):
    print("no other occurence")
    