const axios = require('axios');

function generateWelcomeMessage() {
  return 'Welcome to Node Package Demo!';
}

async function fetchUsers() {
  const response = await axios.get('https://jsonplaceholder.typicode.com/users');
  return response;
}

function calculateSum(a, b) {
  return a + b;
}

module.exports = {
  generateWelcomeMessage,
  fetchUsers,
  calculateSum
};