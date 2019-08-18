import pytest
from selenium import webdriver
from Tests.login_test import TestLogin

def pytest_addoption(parser):
    parser.addoption("--browser",action="store",default="chrome")


@pytest.fixture(scope="class")
def setup(request):
    print("initiating chrome driver")
    #driver = webdriver.Chrome("C:\\Users\\C5261196\\Downloads\\chromedriver_win32\\chromedriver.exe")
    #driver.get("http://seleniumeasy.com/test")
    browser = request.config.getoption("--browser")
    if browser == 'chrome':
        driver = webdriver.Chrome(
            executable_path="C:\\Users\\C5261196\\Downloads\\chromedriver_win32\\chromedriver.exe")
    elif browser == 'firefox':
        driver = webdriver.Chrome(
            executable_path="C:\\Users\\C5261196\\Downloads\\chromedriver_win32\\chromedriver.exe")
    driver.maximize_window()
    request.cls.driver = driver

    yield driver
    driver.close()





