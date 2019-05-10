const puppeteer = require('puppeteer');

module.exports = async function driver() {
  const browser = await puppeteer.launch({ headless: false }); // 设置headless：false，查看执行过程
  // const browser = await puppeteer.launch(); //一般用无头浏览器
  const page = await browser.newPage();

  await page.goto('https://www.baidu.com');
  await page.evaluate(() => {
    //输入关键词webdriver
    document.querySelector('#kw').value = 'webdriver';
    //点击百度一下
    document.querySelector('#su').click();
  });

  //等待3s
  await page.waitFor(3000);

  //截屏
  await page.screenshot({ path: 'example.png' });

  //关闭browser
  browser.close();
};
