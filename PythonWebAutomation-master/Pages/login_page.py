import pytest

class Loginpage():
      def __init__(self, driver):
        self.driver = driver
        self.email_textbox_xpath = "//input[@type='email']"
        self.password_textbox_xpath = "//input[@type='password']"
        self.login_Button_xpath = "//input[@value='Log In']"

      def enter_email_textbox(self, emailfield):
        self.driver.find_element_by_xpath(self.email_textbox_xpath).send_keys(emailfield)

      def enter_password_textbox(self, passwordfield):
        self.driver.find_element_by_xpath(self.email_textbox_xpath).send_keys(passwordfield)

      def click_login_button(self):
        self.driver.find_element_by_xpath(self.login_Button_xpath).click()