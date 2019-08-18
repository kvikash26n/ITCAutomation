# -*- coding: utf-8 -*-
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest, time, re
from POM import Login


class IDEScript1(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(30)
        self.base_url = "http://newtours.demoaut.com/"
        self.verificationErrors = []
        self.accept_next_alert = True
    
    def test_i_d_e_script1(self):
        driver = self.driver
        driver.get(self.base_url + "/")

        login = Login(driver)

        login.UserName("mercury")
        login.Password("mercury")
        login.SignIn()



        # driver.find_element_by_name("userName").clear()
        # driver.find_element_by_name("userName").send_keys("mercury")
        # driver.find_element_by_name("password").clear()
        # driver.find_element_by_name("password").send_keys("mercury")
        # driver.find_element_by_name("login").click()


        # ERROR: Caught exception [Error: Dom locators are not implemented yet!]
        driver.find_element_by_name("tripType").click()
        Select(driver.find_element_by_name("passCount")).select_by_visible_text("2")
        Select(driver.find_element_by_name("passCount")).select_by_visible_text("1")
        Select(driver.find_element_by_name("fromPort")).select_by_visible_text("Frankfurt")
        Select(driver.find_element_by_name("fromMonth")).select_by_visible_text("May")
        Select(driver.find_element_by_name("fromDay")).select_by_visible_text("3")
        Select(driver.find_element_by_name("fromDay")).select_by_visible_text("2")
        Select(driver.find_element_by_name("toPort")).select_by_visible_text("Frankfurt")
        Select(driver.find_element_by_name("toPort")).select_by_visible_text("Acapulco")
        Select(driver.find_element_by_name("toMonth")).select_by_visible_text("May")
        Select(driver.find_element_by_name("toDay")).select_by_visible_text("3")
        driver.find_element_by_css_selector("font > font > input[name=\"servClass\"]").click()
        Select(driver.find_element_by_name("airline")).select_by_visible_text("Blue Skies Airlines")
        driver.find_element_by_name("findFlights").click()
        # ERROR: Caught exception [Error: Dom locators are not implemented yet!]
        # ERROR: Caught exception [Error: Dom locators are not implemented yet!]
        driver.find_element_by_name("reserveFlights").click()
        driver.find_element_by_name("passFirst0").clear()
        driver.find_element_by_name("passFirst0").send_keys("NAssir")
        driver.find_element_by_name("passLast0").clear()
        driver.find_element_by_name("passLast0").send_keys("Malik")
        driver.find_element_by_name("passFirst0").clear()
        driver.find_element_by_name("passFirst0").send_keys("Nassir")
        Select(driver.find_element_by_name("creditCard")).select_by_visible_text("MasterCard")
        driver.find_element_by_name("creditnumber").clear()
        driver.find_element_by_name("creditnumber").send_keys("007")
        Select(driver.find_element_by_name("cc_exp_dt_mn")).select_by_visible_text("02")
        Select(driver.find_element_by_name("cc_exp_dt_yr")).select_by_visible_text("2002")
        driver.find_element_by_name("buyFlights").click()
        driver.find_element_by_xpath("//td[2]/a/img").click()
    
    def is_element_present(self, how, what):
        try: self.driver.find_element(by=how, value=what)
        except NoSuchElementException as e: return False
        return True
    
    def is_alert_present(self):
        try: self.driver.switch_to_alert()
        except NoAlertPresentException as e: return False
        return True
    
    def close_alert_and_get_its_text(self):
        try:
            alert = self.driver.switch_to_alert()
            alert_text = alert.text
            if self.accept_next_alert:
                alert.accept()
            else:
                alert.dismiss()
            return alert_text
        finally: self.accept_next_alert = True
    
    def tearDown(self):
        self.driver.quit()
        self.assertEqual([], self.verificationErrors)

if __name__ == "__main__":
    unittest.main()


class login():

    def UserName(self, user_name):
        print("Enter user name in username field")