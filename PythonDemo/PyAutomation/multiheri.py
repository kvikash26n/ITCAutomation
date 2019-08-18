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
class th(second):
    def add1(self):
        print("my name is"+self.name)
ob=th('vik',23)
ob.show()
ob.add()
ob.add1()

#method overridding
class dog:
    def show(self):
        print("name")
class cat(dog):
    def show(self):
        print("name vikash")
ob=cat()
ob.show()