'''
Created on Oct 3, 2018

@author: 29265
'''
import pandas as pd
from selenium import webdriver
import  time
import numpy as np
from selenium.webdriver.common.keys import Keys
from selenium.common.exceptions import NoSuchElementException 
import random
import smtplib
from email.mime.text import MIMEText
#C:\Automation\Petra_POC\main_script\config.txt
def Sendmail(Carrier,Input,VGMWeightexcel,VGMWApp,Result,Message,to,cc):
    import smtplib
    import datetime
    from email.mime.text import MIMEText
    now = datetime.datetime.now()
    
    text1="Dear User,"
    text2="\nVGM Acknowledgement BOT has completed it run on "+str(now)
    text3="\n    Carrier "+Carrier
    text4 = "\n    Shipment Tracking ID "+Input
    text5 = "\n    VGM Weight (Carrier) "+VGMWApp
    text6 = "\n    VGM Weight (APLL) "+str(VGMWeightexcel)
    text7 = "\n    VGM Acknowledgement Result "+Result
    text8 = "\n    Validation Message "+ Message

    text9 = "\nThank you"

    text10 = "\nVGM Acknowledgement BOT "
    textfinal=text1+text2+text3+text4+text5+text6+text7+text8+text9+text10

    msg = MIMEText(textfinal)
    #sender
    msg['Subject'] = "VGM ACKNOWLEDGEMENT STATUS / CARRIER "+Carrier +"," +"TRACKING ID: "+Input
    msg['From'] = "itsyourgoal@gmail.com"
    msg['To'] = to
    msg['Cc'] = cc
    # Send the message via our own SMTP server.
    s = smtplib.SMTP('smtp.gmail.com',25)
    s.starttls()
    s.login("itsyourgoal@gmail.com","satya9005lubnag")
    s.send_message(msg)
    s.quit()
    
    

def GetToCC(Email):
    Email=Email.split(' ')
    print(Email)
    tocc=[]
    Email=Email[0].split('CC')
    to=Email[0].replace('TO:\xa0','')
    cc=Email[1].replace(':\xa0','')
    print(to)
    print(cc)
    tocc.append(to)
    tocc.append(cc)
    return tocc

f=open('C:\Automation\Maersk_POC\config.txt')
f.seek(0)
read=f.readlines()

prop=[]
for i in range(0,len(read)):
    z=read[i].split(' ')
    z=z[1].replace('\n','')
    #print(z)
    prop.append(z)
print(prop[2])



driver = webdriver.Chrome("D:\\chromedriver.exe")
#driver.fullscreen_window()
driver.implicitly_wait(10)
driver.get(str(prop[2]))
#assert "Facebook" in driver.title
elem = driver.find_element_by_id("username")
elem.send_keys(str(prop[0]))
elem = driver.find_element_by_id("password")
elem.send_keys(str(prop[1]))
elem = driver.find_element_by_id("loginBtn")
    
elem.send_keys(Keys.RETURN)
elem = driver.find_element_by_xpath("//*[contains(text(),'Accept')]")
    
elem.click()
time.sleep(5)
elem = driver.find_element_by_xpath("//*[@alt='Go to home']")
    
elem.click()

#//*[@alt='Go to home']

df1=pd.read_excel("C:\\Automation\\Maersk_POC\\TestData\\maersk_input.xlsx",sheetname='Sheet2')
a=df1.T
addmultipleListCol=[]
indexx=list(a.index)
print(indexx)
for i in a.columns:
    
    b=list(a[i])
    # define and assign all variabale
    Carrier=b[0]
    
    BLNo=b[1]
    BLNo=str(BLNo)
    BLNo=BLNo.replace('.0', '')
    print(BLNo)
    CarrierBookingNo=b[2] 
    CarrierBookingNo=str(CarrierBookingNo)
    CarrierBookingNo=CarrierBookingNo.replace('.0', '')
    print(CarrierBookingNo)
    
    ContainerNo=b[3]
    ContainerNo=str(ContainerNo)
    ContainerNo=ContainerNo.replace('.0', '')
    
    
    SONo=b[4]
    SONo=str(SONo)
    SONo=SONo.replace('.0', '')
    
    
    VGMCutOff=b[5]    
    VGMWeightAPLL=b[6]  
    VGMWeightAPLLL=str(VGMWeightAPLL)  
    VGMWeightMaersk=b[7]  
    #Result=
    #Message    
    Email=b[10]
    print(Email)
    #Email=Email.split(' ')
    #print(Email)
    #email=['TO:\xa0alex_law@apllogistics.com\nCC:\xa0schoun@gmail.com']
    #Email=Email[0].split('CC')
    #to=Email[0].replace('TO:\xa0','')
    #cc=Email[1].replace(':\xa0','')
    #print(to)
    #print(cc)
# Map Our Input with respect to matrix
    input=''
    if(Carrier=='MAEU'):
        
        if ((BLNo is not None) and (CarrierBookingNo is '_') and (ContainerNo is '_') and (SONo is '_')):
            input = BLNo
    
    
    
        elif (BLNo is '_' and CarrierBookingNo is not None and ContainerNo is '_' and SONo is '_'):
    
            input = CarrierBookingNo
    
    
    
        elif (BLNo is '_' and CarrierBookingNo is '_' and ContainerNo is not None and SONo is '_'):
        
            input = ContainerNo
        
        
        
        elif (BLNo is '_' and CarrierBookingNo is '_' and ContainerNo is '_' and SONo is not None):
        
            input = SONo
        
        
        
        elif (BLNo is not None and CarrierBookingNo is '_' and ContainerNo is not None and SONo is '_'):
        
            input = ContainerNo
        
        
        
        elif (BLNo is '_' and CarrierBookingNo is not None and ContainerNo is not None and SONo is '_'):
        
            input = ContainerNo
        
        
        
        elif (BLNo is '_' and CarrierBookingNo is '_' and ContainerNo is not None and SONo is not None):
        
            input = ContainerNo
        
        
        
        elif (BLNo is not None and CarrierBookingNo is not None and ContainerNo is '_' and SONo is '_'):
        
            input = CarrierBookingNo
        
        
        
        elif (BLNo is '_' and CarrierBookingNo is not None and ContainerNo is '_' and SONo is not None):
        
            input = CarrierBookingNo
        
        
        
        elif (BLNo is not None and CarrierBookingNo is '_' and ContainerNo is '_' and SONo is not None):
        
            input = BLNo
        
        
        
        elif(BLNo is not None and  CarrierBookingNo is not None and ContainerNo is not None and  SONo is not None):
        
            input = ContainerNo
        
        time.sleep(5)
        elem = driver.find_element_by_xpath("//*[contains(@id,'track-shipments')]")
        elem.send_keys(input)
        #(//*[@type='submit'])[3]
        
        elem = driver.find_element_by_xpath("(//button[@type='submit'])[3]")
        elem.click()
        time.sleep(5)
       # elem = driver.find_element_by_xpath("//*[contains(text(),'SEARCH')]")
        #elem.click()
        Element=False
        try:
                
            Element =driver.find_element_by_xpath("//*[text()='No results found']").is_displayed()
            
            a.loc['Result',i]="No Results Found"
            a.loc['Message',i]="Shipment for  "+input+" not found"
            
        except NoSuchElementException:
            print("No element found")
        if(Element!=True):
            
            elem = driver.find_element_by_xpath("//*[@href='#containers']")
            elem.click()
            containerCount=[]
            VGMWeight=[]
            #ned to create folder n path and naming convention as the given ducument 
            #driver.find_element_by_xpath("//*[@class='span2 ellipsis container-span']//strong")
            for elm in driver.find_elements_by_xpath("//*[@class='span2 ellipsis container-span']//strong"):
                print(elm.text)
                containerCount.append(elm.text)
            
            for elm in driver.find_elements_by_xpath("(//*[contains(@title,'VGM(V')])"):
                print(elm.text)
                wg=elm.text
                wg=wg.replace(" kg",'')
                wg=wg.replace("VGM",'')
                VGMWeight.append(wg)
             
            if(len(containerCount)!=1):
                print('multiple')
                driver.save_screenshot('C:\\Automation\\Maersk_POC\\ScreenShots\VGM_ACK\\'+input+'.png')
                #to write all container and VGM
                oo=list(a.index.values)
                #print(list(a.index.values))
                    #'VGM Weight -Maersk (KG)'
                a.loc[oo[7],i]="Multiple"
                #email
                a.loc['Result',i]="Passed"
                a.loc['Message',i]="4_OF_CONTAINERS_FOUND"
                
                
                p=30
                for j in range(0,len(containerCount)):
                    #need to write all value in table a
                    
                    print('all value with vgm')
                    allrowvallist=[]
                    allrowvallist.append(Carrier)
                    allrowvallist.append(BLNo)
                    allrowvallist.append(CarrierBookingNo)
                    
                    allrowvallist.append(containerCount[j])
                    allrowvallist.append(SONo)
                    allrowvallist.append(VGMCutOff)
                    allrowvallist.append(VGMWeightAPLL)
                    #allrowvallist.append(VGMWeightAPLLL)
                    allrowvallist.append(VGMWeight[j])
                    
                    allrowvallist.append("Passed")
                    allrowvallist.append("Multiple Containers are found for : "+input+','+containerCount[j]+','+VGMWeight[j])
                    allrowvallist.append("")
                    print(allrowvallist)
                    import string
                    import random
                    def id_generator(size=6, chars=string.ascii_uppercase + string.digits):
                        return ''.join(random.choice(chars) for _ in range(size))
                    #print(random.randint(0,9))
                    print(id_generator())
                    se= pd.Series(allrowvallist)
                    print(se)
                    addmultipleListCol.append(allrowvallist)
                    tocc=GetToCC(Email)
                    #Sendmail(Carrier,input,VGMWeightAPLL,VGMWeight[j],"passed","",str(tocc[0]),str(tocc[1]))
                    #se=np.array(allrowvallist)
                    #se=pd.Series(allrowvallist)
                    #a[p] = se.values#pd.Series(allrowvallist)
                    #p=p+1
                    #a[3]=allrowvallist
                    #p=p+1
                    #a.loc['VGM Weight -Maersk (KG)',i]=wg
                #email
                    #a.loc['Result',i]="Passed"
            else:
                print('single')     
                elem = driver.find_element_by_xpath("//*[contains(@class,'container-span')]//strong")
                con=elem.text
                #print(con)
                abc = driver.find_element_by_xpath("(//*[contains(@title,'VGM')])[2]")
                wg=abc.text
                #print(wg)
                wg=str(wg)
                wg=wg.replace(" kg",'')
                wg=wg.replace("VGM",'')
                #VGM
                #print(wg)
                #print(VGMWeightAPLLL)
                if wg.strip() == VGMWeightAPLLL.strip():
                    #print('bb')
                    #print(a.columns)
                    oo=list(a.index.values)
                    #print(list(a.index.values))
                    #'VGM Weight -Maersk (KG)'
                    a.loc[oo[7],i]=wg
                #email
                    a.loc['Result',i]="Passed"
                    
                    a.loc[oo[9],i]="VGM Weight Matching for "+SONo+"and"+ContainerNo+"."+ "VGM Weight ="+wg
                    tocc=GetToCC(Email)
                    #Sendmail(Carrier,input,VGMWeightAPLL,wg,"passed","",str(tocc[0]),str(tocc[1]))
                else:
                    oo=list(a.index.values)
                    a.loc[oo[7],i]=wg
                #email
                    a.loc['Result',i]="Failed"
                    a.loc[oo[9],i]="VGM Weight Mismatch between APLL System and Carrier s Website for Container No  "+ ContainerNo+","+"APLL System "+VGMWeightAPLLL+","+"Carrier System "+wg
                    tocc=GetToCC(Email)
                    #Sendmail(Carrier,input,VGMWeightAPLL,wg,"Failed","",str(tocc[0]),str(tocc[1]))
    else:
        
        a.loc['Result',i]="Failed"
    #excel write

    elem = driver.find_element_by_xpath("//*[@alt='Go to home']")
    
    elem.click()
    time.sleep(5)
print(a)

#s=pd.DataFrame(addmultipleListCol[0])
#a['i']=addmultipleListCol[0]
#pandas 
#t=pd.DataFrame(addmultipleListCol[1])

#a['j']=addmultipleListCol[1]
#a['k']=addmultipleListCol[2]
#a['p']=addmultipleListCol[4]
xx=a.T
    
s1 = pd.Series(addmultipleListCol[0], index=[indexx[0], indexx[1], indexx[2], indexx[3],indexx[4],indexx[5],indexx[6],indexx[7],indexx[8],indexx[9],indexx[10]])
result = xx.append(s1, ignore_index=True)
s1 = pd.Series(addmultipleListCol[1], index=[indexx[0], indexx[1], indexx[2], indexx[3],indexx[4],indexx[5],indexx[6],indexx[7],indexx[8],indexx[9],indexx[10]])
result = result.append(s1, ignore_index=True)
s1 = pd.Series(addmultipleListCol[2], index=[indexx[0], indexx[1], indexx[2], indexx[3],indexx[4],indexx[5],indexx[6],indexx[7],indexx[8],indexx[9],indexx[10]])
result = result.append(s1, ignore_index=True)
s1 = pd.Series(addmultipleListCol[3], index=[indexx[0], indexx[1], indexx[2], indexx[3],indexx[4],indexx[5],indexx[6],indexx[7],indexx[8],indexx[9],indexx[10]])
result = result.append(s1, ignore_index=True)

writer = pd.ExcelWriter('C:\\Automation\\Maersk_POC\\Report\\maersk_report.xlsx', engine='xlsxwriter')

result.to_excel(writer, sheet_name='Sheet5',startrow=0,index = False,startcol=0) 
workbook  = writer.book
worksheet = writer.sheets['Sheet5']
worksheet.set_column('A:K', 20)
# Add a header format.
header_format = workbook.add_format({
    'bold': True,
    'text_wrap': False,
    'valign': 'top',
    'fg_color': '#D7E4BC',
    'border': 1
    
})

# Write the column headers with the defined format.
for col_num, value in enumerate(result.columns.values):
    worksheet.write(0, col_num, value, header_format)


writer.save()
    
driver.close()
