'''
Created on Oct 4, 2018

@author: 29265
'''
# Python code to illustrate Sending mail 

# Python code to illustrate Sending mail 

# to multiple users 

# from your Gmail account 

import smtplib

  

# list of email_id to send the mail

li = ["sonu140191@gmail.com","",""]

for i in range(1,2):

    for i in range(len(li)):

        s = smtplib.SMTP('smtp.gmail.com', 587)

        s.starttls()

        s.login("youremailid", "Password")

        message = "Why are you still using GMAIL ? best wishes from satyam"

        s.sendmail("sender_email_id", li[i], message)

        s.quit()