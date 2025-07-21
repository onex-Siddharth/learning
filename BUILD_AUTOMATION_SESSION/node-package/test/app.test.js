const helper = require('../utils/helper');
const app = require('../index');
const supertest = require('supertest');

describe('Helper Functions', () => {
  test('generates welcome message', () => {
    expect(helper.generateWelcomeMessage()).toBe('Welcome to Node Package Demo!');
  });

  test('calculates sum correctly', () => {
    expect(helper.calculateSum(2, 3)).toBe(5);
  });
});

describe('API Endpoints', () => {
  test('GET / returns welcome message', async () => {
    const response = await supertest(app).get('/');
    expect(response.statusCode).toBe(200);
    expect(response.text).toContain('Welcome');
  });

  test('GET /health returns OK status', async () => {
    const response = await supertest(app).get('/health');
    expect(response.statusCode).toBe(200);
    expect(response.body.status).toBe('OK');
  });
});