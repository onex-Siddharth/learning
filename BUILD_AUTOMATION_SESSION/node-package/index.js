const express = require('express');
const helper = require('./utils/helper');
require('dotenv').config();

const app = express();
const PORT = process.env.PORT || 3000;

// Middleware
app.use(express.json());

// Routes
app.get('/', (req, res) => {
  res.send(helper.generateWelcomeMessage());
});

app.get('/users', async (req, res) => {
  try {
    const response = await helper.fetchUsers();
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error: 'Failed to fetch users' });
  }
});

// Health check endpoint
app.get('/health', (req, res) => {
  res.status(200).json({ status: 'OK' });
});

// Start server
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});

module.exports = app; // For testing purposes