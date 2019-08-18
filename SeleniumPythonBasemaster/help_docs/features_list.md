<a id="feature_list"></a>
### ![http://seleniumbase.com](https://cdn2.hubspot.net/hubfs/100006/images/super_logo_tiny.png "SeleniumBase") **SeleniumBase Features:**
* A complete test automation framework for building & running reliable testing scripts.
* Uses [Pytest](https://docs.pytest.org/en/latest/) and [Nose](http://nose.readthedocs.io/en/latest/) runners for test discovery, organization, execution, and logging.
* Includes [console scripts](https://github.com/seleniumbase/SeleniumBase/blob/master/seleniumbase/console_scripts/ReadMe.md) that save you time by installing web drivers automatically, etc. 
* Includes a [website tour builder](https://github.com/seleniumbase/SeleniumBase/blob/master/examples/tour_examples/ReadMe.md) for creating and running walkthroughs on any website.
* Works on multiple platforms such as Mac, Windows, Linux, and [Docker](https://github.com/seleniumbase/SeleniumBase/blob/master/integrations/docker/ReadMe.md).
* Uses a [flexible command-line interface](https://github.com/seleniumbase/SeleniumBase/blob/master/help_docs/command_line.md) to customize & configure test runs.
* Has [Python libraries](https://github.com/seleniumbase/SeleniumBase/tree/master/seleniumbase) for helping you do more with Selenium-WebDriver.
* Has [Plugins](https://github.com/seleniumbase/SeleniumBase/tree/master/seleniumbase/plugins) for logging data and screenshots automatically. ([Click to learn more](https://github.com/seleniumbase/SeleniumBase/blob/master/examples/example_logs/ReadMe.md))
* Uses a [global config file](https://github.com/seleniumbase/SeleniumBase/blob/master/seleniumbase/config/settings.py) for configuring SeleniumBase to your specific needs.
* Backwards-compatible with [WebDriver](http://www.seleniumhq.org/projects/webdriver/). (Use ``self.driver`` anywhere.)
* Can run tests through a proxy server. (Use ``--proxy=IP_ADDRESS:PORT``)
* Can handle Google Authenticator logins by using the [Python one-time password library](https://pyotp.readthedocs.io/en/latest/).
* Includes a hybrid-automation solution called **[MasterQA](https://github.com/seleniumbase/SeleniumBase/blob/master/seleniumbase/masterqa/ReadMe.md)** to speed up manual testing.
* Includes integrations with [MySQL](https://github.com/seleniumbase/SeleniumBase/blob/master/seleniumbase/core/testcase_manager.py), [Selenium Grid](https://github.com/seleniumbase/SeleniumBase/tree/master/seleniumbase/utilities/selenium_grid), [Google Cloud](https://github.com/seleniumbase/SeleniumBase/tree/master/integrations/google_cloud/ReadMe.md), [Amazon S3](https://github.com/seleniumbase/SeleniumBase/blob/master/seleniumbase/plugins/s3_logging_plugin.py), and [NodeJS](https://github.com/seleniumbase/SeleniumBase/tree/master/integrations/node_js).
* Includes a [tool to convert Selenium IDE recordings](https://github.com/seleniumbase/SeleniumBase/tree/master/seleniumbase/utilities/selenium_ide) into clean, robust SeleniumBase scripts.
* Written in Python, but can also make JavaScript calls using ``self.execute_script()``.
* Includes useful Python decorators and password obfuscation methods. ([Learn more here](https://github.com/seleniumbase/SeleniumBase/blob/master/seleniumbase/common/ReadMe.md))
