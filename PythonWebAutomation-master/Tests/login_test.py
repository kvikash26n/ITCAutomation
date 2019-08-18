import pytest
from Pages.login_page import Loginpage
from selenium import webdriver
from Utils import utils as utils
import allure


#@pytest.mark.usefixtures("setup")
class TestLogin():

    @pytest.fixture(scope="class")
    def setup(self):
        global driver
        driver = webdriver.Chrome(
            executable_path="C:\\Users\\C5261196\\Downloads\\chromedriver_win32\\chromedriver.exe")
        driver.maximize_window()
        yield
        driver.close()

    def test_login_valid(self,setup):
        driver.get(utils.URL)
        login = Loginpage(driver)
        login.enter_email_textbox(utils.USERNAME)
        login.enter_password_textbox(utils.PASSWORD)
        login.click_login_button()
