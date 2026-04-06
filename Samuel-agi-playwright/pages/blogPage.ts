import { Page, Locator } from '@playwright/test';

export class BlogPage {
  readonly page: Page;
  readonly searchInput: Locator;
  readonly results: Locator;
  readonly noResultsMessage: Locator;

  constructor(page: Page) {
    this.page = page;

    this.searchInput = page.locator('input[type="search"]');
    this.results = page.locator('article');
    this.noResultsMessage = page.locator('text=/nenhum resultado/i');
  }

  async search(term: string) {
    // Visualização via URL
    await this.page.goto(`https://blogdoagi.com.br/?s=${term}`);
  }
}