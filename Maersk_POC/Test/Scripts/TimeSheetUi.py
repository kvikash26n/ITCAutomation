'''
Created on Feb 23, 2019

@author: 29265
'''
from tkinter import filedialog

from tkinter import Button, Tk, HORIZONTAL

from tkinter.ttk import Progressbar
import time
import threading
#dir = filedialog.askdirectory()
from tkinter import *
from tkinter.filedialog import askopenfilename
from tkinter.messagebox import showerror

class MyFrame(Frame):
    def __init__(self):
        Frame.__init__(self)
        self.master.title("PMO Assistant")
        self.master.rowconfigure(2000, weight=2000)
        self.master.columnconfigure(2000, weight=2000)
        self.grid(sticky=W+E+N+S)
        
        self.label = Label(self, text="Upload ITC One Point Exported Timesheet",relief=SUNKEN,borderwidth=1,bg="#1dd1a1")
        self.label.grid(row=1000, column=100, sticky=W)
        #self.label = Label(self, text=dir,relief=SUNKEN,borderwidth=1,bg="yellow")
        
        #self.label=self.label(self,relief=SUNKEN,borderwidth=1,bg="red").grid(row=2,column=2)
        #self.label.grid(row=1000, column=1000, sticky=W)
        
        self.button = Button(self, text="Browse", relief=RIDGE,command=self.load_file123, width=20)
        self.button.grid(row=1000, column=150, padx=56, ipadx=3, pady=2, sticky=W)
        
        
        self.label = Label(self, text="Upload Customer Approved Timesheet",relief=RIDGE,borderwidth=1,bg="#1dd1a1")
        #self.label=self.label(self,relief=SUNKEN,borderwidth=1,bg="red").grid(row=2,column=2)
        self.label.grid(row=2000, column=100, sticky=W)
        
        self.btn = Button(self, text='RUN', relief=RIDGE,command=self.traitement, width=20)
        self.btn.grid(row=5000,column=100,padx=56, ipadx=3, pady=2, sticky=W)
        self.progress = Progressbar(self, orient=HORIZONTAL,length=100,  mode='indeterminate')
        
#padx=0, ipadx=5, pady=4, sticky=E
        #below can be use to show the report
        self.button = Button(self, text="Browse",relief=RIDGE, command=self.print1, width=20)
        self.button.grid(row=2000, column=150,padx=56, ipadx=3, pady=2, sticky=W)
        
        
        #self.button = Button(self, text="Run", command=self.bar, width=20)
        #self.button.grid(row=5000, column=1000,padx=56, ipadx=3, pady=2, sticky=W)
        
    def load_file123(self):
        #self.onepoint = filedialog.askdirectory()
        self.onepoint = askopenfilename(filetypes=[('CSV', '*.csv',), ('Excel', ('*.xls', '*.xlsx'))])
        self.label = Label(self, text=self.onepoint,borderwidth=1,bg="white")
        self.label.grid(row=1000, column=400, sticky=W)
      
    def print1(self):
        #C:\\Users\\29265\\Downloads\\application_train.csv
        #self.report=filedialog.askdirectory()
        self.client= askopenfilename(filetypes=[('CSV', '*.csv',), ('Excel', ('*.xls', '*.xlsx'))])
        self.label = Label(self, text=self.client,borderwidth=1,bg="white")
        self.label.grid(row=2000, column=400, sticky=W)
        
    def traitement(self):
        def real_traitement():
            import os
            f1=self.onepoint
            f2=self.client
            print(f1)
            print(f2)
            self.progress.grid(row=5000,column=150)
            self.progress.start()
            time.sleep(5)
            
            #PMO Code below
            '''
        Created on Jan 27, 2019

        @author: 29265
        '''
        #C:\Users\29265\Desktop\TSPOC
            import pandas as pd
            df_ITCOP=pd.read_excel(f1)
            df_TM=pd.read_excel(f2)
            #df_ITCOP.head(2)
            
            #df_ITCOP.head(2)

            def findAllIndex(df,key):
                df=df.groupby(key)
                return list(df.sum().index)

            def formatDate(str1):
                str1=str1.split(" ")
                str1=str1[0]
                str1=str1.split("-")
                Srt1=str1[1]+"/"+str1[2]+"/"+str1[0]
                return Srt1

            df_TM['Action']=" "

            #Finding missing resource PSID
            ITC=findAllIndex(df_ITCOP,'ID')
            Client=findAllIndex(df_TM,'PS ID')
            #find the unmatched ID
            #un=ITC-Client
            #un

            clientMis=list(set(Client) - set(ITC))
            ITCMis=list(set(ITC) - set(Client))
            if len(clientMis) == 0:
                print("Client timeSheet is matching with ITC")
            else:
                print("In itc time sheet, missing ID is : "+str(clientMis))
            if len(ITCMis) == 0:
                 print("ITC timeSheet is matching with Client")
            else:
                print("In Client time sheet,missing ID is : "+str(ITCMis))

            df_TM=df_TM.T
            df_ITCOP=df_ITCOP.T
            #df_ITCOP

            #For missing data in one point
            DataMissingInClientVsOnePoint=[]
            for i in range(0,len(df_TM.columns)):
                for j in range(0,len(df_ITCOP.columns)):
                    #id validation
                    if list(df_TM[i])[0]== list(df_ITCOP[j])[1] and str(list(df_TM[i])[2])==str(list(df_ITCOP[j])[3]):
                        break
                    if(j==len(df_ITCOP.columns)-1):
                        AllData={ "ID":str(list(df_TM[i])[0]),
                                  "Name":str(list(df_TM[i])[1]),
                                            #"EndDate":EndDate,
                                               "Date": str(list(df_TM[i])[2]),
                                                   "Quantity":str(list(df_TM[i])[5]),
                                                   "Project":str(list(df_ITCOP[j])[5]),
                                                   "ACTIVITY_DESCR":str(list(df_ITCOP[j])[7]),
                                                   "Billing Action":str(list(df_ITCOP[j])[10]),
                                                   "Source Type":str(list(df_ITCOP[j])[11]),
                                                   "Category":str(list(df_ITCOP[j])[12]),
                                                   "Subcategory":str(list(df_ITCOP[j])[13])

                                                  }
                        DataMissingInClientVsOnePoint.append(AllData)
                        #print(list(df_TM[i])[0])
                        #print(str(list(df_TM[i])[2]))


            df_DataMissingInClientVsOnePoint=pd.DataFrame(DataMissingInClientVsOnePoint)         
            #df_DataMissingInClientVsOnePoint


            #Production
            DeviationData=[]

            for i in range(0,len(df_TM.columns)):
                for j in range(0,len(df_ITCOP.columns)):
                    #id validation
                    if list(df_TM[i])[0]== list(df_ITCOP[j])[1]:
                        #date validation
                        if str(list(df_ITCOP[j])[3]) == str(list(df_TM[i])[2]):
                                if  list(df_ITCOP[j])[14] =='APR': 

                            #time quantity
                            #below only code add for source ,category,sub category validation in or condition. table will be created with data
                            #need to check flow for above comment
                            #if str(list(df_TM[i])[5])!= str(list(df_ITCOP[j])[8])'''time validation''' or str(list(df_TM[i])[4])!= str(list(df_ITCOP[j])[6])'''activity validation''' or str(list#(df_TM[i])[7])!= str(list(df_ITCOP[j])[11])'''source validation''' or str(list(df_TM[i])[8])!= str(list(df_ITCOP[j])[12])'''category''' or str(list(df_TM[i])[9])!= #str(list(df_ITCOP[j])[13])'''sub category''' :
                                    if str(list(df_TM[i])[5])!= str(list(df_ITCOP[j])[8]) or str(list(df_TM[i])[4])!= str(list(df_ITCOP[j])[6]) or str(list(df_TM[i])[7])!= str(list(df_ITCOP[j])[11]) or str(list(df_TM[i])[8])!= str(list(df_ITCOP[j])[12]) or str(list(df_TM[i])[9])!= str(list(df_ITCOP[j])[13]):

                                    #if str(list(df_TM[i])[5])!= str(list(df_ITCOP[j])[8]) or str(list(df_TM[i])[4])!= str(list(df_ITCOP[j])[7]):
                                    #print("For ID: "+str(list(df_TM[i])[0])+":"+str(list(df_TM[i])[2])+":"+"Client Quantity is- "+str(list(df_TM[i])[5])+" and "+"ITC quantity is- "+str(list(df_ITCOP[j])[8])+" is not Matching"+str(list(df_ITCOP[j])[0]))
                                        # below will be selenium code for  updating the umatching quantity in ITC portal
                                        # All date that falls in one end date sholud be categorized
                                        # Quantity sholud be mapped for each date n for each person
                                        # you can think about df formation then can proceed
                                        # selenium code will be integrate after this
                                        EndDate=str(list(df_ITCOP[j])[0])
                                        EndDate=formatDate(EndDate)
                                        Date_Mis=str(list(df_TM[i])[2]) 
                                        Date_Mis=formatDate(Date_Mis)
                                        #Function Need to be apply on EndDate to make it compitable for application
                                        Date_Dict={ "ID":str(list(df_TM[i])[0]),
                                                   #"Name":str(list(df_TM[i])[1]),
                                            "EndDate":EndDate,
                                               "Date": Date_Mis,
                                                   "Quantity":str(list(df_TM[i])[5]),
                                                   "Project":str(list(df_ITCOP[j])[5]),
                                                   "ACTIVITY_DESCR":str(list(df_TM[i])[4]),
                                                   "Billing Action":str(list(df_ITCOP[j])[10]),
                                                   "Source Type":str(list(df_TM[i])[7]),
                                                   "Category":str(list(df_TM[i])[8]),
                                                   "Subcategory":str(list(df_TM[i])[9]),
                                                   "Status":str(list(df_ITCOP[j])[14])
                                                  }
                                        DeviationData.append(Date_Dict)
                                        df_TM.loc['Action',i]='TS Corrected'
                                        #break
                                    else:
                                         df_TM.loc['Action',i]='No action'
                                elif list(df_ITCOP[j])[14] =='SUB':
                                    df_TM.loc['Action',i]='Manager To Approve' 
                                elif list(df_ITCOP[j])[14] =='SAV':
                                    df_TM.loc['Action',i]='Yet To Submit' 
                                elif list(df_ITCOP[j])[14] =='PND':
                                    #if str(list(df_TM[i])[5])!= str(list(df_ITCOP[j])[8]) or str(list(df_TM[i])[4])!= str(list(df_ITCOP[j])[6]) or str(list(df_TM[i])[7])!= str(list(df_ITCOP[j])[11]) or str(list(df_TM[i])[8])!= str(list(df_ITCOP[j])[12]) or str(list(df_TM[i])[9])!= str(list(df_ITCOP[j])[13]):

                                    #if str(list(df_TM[i])[5])!= str(list(df_ITCOP[j])[8]) or str(list(df_TM[i])[4])!= str(list(df_ITCOP[j])[7]):
                                    #print("For ID: "+str(list(df_TM[i])[0])+":"+str(list(df_TM[i])[2])+":"+"Client Quantity is- "+str(list(df_TM[i])[5])+" and "+"ITC quantity is- "+str(list(df_ITCOP[j])[8])+" is not Matching"+str(list(df_ITCOP[j])[0]))
                                        # below will be selenium code for  updating the umatching quantity in ITC portal
                                        # All date that falls in one end date sholud be categorized
                                        # Quantity sholud be mapped for each date n for each person
                                        # you can think about df formation then can proceed
                                        # selenium code will be integrate after this
                                    EndDate=str(list(df_ITCOP[j])[0])
                                    EndDate=formatDate(EndDate)
                                    Date_Mis=str(list(df_TM[i])[2]) 
                                    Date_Mis=formatDate(Date_Mis)
                                    #Function Need to be apply on EndDate to make it compitable for application
                                    Date_Dict={ "ID":str(list(df_TM[i])[0]),
                                               #"Name":str(list(df_TM[i])[1]),
                                        "EndDate":EndDate,
                                           "Date": Date_Mis,
                                               "Quantity":str(list(df_TM[i])[5]),
                                               "Project":str(list(df_ITCOP[j])[5]),
                                               "ACTIVITY_DESCR":str(list(df_TM[i])[4]),
                                               "Billing Action":str(list(df_ITCOP[j])[10]),
                                               "Source Type":str(list(df_TM[i])[7]),
                                               "Category":str(list(df_TM[i])[8]),
                                               "Subcategory":str(list(df_TM[i])[9]),
                                               "Status":str(list(df_ITCOP[j])[14])
                                              }
                                    DeviationData.append(Date_Dict)
                                    df_TM.loc['Action',i]='TS Corrected' 

            df_TimeTable=pd.DataFrame(DeviationData)
            #df_TM
            df_TimeTable



            #df_TM
            #df_TimeTable
            if df_TimeTable.shape[0]==0:
                print("All data is already correct in client and One Point TS")
            else:


                #below is for testing purpose
                xyz=list(df_TimeTable['EndDate'].unique())

                abc=list(df_TimeTable['Status'].unique())

                df_TimeTable=df_TimeTable.T
                Auto=[]
                for i in range(0,len(abc)):

                    for k in range(0,len(xyz)):
                        listdate=[]
                        quantity=[]

                        for j in df_TimeTable.columns:
                            if abc[i]== list(df_TimeTable[j])[9] and xyz[k]==list(df_TimeTable[j])[4]:
                                listdate.append(list(df_TimeTable[j])[3])
                                quantity.append(list(df_TimeTable[j])[7])
                        if len(listdate)!=0:
                            dict={#'id':abc[i],
                                'Status':abc[i],
                                  'endDate':list(df_TimeTable[k])[4],
                                  'date':listdate,
                                  'quantity':quantity,
                                   'Project':list(df_TimeTable[j])[6],
                                   "ACTIVITY_DESCR":list(df_TimeTable[j])[0],
                                   "Billing Action":list(df_TimeTable[j])[1],
                                   "Source Type":list(df_TimeTable[j])[8],
                                   "Category":list(df_TimeTable[j])[2],
                                    # "Status":str(list(df_TimeTable[j])[9]),  
                                    'id':list(df_TimeTable[j])[5],
                                   "Subcategory":list(df_TimeTable[j])[10]

                            } 
                            Auto.append(dict)
                df_Auto=pd.DataFrame(Auto)
                df_Auto=df_Auto.T
                df_Auto        
                #working code above


                def findDay(dateinput):
                    import datetime
                    a=dateinput #MM/DD/YYYY
                    a=a.split("/")
                    b=a[1]+"/"+a[0]+"/"+a[2]

                    dt =b #'01/04/2019' # dd/mm/YYYY
                    day, month, year = (int(x) for x in dt.split('/'))    
                    ans = datetime.date(year, month, day)
                    #print (ans.strftime("%A"))
                    day=ans.strftime("%A")
                    return day

                '''
                Selenium Script
                '''

                '''
                Created on Jan 16, 2019

                @author: 29265
                Kumar Vikash
                '''
            

                from selenium import webdriver
                from selenium.common.exceptions import NoSuchElementException
                from selenium.webdriver.common.keys import Keys
                from selenium.webdriver.support.ui import Select

                import numpy as np
                import pandas as pd

                driver=webdriver.Chrome("D:\\chromedriver.exe")
                #driver.set_page_load_timeout(60)
                driver.implicitly_wait(40)
                driver.maximize_window()
                driver.get("https://i3lmobile.itcinfotech.com")

                elem = driver.find_element_by_xpath("//*[@id='userid']")
                elem.send_keys("29265")
                elem = driver.find_element_by_xpath("//*[@id='pwd']")
                elem.send_keys("l@litaDEVI2@4")
                #click on login button below
                elem = driver.find_element_by_xpath("//*[@class='ps-button']")
                elem.click()

                #df_Auto
                for i in df_Auto.columns:
                    #Checking the status below then as per that,going to take action,like Approved,Pending,PartialApproved
                    status=list(df_Auto[i])[5]
                    if status=='APR':
                        eID=list(df_Auto[i])[9]
                        endDate=list(df_Auto[i])[8]
                        date=list(df_Auto[i])[7]
                        quantity=list(df_Auto[i])[10]

                        time.sleep(5)
                        elem = driver.find_element_by_xpath("//a[@class='EOPP_SCCHILDCONTENTLINK' and contains(text(),'View')]")
                        elem.click()

                        #elem = driver.find_element_by_id("EX_TIME_ADD_VW_EMPLID$prompt$img")
                        #elem.click()
                        time.sleep(5)
                        driver.switch_to_default_content()
                        driver.switch_to_frame(driver.find_element_by_xpath("//*[@title='TargetContent']"))

                        dropdwn = driver.find_element_by_xpath("//*[contains(@id,'KeySelect')]")
                        myselect = Select(dropdwn)
                        myselect.select_by_visible_text("Empl ID")
                        time.sleep(3)
                        'input emp id'
                        elem = driver.find_element_by_xpath("//*[@class='PSEDITBOX']")
                        elem.send_keys(eID)
                        time.sleep(3)
                        'search'
                        elem = driver.find_element_by_xpath("//*[contains(@id,'ICSearch')]")
                        elem.click()
                        time.sleep(5)
                        xl="(//*[text()='"
                        xr="']//ancestor::tr)[2]//a"
                        #driver.find_element_by_xpath("(//*[text()='01/20/2019']//ancestor::tr)[2]//a").click()

                        driver.find_element_by_xpath(xl+str(endDate)+xr).click()
                        time.sleep(10)
                        dropdwn = driver.find_element_by_xpath("//*[@class='PSDROPDOWNLIST']")
                        myselect = Select(dropdwn)
                        myselect.select_by_visible_text("Create Revision")
                        time.sleep(5)
                        driver.find_element_by_xpath("//*[@value='GO']").click()
                        time.sleep(5)
                        #need to add project validation in project page 
                        driver.find_element_by_xpath("//*[@title='Details']").click()

                        #driver.switch_to_default_content()
                        #driver.switch_to_frame(driver.find_element_by_xpath("//*[@title='Main Content']"))
                        time.sleep(4)
                        print(driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[3]").get_attribute("value"))
                        #activity
                        if driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[3]").get_attribute("value") == list(df_Auto[i])[0]:
                            pass
                        else:
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[3]").clear()
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[3]").send_keys(list(df_Auto[i])[0])
                        #source type
                        if driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[4]").get_attribute("value") == list(df_Auto[i])[4]:
                            pass
                        else:
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[4]").clear()
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[4]").send_keys(list(df_Auto[i])[4])
                        #category
                        if driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[5]").get_attribute("value") == list(df_Auto[i])[2]:
                            pass
                        else:
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[5]").clear()
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[5]").send_keys(list(df_Auto[i])[2])
                        #sub category
                        if driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[6]").get_attribute("value") == list(df_Auto[i])[6]:
                            pass
                        else:
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[6]").clear()
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[6]").send_keys(list(df_Auto[i])[6])

                        driver.find_element_by_xpath("//*[@class='PSPUSHBUTTON']").click()
                        time.sleep(4)
                        #need to validate project deti
                        for j in range(0,len(date)):
                            #loop will fill all date quantity ,same will be handled in xpath ,will be formed using date itself
                            #date[j]
                            #quantity[j]
                            #AFTER filling need to submit

                            #[01/02/2019, 01/04/2019]
                            day=findDay(date[j])
                            if day== "Monday":
                                driver.find_element_by_xpath("//input[contains(@id,'TIME1')]").clear()
                                driver.find_element_by_xpath("//input[contains(@id,'TIME1')]").send_keys(quantity[j])
                            elif day== "Tuesday":
                                driver.find_element_by_xpath("//input[contains(@id,'TIME2')]").clear()
                                driver.find_element_by_xpath("//input[contains(@id,'TIME2')]").send_keys(quantity[j])
                            elif day== "Wednesday":
                                driver.find_element_by_xpath("//input[contains(@id,'TIME3')]").clear()
                                driver.find_element_by_xpath("//input[contains(@id,'TIME3')]").send_keys(quantity[j])
                            elif day== "Thursday":
                                driver.find_element_by_xpath("//input[contains(@id,'TIME4')]").clear()
                                driver.find_element_by_xpath("//input[contains(@id,'TIME4')]").send_keys(quantity[j])
                            elif day== "Friday":
                                driver.find_element_by_xpath("//input[contains(@id,'TIME5')]").clear()
                                driver.find_element_by_xpath("//input[contains(@id,'TIME5')]").send_keys(quantity[j])
                        #click on submit button after filling the particuler enddate enrty
                        driver.find_element_by_xpath("//*[@value='Submit']").click()
                        #click on ok button
                        time.sleep(3)
                        driver.find_element_by_xpath("//*[@title='Ok (Enter)']").click()
                        time.sleep(3)
                        #click on home button & after that script will go for next emp id and do the same
                        driver.find_element_by_xpath("//*[@title='Home']").click()
                        time.sleep(6)
                    elif status=='PRL':
                        pass
                    elif status=='PND':
                        eID=list(df_Auto[i])[9]
                        endDate=list(df_Auto[i])[8]
                        date=list(df_Auto[i])[7]
                        quantity=list(df_Auto[i])[10]

                        time.sleep(5)
                        elem = driver.find_element_by_xpath("//a[text()='Modify']")
                        elem.click()

                        #elem = driver.find_element_by_id("EX_TIME_ADD_VW_EMPLID$prompt$img")
                        #elem.click()
                        time.sleep(5)
                        driver.switch_to_default_content()
                        driver.switch_to_frame(driver.find_element_by_xpath("//*[@title='Main Content']"))
                        try:
                            driver.find_element_by_xpath("//a[text()='Basic Search']").click()
                            dropdwn = driver.find_element_by_xpath("//*[contains(@id,'KeySelect')]")
                            myselect = Select(dropdwn)
                            myselect.select_by_visible_text("Empl ID")
                            'input emp id'
                            elem = driver.find_element_by_xpath("(//*[@class='PSPAGECONTAINER']//input)[2]")
                            elem.send_keys(eID)
                        except:
                            pass
                            dropdwn = driver.find_element_by_xpath("//*[contains(@id,'KeySelect')]")
                            myselect = Select(dropdwn)
                            myselect.select_by_visible_text("Empl ID")
                            time.sleep(3)
                            'input emp id'
                            elem = driver.find_element_by_xpath("(//*[@class='PSPAGECONTAINER']//input)[2]")
                            elem.send_keys(eID)

                        'search'
                        time.sleep(3)
                        elem = driver.find_element_by_xpath("//*[contains(@id,'ICSearch')]")
                        elem.click()
                        #time.sleep(5)
                        xl="(//*[text()='"
                        xr="']//ancestor::tr)[2]//a"
                        #driver.find_element_by_xpath("(//*[text()='01/20/2019']//ancestor::tr)[2]//a").click()

                        #driver.find_element_by_xpath(xl+str(endDate)+xr).click()
                        time.sleep(10)
                        try:
                            driver.find_element_by_xpath(xl+str(endDate)+xr).click()
                        except:
                            pass
                        #need to add project validation in project page 
                        driver.find_element_by_xpath("//*[@title='Details']").click()

                        #driver.switch_to_default_content()
                        #driver.switch_to_frame(driver.find_element_by_xpath("//*[@title='Main Content']"))
                        time.sleep(4)
                        print(driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[3]").get_attribute("value"))
                        #activity
                        if driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[3]").get_attribute("value") == list(df_Auto[i])[0]:
                            pass
                        else:
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[3]").clear()
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[3]").send_keys(list(df_Auto[i])[0])
                        #source type
                        if driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[4]").get_attribute("value") == list(df_Auto[i])[4]:
                            pass
                        else:
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[4]").clear()
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[4]").send_keys(list(df_Auto[i])[4])
                        #category
                        if driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[5]").get_attribute("value") == list(df_Auto[i])[2]:
                            pass
                        else:
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[5]").clear()
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[5]").send_keys(list(df_Auto[i])[2])
                        #sub category
                        if driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[6]").get_attribute("value") == list(df_Auto[i])[6]:
                            pass
                        else:
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[6]").clear()
                            driver.find_element_by_xpath("(//*[@class='PSEDITBOX'])[6]").send_keys(list(df_Auto[i])[6])

                        driver.find_element_by_xpath("//*[@class='PSPUSHBUTTON']").click()
                        time.sleep(4)

                        #need to validate project deti
                        for j in range(0,len(date)):
                            #loop will fill all date quantity ,same will be handled in xpath ,will be formed using date itself
                            #date[j]
                            #quantity[j]
                            #AFTER filling need to submit

                            #[01/02/2019, 01/04/2019]
                            day=findDay(date[j])
                            if day== "Monday":
                                driver.find_element_by_xpath("//input[contains(@id,'TIME1')]").clear()
                                driver.find_element_by_xpath("//input[contains(@id,'TIME1')]").send_keys(quantity[j])
                            elif day== "Tuesday":
                                driver.find_element_by_xpath("//input[contains(@id,'TIME2')]").clear()
                                driver.find_element_by_xpath("//input[contains(@id,'TIME2')]").send_keys(quantity[j])
                            elif day== "Wednesday":
                                driver.find_element_by_xpath("//input[contains(@id,'TIME3')]").clear()
                                driver.find_element_by_xpath("//input[contains(@id,'TIME3')]").send_keys(quantity[j])
                            elif day== "Thursday":
                                driver.find_element_by_xpath("//input[contains(@id,'TIME4')]").clear()
                                driver.find_element_by_xpath("//input[contains(@id,'TIME4')]").send_keys(quantity[j])
                            elif day== "Friday":
                                driver.find_element_by_xpath("//input[contains(@id,'TIME5')]").clear()
                                driver.find_element_by_xpath("//input[contains(@id,'TIME5')]").send_keys(quantity[j])
                        #click on submit button after filling the particuler enddate enrty
                        driver.find_element_by_xpath("//*[@value='Submit']").click()
                        time.sleep(3)
                        driver.switch_to_default_content()
                        driver.switch_to_frame(driver.find_element_by_xpath("//*[@class='PSMODALCONTENT']//iframe"))
                        #click on ok button
                        driver.find_element_by_xpath("//*[@title='Ok (Enter)']").click()
                        time.sleep(6)
                        #click on home button & after that script will go for next emp id and do the same
                        driver.switch_to_default_content()
                        driver.find_element_by_xpath("//*[@title='Home']").click()
                        time.sleep(6)





            #Report
            if df_TimeTable.shape[0]==0 and df_DataMissingInClientVsOnePoint.shape[0]==0:
                print("No data no table")
                df_TM=df_TM.T
                #df_Auto=df_Auto.T

                writer = pd.ExcelWriter('C:\\Users\\29265\\Desktop\\TSPOC\\TS Report.xlsx', engine='xlsxwriter')

                df_TM.to_excel(writer, sheet_name='Final Report',startrow=0,index = False,startcol=0) 
                workbook  = writer.book
                worksheet = writer.sheets['Final Report']

                red_format = workbook.add_format({'bg_color':'red'})
                #purple_format = workbook.add_format({'bg_color':'purple'})
                green_format = workbook.add_format({'bg_color':'green'})

                worksheet.conditional_format('K2:K200', {'type': 'text',
                                                      'criteria': 'containing',
                                                       'value':   'No action',
                                                       'format': green_format})

                worksheet.conditional_format('K2:K200', {'type': 'text',
                                                      'criteria': 'containing',
                                                       'value':   'TS Corrected',
                                                       'format':  green_format})
                worksheet.conditional_format('K2:K200', {'type': 'text',
                                                      'criteria': 'containing',
                                                       'value':   'Manager To Approve',
                                                       'format':  red_format})

                total_col = workbook.add_format({'align': 'center', 'font_color': 'white',
                                                 'bold': True, 'bottom':0,'font_size':10})
                worksheet.set_column('A:K', 15)
                worksheet.set_column('H:H', 15)
                worksheet.set_column('K:K', 20, total_col)
                #worksheet.set_column('K:K', 20, total_fmt)
                #worksheet.add_table('B3:F7', {'data': df_TM,
                                        #      'style': 'Table Style Light 11'})
                # Add a header format.
                header_format = workbook.add_format({
                    'align': 'center',
                    'bold': True,
                'font_color': 'dark blue',
                'font_size':10,
                    'text_wrap': False,
                    'valign': 'top',
                    'fg_color': '#ffcccc',
                    'border': 1

                })


                # Write the column headers with the defined format.
                for col_num, value in enumerate(df_TM.columns.values):
                    worksheet.write(0, col_num , value, header_format)

                writer.save()
            else:
                df_TM=df_TM.T
                df_Auto=df_Auto.T

                writer = pd.ExcelWriter('C:\\Users\\29265\\Desktop\\TSPOC\\TS Report.xlsx', engine='xlsxwriter')

                df_TM.to_excel(writer, sheet_name='Final Report',startrow=0,index = False,startcol=0) 
                workbook  = writer.book
                worksheet = writer.sheets['Final Report']

                red_format = workbook.add_format({'bg_color':'red'})
                purple_format = workbook.add_format({'bg_color':'purple'})
                green_format = workbook.add_format({'bg_color':'green'})

                worksheet.conditional_format('K2:K200', {'type': 'text',
                                                      'criteria': 'containing',
                                                       'value':     'No action',
                                                       'format': green_format})

                worksheet.conditional_format('K2:K200', {'type': 'text',
                                                      'criteria': 'containing',
                                                       'value':   'TS Corrected',
                                                       'format':  green_format})
                worksheet.conditional_format('K2:K200', {'type': 'text',
                                                      'criteria': 'containing',
                                                       'value':   'Manager To Approve',
                                                       'format':  red_format})

                total_col = workbook.add_format({'align': 'center', 'font_color': 'white',
                                                 'bold': True, 'bottom':0,'font_size':10})
                worksheet.set_column('A:K', 15)
                worksheet.set_column('H:H', 15)
                worksheet.set_column('K:K', 20, total_col)
                #worksheet.set_column('K:K', 20, total_fmt)
                #worksheet.add_table('B3:F7', {'data': df_TM,
                                        #      'style': 'Table Style Light 11'})
                # Add a header format.
                header_format = workbook.add_format({
                    'align': 'center',
                    'bold': True,
                'font_color': 'dark blue',
                'font_size':10,
                    'text_wrap': False,
                    'valign': 'top',
                    'fg_color': '#ffcccc',
                    'border': 1

                })


                # Write the column headers with the defined format.
                for col_num, value in enumerate(df_TM.columns.values):
                    worksheet.write(0, col_num , value, header_format)


                df_Auto.to_excel(writer, sheet_name='Modified Report',startrow=0,index = False,startcol=0)  # Default position, cell A1.

                #workbook  = writer.book
                worksheet = writer.sheets['Modified Report']
                total_col = workbook.add_format({'align': 'center', 'font_color': 'black',
                                                 'bold': True, 'bottom':0,'font_size':10})
                worksheet.set_column('A:J', 15,total_col)
                worksheet.set_column('H:H', 15,total_col)
                total_fmt = workbook.add_format({'align': 'center', 'font_color': 'red',
                                                 'bold': True, 'bottom':0,'underline':1})
                worksheet.set_column('I:I', 12, total_fmt)
                # Add a header format.
                ##ffcccc  #D7E4BC
                header_format = workbook.add_format({
                    'align': 'center',
                    'bold': True,
                'font_color': 'dark blue',
                'font_size':10,
                    'text_wrap': False,
                    'valign': 'top',
                    'fg_color': '#ffcccc',
                    'border': 1

                })

                #=HYPERLINK("#Config_Dimension_Cust!A1","Failed")
                # Write the colu8mn headers with the defined format.
                for col_num, value in enumerate(df_Auto.columns.values):
                    worksheet.write(0, col_num , value, header_format)

                # df_DataMissingInClientVsOnePoint
                df_DataMissingInClientVsOnePoint.to_excel(writer, sheet_name='ClientVsOnePointReport',startrow=0,index = False,startcol=0)  # Default position, cell A1.

                #workbook  = writer.book
                worksheet = writer.sheets['ClientVsOnePointReport']
                total_col = workbook.add_format({'align': 'center', 'font_color': 'black',
                                                 'bold': True, 'bottom':0,'font_size':10})
                worksheet.set_column('A:J', 15,total_col)
                worksheet.set_column('H:H', 15,total_col)
                total_fmt = workbook.add_format({'align': 'center', 'font_color': 'red',
                                                 'bold': True, 'bottom':0,'underline':1})
                worksheet.set_column('I:I', 12, total_fmt)
                # Add a header format.
                ##ffcccc  #D7E4BC
                header_format = workbook.add_format({
                    'align': 'center',
                    'bold': True,
                'font_color': 'dark blue',
                'font_size':10,
                    'text_wrap': False,
                    'valign': 'top',
                    'fg_color': '#ffcccc',
                    'border': 1

                })

                #=HYPERLINK("#Config_Dimension_Cust!A1","Failed")
                # Write the colu8mn headers with the defined format.
                for col_num, value in enumerate( df_DataMissingInClientVsOnePoint.columns.values):
                    worksheet.write(0, col_num , value, header_format)

                writer.save()

            
            #End here
            self.progress.stop()
            self.progress.grid_forget()

            self.btn['state']='normal'
            #below path will come from report variable
            os.startfile('C:\\Users\\29265\\Desktop\\data.xlsx')
        self.btn['state']='disabled'
        threading.Thread(target=real_traitement).start()
        
if __name__ == "__main__":
   
    MyFrame().mainloop()


#root='C:\\Users\\29265\\Desktop\\petraInt'
