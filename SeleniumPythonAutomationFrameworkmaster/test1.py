

from selenium import webdriver

# Firefox 46 is supported by Selenium 2.5 ##
driver = webdriver.Firefox()

driver.get('https://www.google.com/')

driver.find_element_by_name('q').send_keys('software testing')

driver.find_element_by_name('btnG').click()