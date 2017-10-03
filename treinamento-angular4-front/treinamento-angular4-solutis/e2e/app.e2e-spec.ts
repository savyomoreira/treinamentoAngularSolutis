import { TreinamentoAngular4SolutisPage } from './app.po';

describe('treinamento-angular4-solutis App', () => {
  let page: TreinamentoAngular4SolutisPage;

  beforeEach(() => {
    page = new TreinamentoAngular4SolutisPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
