import { browser, element, by } from 'protractor';

export class TreinamentoAngular4SolutisPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('app-root h1')).getText();
  }
}
