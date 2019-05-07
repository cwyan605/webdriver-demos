const puppeteer = require('puppeteer');

module.exports = async function driver() {
  const browser = await puppeteer.launch({ headless: false });
  // const browser = await puppeteer.launch(); //无头浏览器
  const page = await browser.newPage();

  await page.goto('https://www.baidu.com');
  await page.evaluate(() => {
    //输入关键词webdriver
    document.querySelector('#kw').value = 'webdriver';
    //点击百度一下
    document.querySelector('#su').click();
  });

  //等待10s后关闭browser
  await page.waitFor(10000);
  browser.close();
};
