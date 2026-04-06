import { test, expect } from '@playwright/test';
import { BlogPage } from '../pages/blogPage';

test.describe('Busca no Blog do Agi', () => {

  test('Deve retornar resultados ao buscar termo válido', async ({ page }) => {
    const blog = new BlogPage(page);

    await blog.search('INSS');

    await expect(blog.results.first()).toBeVisible();

    const count = await blog.results.count();
    expect(count).toBeGreaterThan(0);
  });

  test('Deve exibir mensagem ao não encontrar resultados', async ({ page }) => {
  const blog = new BlogPage(page);

  await blog.search('motoclube');

  const count = await blog.results.count();
  expect(count).toBe(0);
});

});