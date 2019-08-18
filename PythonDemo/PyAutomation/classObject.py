'''
Created on Feb 3, 2019

@author: 29265
'''
class first:
    def __init__(self,name,age):
        self.name=name
        self.age=age
    def show(self):
        print(self.age)
class second(first):
    def add(self):
        print("my name is"+self.name)
#ob=first('vikash',23)
#print(ob.name)
#ob.show()
ob=second('vik',23)
ob.add()

        